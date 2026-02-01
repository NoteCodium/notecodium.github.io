import os
import sys

def delete_ipynb_files(root_dir):
    ipynb_files = []
    # Walk through the directory tree
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            if file.endswith(".ipynb"):
                ipynb_files.append(os.path.join(root, file))

    if not ipynb_files:
        print("No .ipynb files found.")
        return

    print(f"Found {len(ipynb_files)} .ipynb files:")
    for file_path in ipynb_files:
        print(file_path)

    # Ask for confirmation
    response = input("\nDo you want to delete these files? (yes/no): ").lower()
    if response == 'yes':
        deleted_count = 0
        for file_path in ipynb_files:
            try:
                os.remove(file_path)
                print(f"Deleted: {file_path}")
                deleted_count += 1
            except Exception as e:
                print(f"Error deleting {file_path}: {e}")
        print(f"\nDeletion complete. {deleted_count} files deleted.")
    else:
        print("Operation cancelled.")

if __name__ == "__main__":
    # Use the current working directory
    delete_ipynb_files(os.getcwd())
