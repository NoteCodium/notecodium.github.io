#!/usr/bin/env python3
"""
Convert all .ipynb files under transfernew/ into Jekyll-friendly .md files.

- Writes one .md next to each .ipynb (same stem).
- Extracts ALL embedded images (cell outputs + markdown attachments) into a SINGLE folder:
  transfernew/notebook_images/
- Renames images deterministically (includes notebook relative path to avoid collisions).
- Rewrites markdown to reference images via root-relative paths:
  /transfernew/notebook_images/<image>.png
- Wraps content in {% raw %} ... {% endraw %} to avoid Liquid parsing issues.

No third-party dependencies required (parses .ipynb as JSON).
"""

from __future__ import annotations

import base64
import json
import re
from pathlib import Path
from typing import Any, Dict, Iterable, Tuple


REPO_ROOT = Path(__file__).resolve().parents[1]
TRANSFERNEW = REPO_ROOT / "transfernew"
IMAGES_DIR = TRANSFERNEW / "notebook_images"


def _read_json(path: Path) -> Dict[str, Any]:
    raw = path.read_text(encoding="utf-8", errors="replace")
    if not raw.strip():
        # Some notebooks in the tree are empty placeholder files.
        return {"cells": [], "metadata": {}, "nbformat": 4, "nbformat_minor": 5}
    return json.loads(raw)


def _safe_slug(s: str) -> str:
    # Keep it filesystem-safe and stable across OSes
    s = s.replace("\\", "/")
    s = re.sub(r"[^A-Za-z0-9._/-]+", "_", s)
    s = s.strip("_")
    s = s.replace("/", "_")
    if not s:
        return "notebook"
    return s


def _ensure_dir(path: Path) -> None:
    path.mkdir(parents=True, exist_ok=True)


def _decode_b64(data: str) -> bytes:
    # ipynb base64 can contain newlines
    return base64.b64decode(data.encode("utf-8"), validate=False)


def _iter_cells(nb: Dict[str, Any]) -> Iterable[Dict[str, Any]]:
    cells = nb.get("cells", [])
    if isinstance(cells, list):
        for c in cells:
            if isinstance(c, dict):
                yield c


def _cell_source(cell: Dict[str, Any]) -> str:
    src = cell.get("source", "")
    if isinstance(src, list):
        return "".join(str(x) for x in src)
    return str(src)


def _write_image_bytes(filename: str, data: bytes) -> None:
    _ensure_dir(IMAGES_DIR)
    out_path = IMAGES_DIR / filename
    out_path.write_bytes(data)


def _front_matter(title: str) -> str:
    # Keep minimal; repo defaults already apply layout: default
    return f"""---\ntitle: {title}\n---\n\n"""


def _wrap_raw(body: str) -> str:
    return "{% raw %}\n" + body.rstrip() + "\n{% endraw %}\n"


ATTACHMENT_RE = re.compile(r"\(\s*attachment:([^)]+?)\s*\)")


def _extract_attachments(
    nb_rel_slug: str,
    cell: Dict[str, Any],
    start_index: int,
) -> Tuple[Dict[str, str], int]:
    """
    Extract markdown-cell attachments (cell.attachments).
    Returns (attachment_name -> new_root_relative_path, next_index).
    """
    mapping: Dict[str, str] = {}
    attachments = cell.get("attachments")
    if not isinstance(attachments, dict):
        return mapping, start_index

    idx = start_index
    for att_name, mime_map in attachments.items():
        if not isinstance(mime_map, dict):
            continue

        # Prefer png, then jpeg
        if "image/png" in mime_map:
            ext = "png"
            b64 = mime_map.get("image/png")
        elif "image/jpeg" in mime_map:
            ext = "jpg"
            b64 = mime_map.get("image/jpeg")
        else:
            continue

        if isinstance(b64, list):
            b64 = "".join(str(x) for x in b64)
        if not isinstance(b64, str) or not b64.strip():
            continue

        filename = f"{nb_rel_slug}__att_{idx:04d}.{ext}"
        _write_image_bytes(filename, _decode_b64(b64))
        mapping[att_name] = f"/transfernew/notebook_images/{filename}"
        idx += 1

    return mapping, idx


def _rewrite_attachment_links(md: str, mapping: Dict[str, str]) -> str:
    if not mapping:
        return md

    def repl(m: re.Match[str]) -> str:
        name = m.group(1).strip()
        new = mapping.get(name)
        if not new:
            return m.group(0)
        return f"({new})"

    return ATTACHMENT_RE.sub(repl, md)


def _extract_output_images(
    nb_rel_slug: str,
    outputs: Iterable[Dict[str, Any]],
    start_index: int,
) -> Tuple[list[str], int]:
    """
    Extract image outputs; returns (markdown_lines, next_index).
    """
    md_lines: list[str] = []
    idx = start_index

    for out in outputs:
        if not isinstance(out, dict):
            continue

        otype = out.get("output_type")

        # Text streams
        if otype == "stream":
            text = out.get("text", "")
            if isinstance(text, list):
                text = "".join(str(x) for x in text)
            text = str(text).rstrip()
            if text:
                md_lines.append("```text")
                md_lines.append(text)
                md_lines.append("```")
                md_lines.append("")
            continue

        data = out.get("data")
        if not isinstance(data, dict):
            # Some errors are in "traceback"
            tb = out.get("traceback")
            if isinstance(tb, list) and tb:
                md_lines.append("```text")
                md_lines.extend(str(x).rstrip("\n") for x in tb)
                md_lines.append("```")
                md_lines.append("")
            continue

        # Prefer images if present
        if "image/png" in data or "image/jpeg" in data:
            if "image/png" in data:
                ext = "png"
                b64 = data.get("image/png")
            else:
                ext = "jpg"
                b64 = data.get("image/jpeg")

            if isinstance(b64, list):
                b64 = "".join(str(x) for x in b64)
            if isinstance(b64, str) and b64.strip():
                filename = f"{nb_rel_slug}__out_{idx:04d}.{ext}"
                _write_image_bytes(filename, _decode_b64(b64))
                md_lines.append(f"![](/transfernew/notebook_images/{filename})")
                md_lines.append("")
                idx += 1
                continue

        # Fallback to text/plain if present
        if "text/plain" in data:
            text = data.get("text/plain")
            if isinstance(text, list):
                text = "".join(str(x) for x in text)
            text = str(text).rstrip()
            if text:
                md_lines.append("```text")
                md_lines.append(text)
                md_lines.append("```")
                md_lines.append("")

    return md_lines, idx


def convert_notebook(ipynb_path: Path) -> None:
    try:
        nb = _read_json(ipynb_path)
    except Exception as e:
        # Keep the pipeline moving; emit a tiny page so Jekyll doesn't break on missing references.
        md_out_path = ipynb_path.with_suffix(".md")
        title = ipynb_path.stem
        content = _front_matter(title=title) + _wrap_raw(f"*(Failed to parse notebook: {e})*")
        md_out_path.write_text(content, encoding="utf-8")
        return
    rel = ipynb_path.relative_to(REPO_ROOT).as_posix()  # transfernew/...
    nb_rel_slug = _safe_slug(rel.removesuffix(".ipynb"))

    md_out_path = ipynb_path.with_suffix(".md")
    title = ipynb_path.stem

    image_index = 1
    body_lines: list[str] = []

    for cell in _iter_cells(nb):
        ctype = cell.get("cell_type")

        if ctype == "markdown":
            mapping, image_index = _extract_attachments(nb_rel_slug, cell, image_index)
            md = _cell_source(cell).rstrip()
            md = _rewrite_attachment_links(md, mapping)
            if md:
                body_lines.append(md)
                body_lines.append("")
            continue

        if ctype == "code":
            source = _cell_source(cell).rstrip("\n")
            if source.strip():
                body_lines.append("```python")
                body_lines.append(source)
                body_lines.append("```")
                body_lines.append("")

            outputs = cell.get("outputs", [])
            if isinstance(outputs, list) and outputs:
                out_md, image_index = _extract_output_images(nb_rel_slug, outputs, image_index)
                body_lines.extend(out_md)
            continue

        # raw / unknown cell types: emit as-is
        raw = _cell_source(cell).rstrip()
        if raw:
            body_lines.append(raw)
            body_lines.append("")

    content = _front_matter(title=title) + _wrap_raw("\n".join(body_lines))
    md_out_path.write_text(content, encoding="utf-8")


def main() -> int:
    if not TRANSFERNEW.exists():
        raise SystemExit(f"Missing folder: {TRANSFERNEW}")

    _ensure_dir(IMAGES_DIR)

    ipynb_files = sorted(
        [p for p in TRANSFERNEW.rglob("*.ipynb")] + [p for p in TRANSFERNEW.rglob("*.IPYNB")]
    )
    for p in ipynb_files:
        convert_notebook(p)

    print(f"Converted {len(ipynb_files)} notebooks. Images in {IMAGES_DIR}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

