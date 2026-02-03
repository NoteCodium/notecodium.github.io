#!/usr/bin/env node

/**
 * Helper script to detect and display codespace information
 * Run this in your GitHub Codespace terminal to get configuration values
 */

console.log('🚀 GitHub Codespace Detection Tool\n');

// Check environment variables that might contain codespace info
const envVars = [
  'CODESPACE_NAME',
  'GITHUB_CODESPACES_PORT_FORWARDING_DOMAIN', 
  'CODESPACES',
  'GITHUB_REPOSITORY',
  'GITHUB_REPOSITORY_OWNER'
];

console.log('📋 Environment Variables:');
envVars.forEach(varName => {
  const value = process.env[varName];
  if (value) {
    console.log(`   ${varName}: ${value}`);
  }
});

// Try to extract from hostname if available
if (process.env.CODESPACE_NAME) {
  console.log('\n✅ Codespace Configuration for _data/codespace.yml:');
  console.log('```yaml');
  console.log(`codespace_name: "${process.env.CODESPACE_NAME}"`);
  
  if (process.env.GITHUB_REPOSITORY) {
    const repo = process.env.GITHUB_REPOSITORY.split('/')[1];
    console.log(`repo_name: "${repo}"`);
  }
  
  if (process.env.GITHUB_REPOSITORY_OWNER) {
    console.log(`github_username: "${process.env.GITHUB_REPOSITORY_OWNER}"`);
  }
  
  console.log('branch: "main"');
  console.log('auto_detect: true');
  console.log('```');
} else {
  console.log('\n❌ Could not detect codespace name from environment.');
  console.log('💡 Make sure you are running this inside a GitHub Codespace.');
  console.log('💡 You can also find your codespace name in the URL when using the web interface.');
}

console.log('\n📖 For more help, see CODESPACE_SETUP.md');