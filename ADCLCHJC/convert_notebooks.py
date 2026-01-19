import os
import json
import base64
import re

def convert_ipynb_to_md(filepath):
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            data = json.load(f)
        
        md_content = []
        
        # Helper to join list of strings
        def join_source(source):
            if isinstance(source, list):
                return ''.join(source)
            return source

        filename_no_ext = os.path.splitext(os.path.basename(filepath))[0]
        image_dir_name = f"{filename_no_ext}_images"
        image_dir_path = os.path.join(os.path.dirname(filepath), image_dir_name)
        images_extracted = False
        
        # Counter to handle duplicate filenames across the entire notebook
        image_counter = 0

        for cell in data.get('cells', []):
            cell_type = cell.get('cell_type')
            source = join_source(cell.get('source', ''))
            attachments = cell.get('attachments', {})
            
            if cell_type == 'markdown':
                # Handle attachments if any
                if attachments:
                    for attachment_name, attachment_data in attachments.items():
                        for mime_type, base64_data in attachment_data.items():
                            if mime_type.startswith('image/'):
                                # Create image directory if it doesn't exist
                                if not os.path.exists(image_dir_path):
                                    os.makedirs(image_dir_path)
                                
                                # Decode and save image
                                try:
                                    image_data = base64.b64decode(base64_data)
                                    
                                    # Handle duplicate filenames by renaming with a counter
                                    # We'll use a unique name for file storage but we need to map the attachment name
                                    # in the markdown to this new unique name.
                                    
                                    # Base filename and extension
                                    name_part, ext_part = os.path.splitext(attachment_name)
                                    # If no extension in attachment name (unlikely but possible), try to guess from mime? 
                                    # modifying content to enforce uniqueness
                                    
                                    # Simply prepend a counter to ensure uniqueness within this conversion run
                                    image_counter += 1
                                    unique_image_filename = f"{image_counter}_{attachment_name}"
                                    
                                    image_save_path = os.path.join(image_dir_path, unique_image_filename)
                                    
                                    with open(image_save_path, 'wb') as img_f:
                                        img_f.write(image_data)
                                    
                                    # Replace reference in source
                                    # ![alt](attachment:name.png) -> ![alt](dir/1_name.png)
                                    # We use the specific attachment name string to replace only this instance if possible, 
                                    # but markdown cells usually contain the specific string.
                                    # However, if the same attachment name appears multiple times in the SAME cell with different content, it's tricky.
                                    # But usually 'attachments' dict keys are unique per cell.
                                    
                                    search_str = f'attachment:{attachment_name}'
                                    replace_str = f'{image_dir_name}/{unique_image_filename}'
                                    
                                    # Only replace if present. Using replace() replaces ALL occurrences in the cell.
                                    # Ideally we assume attachment names are unique per cell or at least map to the same content if duplicated in text.
                                    source = source.replace(search_str, replace_str)
                                    
                                    images_extracted = True
                                    print(f"Extracted image: {image_save_path}")
                                except Exception as img_err:
                                    print(f"Error saving image {attachment_name} in {filepath}: {img_err}")

                md_content.append(source)
                md_content.append('\n')
            elif cell_type == 'code':
                md_content.append('```python')
                md_content.append(source)
                md_content.append('```\n')
        
        output_filepath = os.path.splitext(filepath)[0] + '.md'
        
        with open(output_filepath, 'w', encoding='utf-8') as f:
            f.write('\n'.join(md_content))
            
        print(f"Converted: {filepath} -> {output_filepath}")
        if images_extracted:
             print(f"Images extracted to: {image_dir_path}")
        return True
    except Exception as e:
        print(f"Failed to convert {filepath}: {e}")
        return False

def main():
    root_dir = os.getcwd()
    count = 0
    for dirpath, dirnames, filenames in os.walk(root_dir):
        # Skip hidden directories like .git
        dirnames[:] = [d for d in dirnames if not d.startswith('.')]
        
        for filename in filenames:
            if filename.endswith('.ipynb'):
                filepath = os.path.join(dirpath, filename)
                if convert_ipynb_to_md(filepath):
                    count += 1
    
    print(f"\nTotal notebooks converted: {count}")

if __name__ == "__main__":
    main()
