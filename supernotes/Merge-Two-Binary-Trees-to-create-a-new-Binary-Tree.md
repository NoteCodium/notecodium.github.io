[Merge Two Binary Trees - LeetCode](https://leetcode.com/problems/merge-two-binary-trees/description/)

```cpp
TreeNode* mergeTrees(TreeNode* r1, TreeNode* r2) {
    if(!r1 and !r2) return nullptr;
    int val1 =  r1?r1->val:0;
    int val2 =  r2?r2->val:0;
    TreeNode* r=new TreeNode(val1+val2);
    r->left=mergeTrees(r1?r1->left:nullptr,r2?r2->left:nullptr);
    r->right=mergeTrees(r1?r1->right:nullptr,r2?r2->right:nullptr);
    return r;
}
```
