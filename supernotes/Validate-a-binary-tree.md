1. given a bst, its inoder traversal will be sorted
2. Given a sorted vector of a binary tree, the binary tree will be a bst
3. You cant find the unique bst
--------------------------------------------------------------------------------------------------------------------

Doing it in constant space
(you could use the recursion stack)
[Validate Binary Search Tree - LeetCode](https://leetcode.com/problems/validate-binary-search-tree/description/)

```cpp
void t(TreeNode* node, bool &ans, long &prev){
    if(!node or !ans) return;
    t(node->left,ans,prev);
    if(prev<node->val){
        prev=node->val;
    }
    else{
        ans=0;
        return;
    }
    t(node->right,ans,prev);
}

bool isValidBST(TreeNode* root) {
    bool ans=1;
    long prev=LONG_MIN;
    t(root,ans,prev);
    return ans;
}
```

--------------------------------------------------------------------------------------------------------------------
1. Going by definition

