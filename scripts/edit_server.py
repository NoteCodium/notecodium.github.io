import http.server
import socketserver
import json
import os
import urllib.parse

PORT = 8000
# Assuming this script is in scripts/, so parent is repo root
REPO_ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

class EditHandler(http.server.SimpleHTTPRequestHandler):
    def do_OPTIONS(self):
        self.send_response(200)
        self.send_header('Access-Control-Allow-Origin', '*')
        self.send_header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS')
        self.send_header('Access-Control-Allow-Headers', 'Content-Type')
        self.end_headers()

    def do_GET(self):
        if self.path.startswith('/api/read'):
            query = urllib.parse.urlparse(self.path).query
            params = urllib.parse.parse_qs(query)
            file_path = params.get('path', [''])[0]

            if not file_path:
                self.send_error(400, "Missing path")
                return

            # Sanitize and build full path
            # Remove leading slash if present to join correctly
            if file_path.startswith('/'):
                file_path = file_path[1:]
                
            full_path = os.path.normpath(os.path.join(REPO_ROOT, file_path))
            
            # Security check: must be within REPO_ROOT
            if not full_path.startswith(REPO_ROOT):
                self.send_error(403, "Access denied")
                return

            if not os.path.exists(full_path):
                self.send_error(404, "File not found")
                return

            try:
                with open(full_path, 'r', encoding='utf-8') as f:
                    content = f.read()
                
                self.send_response(200)
                self.send_header('Content-Type', 'text/plain; charset=utf-8')
                self.send_header('Access-Control-Allow-Origin', '*')
                self.end_headers()
                self.wfile.write(content.encode('utf-8'))
            except Exception as e:
                self.send_error(500, str(e))
        else:
            self.send_error(404)

    def do_POST(self):
        if self.path == '/api/save':
            content_length = int(self.headers['Content-Length'])
            post_data = self.rfile.read(content_length)
            
            try:
                data = json.loads(post_data.decode('utf-8'))
                file_path = data.get('path')
                content = data.get('content')

                if not file_path or content is None:
                    self.send_error(400, "Missing path or content")
                    return
                
                if file_path.startswith('/'):
                    file_path = file_path[1:]

                full_path = os.path.normpath(os.path.join(REPO_ROOT, file_path))
                
                if not full_path.startswith(REPO_ROOT):
                    self.send_error(403, "Access denied")
                    return
                
                # Write to file
                with open(full_path, 'w', encoding='utf-8') as f:
                    f.write(content)
                
                self.send_response(200)
                self.send_header('Content-Type', 'application/json')
                self.send_header('Access-Control-Allow-Origin', '*')
                self.end_headers()
                self.wfile.write(json.dumps({"status": "ok"}).encode('utf-8'))

            except Exception as e:
                print(f"Error saving: {e}")
                self.send_error(500, str(e))
        else:
            self.send_error(404)

if __name__ == "__main__":
    print(f"Edit Server running at http://localhost:{PORT}")
    print(f"Root Directory: {REPO_ROOT}")
    # Allow address reuse
    socketserver.TCPServer.allow_reuse_address = True
    with socketserver.TCPServer(("", PORT), EditHandler) as httpd:
        try:
            httpd.serve_forever()
        except KeyboardInterrupt:
            print("\nShutting down server...")
