# Simple Setup Guide

The extension is already compiled and ready! Here's the simplest way to get it working:

## 🚀 Quick Start (2 minutes)

### Step 1: Open Extension in VS Code Insiders
1. **Open VS Code Insiders**
2. **File → Open Folder**
3. **Navigate to and select**: `/Users/tarunmac/Developer/notecodium.github.io/vscode-extension`
4. **Click "Open"**

### Step 2: Run the Extension
1. **Press F5** (or go to Run → Start Debugging)
2. **A new VS Code Insiders window will open** with the extension loaded
3. **You should see**: "Extension Development Host" in the title bar

### Step 3: Verify It's Working
1. **In the new window**, open the **Output panel** (View → Output)
2. **Select "Notecodium Codespace Bridge"** from the dropdown
3. **You should see**: `Notecodium bridge server listening on http://localhost:3847`

### Step 4: Test the Integration
1. **Keep the Extension Development Host window open**
2. **Go to your website**: https://notecodium.github.io
3. **Click "Edit in VS Code"** on any page
4. **The extension should automatically**:
   - Open your workspace in the Extension Development Host window
   - Focus on the specific file you were viewing

## ✅ That's It!

The extension is now running and ready to receive requests from your website.

## 🔧 Alternative: Manual Compilation

If you want to compile it yourself:

```bash
cd vscode-extension
npm run compile
```

Then follow the steps above.

## 🛠️ Troubleshooting

### "Could not find task" Error
- Ignore this error - just press F5 directly
- The extension is already compiled and ready

### Extension Not Starting
- Make sure you opened the `vscode-extension` folder (not the parent folder)
- Try closing and reopening VS Code Insiders
- Check that the `out/extension.js` file exists

### HTTP Server Not Starting
- Check the Output panel for error messages
- Make sure port 3847 is not being used by another application
- Try restarting the extension (Ctrl/Cmd+Shift+F5)

### Website Connection Failed
- Ensure the Extension Development Host window is open and running
- Check browser console for detailed error messages
- Verify the extension shows "listening on http://localhost:3847"

## 📋 What Happens When You Click "Edit in VS Code"

1. **Website sends HTTP request** to `localhost:3847/open-file`
2. **Extension receives request** with file path information
3. **Extension automatically**:
   - Opens the complete workspace (if not already open)
   - Opens and focuses on the specific file
   - Shows success notification
4. **You can immediately start editing** the file with full workspace access

The extension gives you the best of both worlds: complete project access AND automatic file focusing!