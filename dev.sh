#!/bin/bash

# Load Environment
if [ -f .env ]; then
  export $(grep -v '^#' .env | xargs)
fi

echo "--- 🚀 Starting NoteCodium Dev Environment ---"

# 1. Image Upload (Syncs local images to Cloud)
echo "Step 1: Checking for new images to upload..."
python3 scripts/image_uploader.py

# 2. Generate Sidebar Data
echo "Step 2: Generating Sidebar Index..."
python3 scripts/generate_files_json.py

# 3. Run OCR (if configured)
echo "Step 3: Running OCR..."
python3 scripts/ocr_processor.py

# 3. Start Server
echo "Step 3: Starting Jekyll Server..."
bundle exec jekyll serve
