[Binary Tree Pruning - LeetCode](https://leetcode.com/problems/binary-tree-pruning/description/)

```cpp
int f(TreeNode* node){
    if(!node) return 0;
    //reached a leaf node
    if(!node->left and !node->right){
        return node->val==1;
    }

    int lstOnes=f(node->left),rstOnes=f(node->right);
    if(lstOnes==0) node->left=nullptr;
    if(rstOnes==0) node->right=nullptr;
    return lstOnes+rstOnes+ (node->val==1);

}

TreeNode* pruneTree(TreeNode* root) {
    if(!root) return root;
    if(f(root)==0) root=nullptr;
    return root;
}
```

