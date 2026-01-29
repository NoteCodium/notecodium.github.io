import { BrowserMultiFormatReader } from 'https://cdn.jsdelivr.net/npm/@zxing/library@0.21.2/+esm';

// Initialize the QR code reader
const codeReader = new BrowserMultiFormatReader();
const videoElement = document.getElementById('video');
const resultElement = document.getElementById('result');

async function startScanner() {
    try {
        const stream = await navigator.mediaDevices.getUserMedia({ video: { facingMode: 'environment' } });
        videoElement.srcObject = stream;

        codeReader.decodeFromVideoDevice(null, videoElement, (result, error) => {
            if (result) {
                resultElement.textContent = `QR Code Scanned: ${result.text}`;
            }
            if (error) {
                console.error(error);
            }
        });
    } catch (err) {
        console.error(err);
        resultElement.textContent = 'Error accessing camera.';
    }
}

// Start the QR code scanning process when the page loads
window.onload = () => {
    startScanner();
};