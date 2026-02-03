---
layout: default
title: Codespace Integration Test
---

# Codespace Integration Test

This page is for testing the "Edit in Codespace" button functionality.

## Current Configuration

The codespace integration is configured with:

- **Codespace Name**: `{{ site.data.codespace.codespace_name | default: 'not configured' }}`
- **Repository**: `{{ site.data.codespace.repo_name | default: 'not configured' }}`
- **GitHub Username**: `{{ site.data.codespace.github_username | default: 'not configured' }}`
- **Branch**: `{{ site.data.codespace.branch | default: 'not configured' }}`
- **Auto-detect**: `{{ site.data.codespace.auto_detect | default: 'not configured' }}`

## Testing Instructions

1. Click the "Edit in Codespace" button in the footer
2. Check the browser console for debug information
3. Verify that VS Code Insiders opens (if installed)
4. Confirm the complete workspace opens in the codespace
5. **Verify that the file `test-codespace.md` automatically opens and is focused**
6. Check that you have access to all files, terminal, and IDE features

## Expected Behavior

- Button should show "Opening..." while launching
- VS Code Insiders should open and connect to your codespace
- The complete repository workspace should open with all files accessible
- **The specific file you were viewing should automatically open and be focused**
- You'll have access to the integrated terminal, extensions, and full IDE features
- If VS Code Insiders is not available, it should fall back to opening the workspace and file in the browser

## Troubleshooting

If the integration doesn't work:

1. Check that VS Code Insiders is installed
2. Verify your codespace configuration in `_data/codespace.yml`
3. Look at the browser console for error messages
4. See `CODESPACE_SETUP.md` for detailed troubleshooting

## Configuration File

To update your codespace settings, edit `_data/codespace.yml`:

```yaml
codespace_name: "your-codespace-name-here"
repo_name: "{{ site.data.codespace.repo_name | default: 'your-repo' }}"
github_username: "{{ site.data.codespace.github_username | default: 'your-username' }}"
branch: "main"
auto_detect: true
```