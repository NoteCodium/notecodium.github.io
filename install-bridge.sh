#!/bin/bash

echo "🚀 Installing Notecodium VS Code Bridge Extension..."

# Navigate to extension directory
cd vscode-extension

# Install dependencies
echo "📦 Installing dependencies..."
npm install

# Compile TypeScript
echo "🔨 Compiling extension..."
npm run compile

# Check if compilation was successful
if [ ! -f "out/extension.js" ]; then
    echo "❌ Compilation failed. Check for TypeScript errors above."
    exit 1
fi

echo "✅ Extension compiled successfully!"

# Check for VS Code Insiders on different platforms
VSCODE_INSIDERS_CMD=""

# Check common VS Code Insiders locations
if command -v code-insiders &> /dev/null; then
    VSCODE_INSIDERS_CMD="code-insiders"
elif [ -f "/Applications/Visual Studio Code - Insiders.app/Contents/Resources/app/bin/code" ]; then
    VSCODE_INSIDERS_CMD="/Applications/Visual Studio Code - Insiders.app/Contents/Resources/app/bin/code"
elif [ -f "/usr/local/bin/code-insiders" ]; then
    VSCODE_INSIDERS_CMD="/usr/local/bin/code-insiders"
else
    echo "⚠️  VS Code Insiders command not found in PATH"
    echo "🔍 Checking for VS Code Insiders application..."
    
    if [ -d "/Applications/Visual Studio Code - Insiders.app" ]; then
        echo "✅ Found VS Code Insiders application"
        echo "📁 Location: /Applications/Visual Studio Code - Insiders.app"
        echo ""
        echo "🔧 Manual installation required:"
        echo "1. Open VS Code Insiders"
        echo "2. Press Cmd+Shift+P (or Ctrl+Shift+P)"
        echo "3. Type 'Extensions: Install from VSIX'"
        echo "4. Navigate to: $(pwd)"
        echo "5. Select the vscode-extension folder"
        echo ""
        echo "📋 Or add VS Code Insiders to your PATH:"
        echo "   export PATH=\"/Applications/Visual Studio Code - Insiders.app/Contents/Resources/app/bin:\$PATH\""
        exit 0
    else
        echo "❌ VS Code Insiders not found"
        echo "📥 Please install VS Code Insiders first:"
        echo "   https://code.visualstudio.com/insiders/"
        exit 1
    fi
fi

if [ -n "$VSCODE_INSIDERS_CMD" ]; then
    echo "✅ VS Code Insiders found: $VSCODE_INSIDERS_CMD"
    
    # Install extension
    echo "🔧 Installing extension in VS Code Insiders..."
    "$VSCODE_INSIDERS_CMD" --install-extension .
    
    if [ $? -eq 0 ]; then
        echo "✅ Extension installed successfully!"
        echo ""
        echo "📋 Next steps:"
        echo "1. Open VS Code Insiders in your codespace"
        echo "2. The extension should activate automatically"
        echo "3. Test by clicking 'Edit in VS Code' on your website"
        echo ""
        echo "🔍 To verify installation:"
        echo "- Check Extensions panel for 'Notecodium Codespace Bridge'"
        echo "- Look for activation message in Output panel"
    else
        echo "❌ Extension installation failed"
        echo "🔧 Try manual installation:"
        echo "1. Open VS Code Insiders"
        echo "2. Press Cmd+Shift+P (or Ctrl+Shift+P)"
        echo "3. Type 'Extensions: Install from VSIX'"
        echo "4. Navigate to: $(pwd)"
        echo "5. Select the vscode-extension folder"
    fi
fi

echo ""
echo "📖 For detailed setup instructions, see VSCODE_BRIDGE_SETUP.md"