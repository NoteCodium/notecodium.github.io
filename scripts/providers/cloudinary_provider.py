import os
import sys
from typing import Optional
from .base import ImageProvider

# Try importing cloudinary
try:
    import cloudinary
    import cloudinary.uploader
    import cloudinary.api
except ImportError:
    print("Error: 'cloudinary' module not found. Install it with: pip install cloudinary")
    sys.exit(1)

class CloudinaryProvider(ImageProvider):
    def __init__(self):
        # Configure using CLOUDINARY_URL env var (Standard Cloudinary way)
        if not os.environ.get("CLOUDINARY_URL"):
            print("Warning: CLOUDINARY_URL environment variable not set.")
            self.configured = False
        else:
            self.configured = True
            # Cloudinary auto-configures from the env var when imported

    def upload(self, file_path: str) -> Optional[str]:
        if not self.configured:
            return None

        try:
            # Generate a public_id based on filename to avoid duplicates
            # e.g., images/screenshot.png -> notecodium/images/screenshot
            filename = os.path.basename(file_path)
            name_without_ext = os.path.splitext(filename)[0]
            # Use a folder prefix to keep things organized
            public_id = f"notecodium_assets/{name_without_ext}"

            # Upload
            response = cloudinary.uploader.upload(
                file_path,
                public_id=public_id,
                unique_filename=False,
                overwrite=True,
                resource_type="image"
            )

            # Construct Optimized URL (f_auto, q_auto is best practice)
            # The 'secure_url' usually looks like: https://res.cloudinary.com/.../image/upload/v123/id.jpg
            # We insert transformation before /v123/
            url = response.get("secure_url")
            
            # Simple optimization injection
            if "upload/" in url:
                url = url.replace("upload/", "upload/f_auto,q_auto/")
            
            return url

        except Exception as e:
            print(f"Cloudinary Upload Error for {file_path}: {e}")
            return None
