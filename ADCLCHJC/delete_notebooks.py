import os
import glob

def delete_ipynb_files():
    # Find all .ipynb files recursively in current directory and subdirectories
    notebooks = glob.glob('**/*.ipynb', recursive=True)
    
    if not notebooks:
        print("No .ipynb files found.")
        return

    print(f"Found {len(notebooks)} .ipynb files.")
    
    for notebook in notebooks:
        try:
            os.remove(notebook)
            print(f"Deleted: {notebook}")
        except Exception as e:
            print(f"Error deleting {notebook}: {e}")

    print("Deletion complete.")

if __name__ == "__main__":
    delete_ipynb_files()
