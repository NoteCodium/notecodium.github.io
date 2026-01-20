#!/usr/bin/env python3
import json
import os
import re
from pathlib import Path


REPO_ROOT = Path(__file__).resolve().parents[1]
CONFIG_YML = REPO_ROOT / "_config.yml"
OUTPUT_JSON = REPO_ROOT / "assets" / "files.json"


def load_excludes_from_config(path: Path) -> set[str]:
    """
    Minimal YAML-ish parser for the `exclude:` list in _config.yml (no external deps).
    """
    if not path.exists():
        return set()

    excludes: list[str] = []
    in_exclude = False
    for raw in path.read_text(encoding="utf-8", errors="replace").splitlines():
        line = raw.strip()
        if not line or line.startswith("#"):
            continue

        if re.match(r"^exclude\s*:", line):
            in_exclude = True
            continue

        if in_exclude:
            # Stop if we hit another top-level key
            if re.match(r"^[A-Za-z0-9_]+\s*:", line) and not line.startswith("-"):
                break

            if line.startswith("-"):
                # "- path  # comment"
                item = line[1:].strip()
                item = item.split("#", 1)[0].strip()
                if item:
                    excludes.append(item)

    return set(excludes)


def is_excluded(rel_path: Path, excludes: set[str]) -> bool:
    # exclude matches repo-root relative first segment or exact path
    parts = rel_path.parts
    if not parts:
        return False
    first = parts[0]
    if first in excludes:
        return True
    if str(rel_path).replace("\\", "/") in excludes:
        return True
    return False


def main() -> int:
    excludes = load_excludes_from_config(CONFIG_YML)

    items: list[dict] = []
    for md in REPO_ROOT.rglob("*.md"):
        rel = md.relative_to(REPO_ROOT)

        # Skip excluded dirs (e.g., _site, ADCLCHJC, supernotes)
        if is_excluded(rel, excludes):
            continue

        name = md.name
        if "index" in name or "404" in name:
            continue

        dir_rel = rel.parent.as_posix()
        stem = md.stem

        # Jekyll default for pages: same path with .html extension.
        # Store WITHOUT baseurl; JS will prefix baseurl at runtime.
        url_path = f"/{dir_rel}/{stem}.html" if dir_rel else f"/{stem}.html"

        items.append({"name": name, "path": url_path, "dir": dir_rel})

    items.sort(key=lambda x: (x["dir"], x["name"]))

    OUTPUT_JSON.parent.mkdir(parents=True, exist_ok=True)
    OUTPUT_JSON.write_text(json.dumps(items, indent=2), encoding="utf-8")
    print(f"Wrote {OUTPUT_JSON} ({len(items)} entries)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

