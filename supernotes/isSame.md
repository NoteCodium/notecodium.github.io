[Same Tree - LeetCode](https://leetcode.com/problems/same-tree/description/)
```cpp
bool isSameTree(TreeNode* r1, TreeNode* r2) {
    if(!r1 and !r2) return 1;
    if(!r1 or !r2) return 0;
    return r1->val==r2->val and isSameTree(r1->left,r2->left) and isSameTree(r1->right,r2->right);
}
```


