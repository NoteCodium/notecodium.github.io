[leetcode.com](https://leetcode.com/problems/balanced-binary-tree/)


```cpp
int f(TreeNode* root, bool &ans){
    if(!root or !ans) return 0;
    int hl=f(root->left,ans),hr=f(root->right,ans);
    if(abs(hl-hr)>1) ans=0; 
    return 1+ max(hl,hr);
}

bool isBalanced(TreeNode* root) {
    bool ans=1;
    f(root,ans);
    return ans;
}
```