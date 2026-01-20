[leetcode.com](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
```cpp
int maxDepth(TreeNode* node) {
    if(!node) return 0;
    return 1+ max(maxDepth(root->left), maxDepth(root->right));
}
```
