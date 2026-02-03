---
layout: default
title: Path Configuration Test
---

# Path Configuration Test

This page tests the path configuration for both local and codespace environments.

## Current Configuration

- **Local Workspace Path**: `{{ site.data.codespace.local_workspace_path | default: '/Users/tarunmac/Developer' }}`
- **Repository Name**: `{{ site.data.codespace.repo_name | default: 'notecodium.github.io' }}`
- **Expected Local Full Path**: `{{ site.data.codespace.local_workspace_path | default: '/Users/tarunmac/Developer' }}/{{ site.data.codespace.repo_name | default: 'notecodium.github.io' }}`

## Testing Instructions

1. **Make sure the VS Code extension is running** (F5 in the extension folder)
2. **Click "Edit in VS Code"** button in the footer
3. **Check browser console** for path information:
   - Should show "Environment detected: Local Development"
   - Should show correct workspace and file paths
4. **VS Code should open** the workspace and focus on this file

## Expected Behavior

When running locally, the extension should:
- Detect local environment (not codespace)
- Use path: `/Users/tarunmac/Developer/notecodium.github.io`
- Open the complete workspace
- Focus on `test-paths.md`

## Troubleshooting

If paths are wrong, update `_data/codespace.yml`:

```yaml
local_workspace_path: "/Users/tarunmac/Developer"  # Your actual path
repo_name: "notecodium.github.io"                 # Your repo name
```

The extension will automatically use the correct paths based on whether you're running locally or in a GitHub Codespace.