[Count Good Nodes in Binary Tree - LeetCode](https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/19c8c5a8-5132-4bb5-8c8d-6ee29b628c3c--image.png)


```cpp
void t(TreeNode* node, int &ans, int maxx){
    if(!node) return;
    if(node->val>=maxx){
        ans+=1;
        maxx=node->val;
    }
    t(node->left,ans,maxx);
    t(node->right,ans,maxx);
}

int goodNodes(TreeNode* root) {
    if(!root) return 0;
    int ans=1;
    int maxx=root->val;
    t(root->left,ans,maxx);
    t(root->right,ans,maxx);
    return ans;
}
```
