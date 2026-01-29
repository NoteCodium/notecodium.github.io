#!/bin/bash

# A script to find all .pdf files in nested directories and merge them into one.

# --- Configuration ---
FINAL_PDF_NAME="Merged_Document.pdf"

# --- Script Start ---
echo "Starting PDF merge process..."

# Check if the output file already exists to prevent errors
if [ -f "$FINAL_PDF_NAME" ]; then
    echo "Error: Output file '$FINAL_PDF_NAME' already exists. Please remove or rename it."
    exit 1
fi

echo "Step 1: Finding all PDF files..."
# Create a sorted list of all PDF files found recursively from the current directory.
# The `-print0` and `while` loop handles filenames with spaces correctly.
mapfile -d '' pdf_files < <(find . -name "*.pdf" -print0 | sort -z)

if [ ${#pdf_files[@]} -eq 0 ]; then
    echo "No PDF files found in this directory or its subdirectories."
    exit 0
fi

echo "Found ${#pdf_files[@]} PDF files to merge."
echo "Step 2: Merging files with pdfunite..."

# Use pdfunite to merge all found files into the final output file.
# The "${pdf_files[@]}" syntax correctly expands the array of filenames.
pdfunite "${pdf_files[@]}" "$FINAL_PDF_NAME"

echo "----------------------------------------"
echo "✅ Success! All PDFs have been merged into: $FINAL_PDF_NAME"