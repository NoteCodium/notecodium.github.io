[leetcode.com](https://leetcode.com/problems/symmetric-tree/description/)

```cpp
bool areSymmetric(TreeNode* l, TreeNode* r){
    if(!l and !r) return 1;
    if(!l or !r) return 0; 
    return l->val==r->val and areSymmetric(l->left,r->right) and areSymmetric(l->right,r->left);       
}

bool isSymmetric(TreeNode* root) {
    if(!root) return 0;
    return areSymmetric(root->left,root->right);
}
```
