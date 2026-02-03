# VS Code Insiders Bridge Setup

This setup creates a direct connection between your website and VS Code Insiders, allowing automatic workspace opening and file focusing without manual navigation.

## How It Works

1. **VS Code Extension**: A bridge extension runs in VS Code Insiders and listens for HTTP requests
2. **Website Integration**: The website sends HTTP requests to the extension with file information
3. **Automatic Opening**: VS Code automatically opens the workspace and focuses on the specific file
4. **Fallback Support**: If the bridge fails, falls back to the standard URI scheme method

## Installation Steps

### Step 1: Install the Bridge Extension

1. **Navigate to the extension folder**:
   ```bash
   cd vscode-extension
   ```

2. **Install dependencies**:
   ```bash
   npm install
   ```

3. **Compile the extension**:
   ```bash
   npm run compile
   ```

4. **Install in VS Code Insiders**:
   - Open VS Code Insiders
   - Press `Ctrl/Cmd+Shift+P`
   - Type "Extensions: Install from VSIX"
   - Navigate to the `vscode-extension` folder
   - Or use the command line:
   ```bash
   code-insiders --install-extension ./vscode-extension
   ```

### Step 2: Configure the Website

1. **Update your codespace configuration** in `_data/codespace.yml`:
   ```yaml
   codespace_name: "your-codespace-name"
   repo_name: "notecodium.github.io"
   github_username: "notecodium"
   branch: "main"
   auto_detect: true
   ```

2. **The website is already configured** to use the bridge extension

### Step 3: Test the Connection

1. **Open VS Code Insiders** in your codespace
2. **Verify the extension is active**:
   - Check the output panel for "Notecodium Codespace Bridge is now active!"
   - The extension should be listening on `http://localhost:3847`
3. **Test from the website**:
   - Navigate to any page on your documentation site
   - Click the "Edit in VS Code" button
   - VS Code should automatically open the workspace and focus on the file

## Features

### ✅ Automatic Workspace Opening
- Opens the complete repository/workspace in VS Code Insiders
- No manual navigation required

### ✅ Automatic File Focusing  
- Automatically opens and focuses on the specific file you were viewing
- No need to search or navigate manually

### ✅ Seamless Integration
- Direct HTTP communication between website and VS Code
- Real-time feedback and error handling

### ✅ Fallback Support
- If the bridge extension is not available, falls back to URI scheme method
- Graceful degradation ensures functionality always works

## Troubleshooting

### Extension Not Loading
1. **Check VS Code Insiders version**: Ensure you're using VS Code Insiders (not regular VS Code)
2. **Verify installation**: Check Extensions panel for "Notecodium Codespace Bridge"
3. **Check output panel**: Look for activation messages in the Output panel
4. **Restart VS Code**: Sometimes extensions need a restart to activate

### Connection Failed
1. **Check port availability**: The extension uses port 3847
2. **Firewall settings**: Ensure localhost connections are allowed
3. **Extension status**: Verify the extension is active and listening
4. **Browser console**: Check for detailed error messages

### File Not Opening
1. **Check file paths**: Ensure the file exists in the repository
2. **Workspace location**: Verify the workspace path is correct (`/workspaces/repo-name`)
3. **Permissions**: Ensure VS Code has access to the file system

## Development

### Building the Extension

```bash
cd vscode-extension
npm install
npm run compile
```

### Packaging for Distribution

```bash
npm install -g vsce
vsce package
```

This creates a `.vsix` file that can be distributed and installed.

### Extension Development

The extension source is in `vscode-extension/src/extension.ts`. Key components:

- **HTTP Server**: Listens on port 3847 for requests from the website
- **Command Handler**: Processes file opening requests
- **Workspace Management**: Handles workspace opening and file focusing
- **Error Handling**: Provides feedback for failed operations

### Website Integration

The website integration is in `_layouts/default.html`. Key features:

- **Bridge Communication**: Sends HTTP POST requests to the extension
- **Fallback Logic**: Uses URI scheme if bridge is unavailable
- **User Feedback**: Shows connection status and results
- **Error Handling**: Graceful degradation on failures

## Security Notes

- The extension only listens on `localhost:3847`
- Only accepts requests for files within the workspace
- No external network access required
- All communication is local to your machine

## Advanced Configuration

### Custom Port

To use a different port, modify both:

1. **Extension** (`vscode-extension/src/extension.ts`):
   ```typescript
   const port = 3847; // Change this
   ```

2. **Website** (`_layouts/default.html`):
   ```javascript
   const bridgeUrl = 'http://localhost:3847/open-file'; // Change port here
   ```

### Additional Commands

The extension can be extended to support additional commands:

- File creation
- Directory navigation  
- Git operations
- Terminal commands

Add new endpoints in the HTTP server handler and corresponding website functions.