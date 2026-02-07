#!/bin/bash

# 1. Load Environment Variables from .env
if [ -f .env ]; then
  echo "Loading variables from .env..."
  export $(grep -v '^#' .env | xargs)
else
  echo "⚠️  No .env file found. Make sure CLOUDINARY_URL is set in your environment."
fi

# 2. Install Python Dependencies (if missing)
echo "Installing/Checking dependencies..."
pip3 install cloudinary requests > /dev/null

# 3. Run the Image Uploader
echo "Running Image Uploader..."
python3 scripts/image_uploader.py
