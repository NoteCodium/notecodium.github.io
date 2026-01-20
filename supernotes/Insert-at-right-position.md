[Insert into a Binary Search Tree - LeetCode](https://leetcode.com/problems/insert-into-a-binary-search-tree/description/)

1. It is guaranteed that the new value does not exist in the original BST.
2. that there may exist multiple valid ways for the insertion

# Search for 49
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c36161e2-0414-487d-a897-071ba50600ea--image.png)

```cpp
TreeNode* insertIntoBST(TreeNode* root, int k) {
    if(!root) return new TreeNode(k);
    TreeNode* parent=nullptr;
    TreeNode* node=root;
    while(node){
        parent=node;
        if(k>node->val) node=node->right;
        else node=node->left;
    }
    if(k>parent->val) parent->right= new TreeNode(k);
    else parent->left=new TreeNode(k);
    return root;

}
```