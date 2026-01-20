[practice.geeksforgeeks.org](https://practice.geeksforgeeks.org/problems/maximum-sum-leaf-to-root-path/1)
```cpp
int f(Node* root){
    if(!root) return INT_MIN;
    if(!root->left and !root->right) return root->data;
    return root->data+ max(f(root->left),f(root->right));
}


int maxPathSum(Node* root) { 
    if(!root) return 0; 
    return f(root);
} 
```
