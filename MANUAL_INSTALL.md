# Manual Installation Guide

The VS Code extension has been compiled successfully! Since automatic installation had issues, here's how to install it manually:

## ✅ Extension Status
- **Compiled**: ✅ The extension is ready in `vscode-extension/out/extension.js`
- **Dependencies**: ✅ All npm packages installed
- **TypeScript**: ✅ No compilation errors

## 📦 Manual Installation Steps

### Method 1: Install from Folder (Recommended)

1. **Open VS Code Insiders**
2. **Open Command Palette**: Press `Cmd+Shift+P` (Mac) or `Ctrl+Shift+P` (Windows/Linux)
3. **Type**: `Developer: Install Extension from Location`
4. **Navigate to**: `/Users/tarunmac/Developer/notecodium.github.io/vscode-extension`
5. **Select the folder**: `vscode-extension`
6. **Click "Install"**

### Method 2: Copy Extension to Extensions Folder

1. **Find VS Code Insiders extensions folder**:
   - **Mac**: `~/.vscode-insiders/extensions/`
   - **Windows**: `%USERPROFILE%\.vscode-insiders\extensions\`
   - **Linux**: `~/.vscode-insiders/extensions/`

2. **Copy the extension folder**:
   ```bash
   cp -r vscode-extension ~/.vscode-insiders/extensions/notecodium-codespace-bridge
   ```

3. **Restart VS Code Insiders**

### Method 3: Development Mode (Easiest)

1. **Open VS Code Insiders**
2. **File → Open Folder**
3. **Navigate to and open**: `/Users/tarunmac/Developer/notecodium.github.io/vscode-extension`
4. **Press F5** (this opens Extension Development Host)
5. **A new VS Code window opens** with the extension loaded
6. **Use this window** for your development work

## 🧪 Testing the Extension

Once installed, test it:

1. **Check Extension Panel**: Look for "Notecodium Codespace Bridge"
2. **Check Output Panel**: Should see "Notecodium Codespace Bridge is now active!"
3. **Test HTTP Server**: The extension listens on `http://localhost:3847`
4. **Test from Website**: Click "Edit in VS Code" button on your documentation site

## 🔍 Verification

### Check if Extension is Active
1. Open **Output Panel** (`View → Output`)
2. Select **"Notecodium Codespace Bridge"** from dropdown
3. Should see: `Notecodium bridge server listening on http://localhost:3847`

### Test HTTP Connection
Open browser console and run:
```javascript
fetch('http://localhost:3847/open-file', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({
    filePath: '/workspaces/notecodium.github.io/test-codespace.md',
    workspacePath: '/workspaces/notecodium.github.io'
  })
})
.then(r => r.json())
.then(console.log)
```

## 🚀 Next Steps

Once the extension is installed and active:

1. **Navigate to your website**: `https://notecodium.github.io`
2. **Click "Edit in VS Code"** on any page
3. **VS Code should automatically**:
   - Open the complete workspace
   - Focus on the specific file you were viewing
4. **Start editing!**

## 🛠️ Troubleshooting

### Extension Not Showing
- Restart VS Code Insiders
- Check Extensions panel for "Notecodium Codespace Bridge"
- Try Method 3 (Development Mode) as it's most reliable

### HTTP Server Not Starting
- Check Output panel for error messages
- Ensure port 3847 is not blocked
- Try reloading the extension window

### File Not Opening
- Verify the workspace path is correct
- Check that files exist in the expected location
- Look for error messages in VS Code's Output panel

## 📁 File Locations

- **Extension Source**: `/Users/tarunmac/Developer/notecodium.github.io/vscode-extension/`
- **Compiled Extension**: `/Users/tarunmac/Developer/notecodium.github.io/vscode-extension/out/extension.js`
- **VS Code Extensions**: `~/.vscode-insiders/extensions/`

The extension is ready to use! Choose the installation method that works best for you.