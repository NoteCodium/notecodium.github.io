![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c80f0296-d02a-46a2-81aa-17b9eaf06234--image.png)

```cpp
TreeNode* searchBST(TreeNode* root, int k) {
    TreeNode* node=root;
    while(node){
        if(node->val==k) return node;
        if(node->val<k) node=node->right;
        else node=node->left;
    }
    return NULL;
}
```