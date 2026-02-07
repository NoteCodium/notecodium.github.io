import os
import re
import requests
import time
from pathlib import Path
from urllib.parse import urlparse, unquote

# Configuration
REPO_ROOT = Path(__file__).resolve().parents[1]
SUPERNOTES_DIR = REPO_ROOT / "supernotes"
IMAGES_DIR = REPO_ROOT / "images"

# Regex to find markdown images: ![alt](url)
# We specifically look for the AWS domain mentioned
AWS_DOMAIN = "supernotes-resources.s3.amazonaws.com"
# Capture the URL part
IMG_REGEX = re.compile(r'!\[(.*?)\]\((https?://' + re.escape(AWS_DOMAIN) + r'/.*?)\)')

def download_image(url, dest_folder):
    """
    Downloads image from url to dest_folder.
    Returns the local filename if successful, None otherwise.
    """
    try:
        # Extract filename from URL
        parsed = urlparse(url)
        filename = os.path.basename(unquote(parsed.path))
        
        # Determine destination path
        dest_path = dest_folder / filename
        
        # If file already exists, skip download (idempotent)
        if dest_path.exists():
            # print(f"  Skipping (exists): {filename}")
            return filename

        print(f"  Downloading: {url}")
        response = requests.get(url, stream=True)
        if response.status_code == 200:
            dest_folder.mkdir(parents=True, exist_ok=True)
            with open(dest_path, 'wb') as f:
                for chunk in response.iter_content(1024):
                    f.write(chunk)
            return filename
        else:
            print(f"  Failed (Status {response.status_code}): {url}")
            return None
    except Exception as e:
        print(f"  Error downloading {url}: {e}")
        return None

def process_file(file_path):
    """
    Scans a markdown file, downloads images, and updates links.
    """
    content = file_path.read_text(encoding="utf-8")
    
    # Find all matches
    matches = IMG_REGEX.findall(content)
    if not matches:
        return False

    print(f"\nProcessing: {file_path.relative_to(REPO_ROOT)}")
    
    new_content = content
    changes_made = 0
    
    for alt_text, url in matches:
        filename = download_image(url, IMAGES_DIR)
        if filename:
            # Construct new relative path
            # Original: https://...
            # New: ../images/filename.png (Relative to supernotes/)
            new_link = f"../images/{filename}"
            
            # Replace in content
            old_markdown = f"![{alt_text}]({url})"
            new_markdown = f"![{alt_text}]({new_link})"
            
            if new_markdown != old_markdown:
                new_content = new_content.replace(old_markdown, new_markdown)
                changes_made += 1

    if changes_made > 0:
        file_path.write_text(new_content, encoding="utf-8")
        print(f"  Updated {changes_made} links.")
        return True
    return False

def main():
    if not SUPERNOTES_DIR.exists():
        print(f"Directory not found: {SUPERNOTES_DIR}")
        return

    print(f"--- Starting Migration ---")
    print(f"Source: {SUPERNOTES_DIR}")
    print(f"Target: {IMAGES_DIR}")
    
    count = 0
    # Process all .md files
    for file_path in SUPERNOTES_DIR.rglob("*.md"):
        if process_file(file_path):
            count += 1
            
    print(f"\n--- Migration Complete. Updated {count} files. ---")

if __name__ == "__main__":
    main()
