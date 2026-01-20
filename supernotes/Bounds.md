![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2ca49644-dfc5-4636-9fd9-984201269e60--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c2cc7fcb-023c-4a7c-895f-cd7451b1c341--image.png)

```cpp
void t(TreeNode* node, bool &ans, long lb, long ub){
    if(!node or !ans) return;
    if(node->val<=lb or node->val>=ub){
        ans=0;
        return;
    }
    t(node->left,ans,lb,node->val);
    t(node->right,ans,node->val,ub);
}

bool isValidBST(TreeNode* root) {
    bool ans=1;
    t(root,ans,LONG_MIN,LONG_MAX);
    return ans;
}
```