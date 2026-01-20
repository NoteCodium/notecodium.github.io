[Range Sum of BST - LeetCode](https://leetcode.com/problems/range-sum-of-bst/description/?envType=daily-question&envId=2024-01-08)

[Range Sum of BST 🔥| Leetcode 938 | Binary Search Tree - YouTube](https://youtu.be/wIloFJzSOfE?si=vNr3Q_Rm8EztnLIy)


```cpp
int rangeSumBST(TreeNode* root, int l, int h) {
    if(!root) return 0;
    int val=root->val;
    if(val>=l and val<=h) return val+rangeSumBST(root->left,l,h)+rangeSumBST(root->right,l,h);
    if(val<l) return rangeSumBST(root->right,l,h);
    else return rangeSumBST(root->left,l,h);
}
```