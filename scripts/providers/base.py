from abc import ABC, abstractmethod
from typing import Optional, Dict, Any

class ImageProvider(ABC):
    """
    Abstract Base Class for Image Hosting Providers.
    Any new provider (AWS, Azure, etc.) must inherit from this class.
    """

    @abstractmethod
    def upload(self, file_path: str) -> Optional[str]:
        """
        Uploads an image file to the cloud.
        
        Args:
            file_path: Absolute local path to the image.
            
        Returns:
            str: Public URL of the uploaded image.
            None: If upload failed.
        """
        pass

    def extract_text(self, file_path: str) -> Optional[str]:
        """
        Optional: Extract text from image (OCR).
        Override this method if the provider supports OCR.
        
        Returns:
            str: Extracted text or None.
        """
        return None
