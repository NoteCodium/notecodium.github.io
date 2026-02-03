# Codespace Integration Setup

This documentation site includes integration with GitHub Codespaces and VS Code Insiders. The "Open in Codespace" button in the footer allows you to quickly open the complete workspace in your preferred development environment.

## Features

- **Complete Workspace + File Access**: Opens the entire repository/workspace in VS Code Insiders AND automatically opens the specific file you were viewing
- **Automatic Detection**: Can automatically detect your codespace name from the URL when browsing from within a codespace
- **Fallback Support**: Falls back to opening the workspace and file in the browser if VS Code Insiders is not available
- **Visual Feedback**: Button shows "Opening..." state while launching
- **Best of Both Worlds**: Full IDE access to all files while immediately focusing on the current file

## Configuration

### Quick Setup

1. Update the codespace configuration in `_data/codespace.yml`:

```yaml
# Your current codespace name (find this in your codespace URL)
codespace_name: "your-codespace-name-here"

# Your GitHub repository name  
repo_name: "your-repo-name"

# Your GitHub username
github_username: "your-username"

# Default branch name
branch: "main"

# Enable automatic codespace name detection
auto_detect: true
```

### Finding Your Codespace Name

Your codespace name can be found in several ways:

1. **From the URL**: When using GitHub Codespaces in the browser, the URL looks like:
   - `https://your-codespace-name.github.dev/`
   - `https://your-codespace-name.app.github.dev/`

2. **From VS Code**: In VS Code connected to a codespace, check the bottom-left corner for the remote connection indicator

3. **From GitHub**: In your GitHub repository, go to the "Code" tab and click on "Codespaces" to see your active codespaces

### Example Configuration

```yaml
codespace_name: "ominous-train-97w54wjg45wghp975"
repo_name: "notecodium.github.io"
github_username: "notecodium"
branch: "main"
auto_detect: true
```

## How It Works

### VS Code Insiders Protocol

The integration uses VS Code's URI scheme to open the workspace and specific file:

```
vscode-insiders://vscode-remote/codespaces+<CODESPACE_NAME>/workspaces/<REPO_NAME>/<FILE_PATH>
```

This opens the entire repository as a workspace AND automatically opens the specific file you were viewing, giving you both complete project access and immediate focus on the relevant file.

### Auto-Detection

When `auto_detect: true` is enabled, the system will:

1. Check if you're browsing from within a GitHub Codespace
2. Extract the codespace name from the URL
3. Use the detected name instead of the configured default
4. Fall back to the configured name if detection fails

### Fallback Behavior

If VS Code Insiders cannot be opened (e.g., not installed, protocol not supported), the system will:

1. Log the error to the browser console
2. Open the complete workspace in the GitHub Codespace web interface instead
3. Provide user feedback through button state changes

## Troubleshooting

### VS Code Insiders Not Opening

1. **Install VS Code Insiders**: Download from [code.visualstudio.com/insiders](https://code.visualstudio.com/insiders/)
2. **Check Protocol Handler**: Ensure your browser allows the `vscode-insiders://` protocol
3. **Browser Settings**: Some browsers may block custom protocol handlers - check your browser's security settings

### Wrong Codespace Opening

1. **Update Configuration**: Make sure `codespace_name` in `_data/codespace.yml` is correct
2. **Check Auto-Detection**: If `auto_detect: false`, only the configured name will be used
3. **Clear Browser Cache**: Sometimes cached JavaScript can cause issues

### File Not Found

1. **Check File Path**: Ensure the file exists in your repository
2. **Branch Mismatch**: Verify the `branch` setting matches your default branch
3. **Repository Name**: Confirm `repo_name` matches your actual repository name

## Development

### Testing Locally

When developing locally, the codespace integration will still work if you:

1. Have VS Code Insiders installed
2. Have an active GitHub Codespace for the repository
3. Configure the correct codespace name

### Customization

You can customize the button behavior by modifying the JavaScript in `_layouts/default.html`. The configuration is loaded from `window.CODESPACE_CONFIG` and can be extended with additional options.

## Security Notes

- The integration only opens files within your own repository
- No sensitive data is transmitted through the URL scheme
- All operations respect GitHub's authentication and permissions
- The fallback browser option uses HTTPS connections

## Browser Compatibility

- **Chrome/Edge**: Full support for custom protocol handlers
- **Firefox**: May require manual protocol handler approval
- **Safari**: Limited support for custom protocols
- **Mobile Browsers**: Generally do not support VS Code protocol handlers