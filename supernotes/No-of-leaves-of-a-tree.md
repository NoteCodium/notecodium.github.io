[Count Leaves in Binary Tree | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1)
```cpp
int countLeaves(Node* root){
    if(!root) return 0;
    if(!root->left and !root->right) return 1;
    return countLeaves(root->left)+countLeaves(root->right);
}
```
