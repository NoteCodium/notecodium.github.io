[leetcode.com](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
```
//original function with a base condition

int minDepth(TreeNode* root) {
    if(!root) return INT_MAX;
    if(!root->left and !root->right) return 1;
    return 1+min(minDepth(root->left),minDepth(root->right));
}
```
