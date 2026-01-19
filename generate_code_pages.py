import os

# Configuration
ROOT_DIR = "ADCLCHJC"
EXTENSIONS = {
    '.java': 'java',
    '.cpp': 'cpp',
    '.cc': 'cpp',
    '.c++': 'cpp',
    '.c': 'c',
    '.h': 'cpp',
    '.hpp': 'cpp'
}

def generate_wrappers(root_dir):
    print(f"Scanning {root_dir} for code files...")
    count = 0
    
    for root, dirs, files in os.walk(root_dir):
        # Skip hidden directories
        dirs[:] = [d for d in dirs if not d.startswith('.')]
        
        for file in files:
            name, ext = os.path.splitext(file)
            ext_lower = ext.lower()
            
            if ext_lower in EXTENSIONS:
                source_path = os.path.join(root, file)
                
                # Cleanup old wrappers if they exist (Filename.java.md)
                old_wrapper_path = os.path.join(root, f"{file}.md")
                if os.path.exists(old_wrapper_path):
                    try:
                        os.remove(old_wrapper_path)
                        # print(f"Removed old wrapper: {old_wrapper_path}")
                    except OSError:
                        pass

                # Create new wrapper filename: code_Filename.java.md
                wrapper_filename = f"code_{file}.md"
                wrapper_path = os.path.join(root, wrapper_filename)
                
                try:
                    # Read source content
                    with open(source_path, 'r', encoding='utf-8', errors='replace') as f:
                        content = f.read()
                    
                    language = EXTENSIONS[ext_lower]
                    
                    # Construct Markdown content
                    # Using {% raw %} to prevent Liquid parsing errors (like {{ array init }})
                    md_content = f"""---
layout: default
title: {file}
---

```{language}
{{% raw %}}
{content}
{{% endraw %}}
```
"""
                    
                    # Write wrapper file
                    with open(wrapper_path, 'w', encoding='utf-8') as f:
                        f.write(md_content)
                    
                    count += 1
                    # Optional: print occasional progress
                    if count % 100 == 0:
                        print(f"Generated {count} wrappers...")
                        
                except Exception as e:
                    print(f"Error processing {source_path}: {e}")

    print(f"Completed! Generated {count} markdown wrappers.")

if __name__ == "__main__":
    generate_wrappers(ROOT_DIR)
