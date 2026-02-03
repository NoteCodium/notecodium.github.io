# Notecodium Codespace Bridge Extension

This VS Code Insiders extension creates a bridge between your notecodium.github.io documentation website and VS Code Insiders, enabling automatic workspace opening and file focusing.

## Features

- **HTTP Bridge Server**: Listens for requests from the website on `localhost:3847`
- **Automatic Workspace Opening**: Opens the complete repository workspace
- **Automatic File Focusing**: Opens and focuses on the specific file requested
- **Error Handling**: Provides feedback for failed operations
- **CORS Support**: Handles cross-origin requests from the website

## Installation

### Automatic Installation
```bash
# From the repository root
./install-bridge.sh
```

### Manual Installation
```bash
cd vscode-extension
npm install
npm run compile
code-insiders --install-extension .
```

## Usage

1. **Install the extension** in VS Code Insiders
2. **Open your codespace** in VS Code Insiders
3. **Navigate to your website** (notecodium.github.io)
4. **Click "Edit in VS Code"** on any page
5. **VS Code automatically opens** the workspace and focuses on the file

## API Endpoints

### POST /open-file

Opens a workspace and focuses on a specific file.

**Request Body:**
```json
{
  "filePath": "/workspaces/repo-name/path/to/file.md",
  "workspacePath": "/workspaces/repo-name",
  "repoName": "repo-name",
  "originalPath": "path/to/file.md"
}
```

**Response:**
```json
{
  "success": true,
  "message": "File opened successfully"
}
```

## Configuration

The extension automatically starts when VS Code Insiders launches and listens on port 3847. No additional configuration is required.

## Troubleshooting

### Extension Not Starting
- Check the Output panel for activation messages
- Ensure VS Code Insiders (not regular VS Code) is being used
- Restart VS Code Insiders

### Connection Failed
- Verify port 3847 is not blocked by firewall
- Check that the extension is active and listening
- Look for error messages in the browser console

### File Not Opening
- Ensure the file exists in the workspace
- Check that the workspace path is correct
- Verify VS Code has file system permissions

## Development

### Building
```bash
npm run compile
```

### Watching for Changes
```bash
npm run watch
```

### Testing
1. Press F5 in VS Code to launch Extension Development Host
2. Test the extension in the new VS Code window

## License

MIT License - see LICENSE file for details.