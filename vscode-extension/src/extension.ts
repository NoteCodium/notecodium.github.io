import * as vscode from 'vscode';
import * as http from 'http';

export function activate(context: vscode.ExtensionContext) {
    console.log('Notecodium Codespace Bridge is now active!');

    // Create HTTP server to listen for requests from the website
    const server = http.createServer((req, res) => {
        // Enable CORS
        res.setHeader('Access-Control-Allow-Origin', '*');
        res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
        res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

        if (req.method === 'OPTIONS') {
            res.writeHead(200);
            res.end();
            return;
        }

        if (req.method === 'POST' && req.url === '/open-file') {
            let body = '';
            req.on('data', chunk => {
                body += chunk.toString();
            });

            req.on('end', () => {
                try {
                    const data = JSON.parse(body);
                    const { filePath, workspacePath } = data;

                    // Open workspace and file
                    openWorkspaceAndFile(workspacePath, filePath);

                    res.writeHead(200, { 'Content-Type': 'application/json' });
                    res.end(JSON.stringify({ success: true, message: 'File opened successfully' }));
                } catch (error) {
                    const errorMessage = error instanceof Error ? error.message : 'Unknown error';
                    res.writeHead(400, { 'Content-Type': 'application/json' });
                    res.end(JSON.stringify({ success: false, error: errorMessage }));
                }
            });
        } else {
            res.writeHead(404);
            res.end('Not found');
        }
    });

    // Start server on a specific port
    const port = 3847; // Random port for our bridge
    server.listen(port, 'localhost', () => {
        console.log(`Notecodium bridge server listening on http://localhost:${port}`);
    });

    // Register command for manual testing
    const disposable = vscode.commands.registerCommand('notecodium.openWorkspaceAndFile', () => {
        vscode.window.showInformationMessage('Notecodium Codespace Bridge is active and listening!');
    });

    context.subscriptions.push(disposable);

    // Clean up server when extension is deactivated
    context.subscriptions.push({
        dispose: () => {
            server.close();
        }
    });
}

async function openWorkspaceAndFile(workspacePath: string, filePath: string) {
    try {
        // First, ensure workspace is open
        const workspaceUri = vscode.Uri.file(workspacePath);
        
        // Check if workspace is already open
        const currentWorkspace = vscode.workspace.workspaceFolders?.[0];
        
        if (!currentWorkspace || currentWorkspace.uri.fsPath !== workspacePath) {
            // Open the workspace
            await vscode.commands.executeCommand('vscode.openFolder', workspaceUri, false);
            
            // Wait a bit for workspace to load
            await new Promise(resolve => setTimeout(resolve, 2000));
        }

        // Now open the specific file
        const fileUri = vscode.Uri.file(filePath);
        const document = await vscode.workspace.openTextDocument(fileUri);
        await vscode.window.showTextDocument(document, {
            preview: false,
            viewColumn: vscode.ViewColumn.One
        });

        // Show success message
        const fileName = filePath.split('/').pop() || 'file';
        vscode.window.showInformationMessage(`Opened: ${fileName}`);

    } catch (error) {
        const errorMessage = error instanceof Error ? error.message : 'Unknown error';
        vscode.window.showErrorMessage(`Failed to open file: ${errorMessage}`);
        console.error('Error opening workspace and file:', error);
    }
}

export function deactivate() {
    console.log('Notecodium Codespace Bridge deactivated');
}