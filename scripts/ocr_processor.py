
import os
import sys
import json
import time
import requests
from pathlib import Path
from dotenv import load_dotenv

# Load environment variables
load_dotenv()

OCR_API_KEY = os.getenv("OCR_SPACE_API_KEY", "helloworld")
OCR_API_URL = "https://api.ocr.space/parse/image"

REPO_ROOT = Path(__file__).resolve().parents[1]
CONTENT_DIR = REPO_ROOT / "CONTENT"
CONFIG_FILE = REPO_ROOT / "ocr_config.json"
MAP_FILE = REPO_ROOT / "assets" / "image_map.json"

def ocr_space_file(filename, overlay=False, api_key=OCR_API_KEY, language='eng'):
    """
    OCR.space API request with local file.
    """
    payload = {
        'isOverlayRequired': overlay,
        'apikey': api_key,
        'language': language,
        'detectOrientation': True,
        'scale': True,
        'OCREngine': 2 
    }
    
    with open(filename, 'rb') as f:
        r = requests.post(OCR_API_URL, 
                          files={filename: f}, 
                          data=payload, 
                          timeout=30)
    
    return r.content.decode()

def load_json(path):
    if path.exists():
        try:
            return json.loads(path.read_text(encoding="utf-8"))
        except:
            return {}
    return {}

def save_json(path, data):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(data, indent=2, sort_keys=True), encoding="utf-8")

def process_image(file_path, image_map):
    """
    Process a single image: OCR if valid and not already done.
    Returns True if map was updated.
    """
    # Create relative path key (e.g., /CONTENT/DSA/image.png)
    rel_path = f"/{file_path.relative_to(REPO_ROOT)}"
    
    # Check if exists and has OCR text
    if rel_path in image_map:
        if image_map[rel_path].get("ocr_text"):
            # print(f"Skipping (already OCR'd): {rel_path}")
            return False
    
    print(f"Processing: {rel_path}...")
    
    try:
        result_json = ocr_space_file(str(file_path))
        result = json.loads(result_json)
        
        if result.get("IsErroredOnProcessing"):
            error_msg = result.get("ErrorMessage")
            print(f"Error processing {file_path.name}: {error_msg}")
            if isinstance(error_msg, list):
                 error_msg = " ".join(str(e) for e in error_msg)
            if "limit" in str(error_msg).lower():
                 print("API Limit reached. Waiting 2 seconds...")
                 time.sleep(2)
            return False
            
        parsed_results = result.get("ParsedResults")
        if parsed_results:
            extracted_text = parsed_results[0].get("ParsedText")
            
            if extracted_text:
                # Update map
                if rel_path not in image_map:
                     image_map[rel_path] = {}
                
                image_map[rel_path]["ocr_text"] = extracted_text
                image_map[rel_path]["last_updated"] = int(time.time())
                
                # valid_providers = {"cloudinary", "aws", "azure"}
                # If provider is not set or not one of the cloud ones, assume local file scan
                if "provider" not in image_map[rel_path]:
                     image_map[rel_path]["provider"] = "local" # Indicates it's just a local file scan
                if "url" not in image_map[rel_path]:
                     image_map[rel_path]["url"] = None

                print(f"  -> Success. Text length: {len(extracted_text)}")
                return True
            else:
                print(f"  -> No text found.")
                # Mark as scanned to avoid retrying immediately? 
                # For now, we leave it null so it might be retried or manual override.
                # Or set to "" to indicate "scanned, no text".
                if rel_path not in image_map:
                     image_map[rel_path] = {}
                image_map[rel_path]["ocr_text"] = "" 
                image_map[rel_path]["last_updated"] = int(time.time())
                return True
        else:
            print(f"Unexpected response format for {file_path.name}")

        # Respect free tier limits
        time.sleep(1.5) 
        
    except Exception as e:
        print(f"Failed to process {file_path.name}: {e}")
    
    return False

def main():
    print("--- Starting OCR Processor (JSON Map Mode) ---")
    
    # 1. Load Config
    config = load_json(CONFIG_FILE)
    folders = config.get("folders", [])
    
    if not folders:
        print("No folders specified in ocr_config.json")
        return

    # 2. Load Map
    image_map = load_json(MAP_FILE)
    changes_count = 0
    
    # 3. Scan Folders
    image_extensions = {".png", ".jpg", ".jpeg", ".bmp", ".webp"}
    
    for folder_name in folders:
        folder_path = CONTENT_DIR / folder_name
        
        if not folder_path.exists():
            print(f"Folder not found: {folder_path}")
            continue
            
        print(f"Scanning folder: {folder_name}")
        
        for root, dirs, files in os.walk(folder_path):
            for file in files:
                file_path = Path(root) / file
                
                if file_path.suffix.lower() in image_extensions:
                    if process_image(file_path, image_map):
                        changes_count += 1
                        # Save periodically? For safety, we save at end, or every N items.
                        if changes_count % 5 == 0:
                             save_json(MAP_FILE, image_map)
    
    # 4. Save Final Map
    if changes_count > 0:
        save_json(MAP_FILE, image_map)
        print(f"--- Complete. Updated {changes_count} images in map. ---")
    else:
        print("--- Complete. No new updates. ---")

if __name__ == "__main__":
    main()
