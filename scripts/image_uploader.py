#!/usr/bin/env python3
import os
import json
import time
from pathlib import Path
from providers.cloudinary_provider import CloudinaryProvider

# Configuration
REPO_ROOT = Path(__file__).resolve().parents[1]
IMAGES_DIR = REPO_ROOT / "images" # Adjust if your images are elsewhere
MAP_FILE = REPO_ROOT / "assets" / "image_map.json"
PROVIDER_NAME = os.environ.get("IMAGE_PROVIDER", "cloudinary")

def get_provider():
    if PROVIDER_NAME == "cloudinary":
        return CloudinaryProvider()
    else:
        print(f"Unknown provider: {PROVIDER_NAME}")
        return None

def load_map():
    if MAP_FILE.exists():
        try:
            return json.loads(MAP_FILE.read_text(encoding="utf-8"))
        except:
            return {}
    return {}

def save_map(data):
    MAP_FILE.parent.mkdir(parents=True, exist_ok=True)
    MAP_FILE.write_text(json.dumps(data, indent=2), encoding="utf-8")

def main():
    print(f"--- Starting Image Uploader (Provider: {PROVIDER_NAME}) ---")
    
    if not IMAGES_DIR.exists():
        print(f"Images directory not found: {IMAGES_DIR}")
        return

    provider = get_provider()
    if not provider:
        return

    image_map = load_map()
    changes_count = 0

    # Extensions to look for
    valid_exts = {".png", ".jpg", ".jpeg", ".gif", ".webp", ".svg"}

    # Walk through images directory
    for file_path in IMAGES_DIR.rglob("*"):
        if file_path.suffix.lower() not in valid_exts:
            continue

        # Relative path key (e.g., "/images/foo.png")
        # We ensure it starts with / to match HTML src
        rel_path = f"/{file_path.relative_to(REPO_ROOT)}"
        
        # Check if already mapped
        if rel_path in image_map:
            # Optional: Add logic to check file modification time vs last_updated
            # For now, skip if exists to save bandwidth/API calls
            continue

        print(f"Uploading: {rel_path}...")
        cloud_url = provider.upload(str(file_path))

        if cloud_url:
            image_map[rel_path] = {
                "url": cloud_url,
                "provider": PROVIDER_NAME,
                "last_updated": int(time.time()),
                "ocr_text": None # Placeholder
            }
            changes_count += 1
            print(f"  -> Success: {cloud_url}")
        else:
            print(f"  -> Failed to upload.")

    if changes_count > 0:
        save_map(image_map)
        print(f"--- Complete. Updated {changes_count} images in map. ---")
    else:
        print("--- Complete. No new images to upload. ---")

if __name__ == "__main__":
    main()
