[Construct Tree from Preorder Traversal | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1)
```cpp
Node* f(int idx){
  if(idx==n) return nullptr;
  if(isleaf(idx)){
    Node* leaf= new Node(pre[idx]);
    idx++;
    return leaf;
  }
  Node* node= new Node(pre[idx]);
  idx++;
  node->left=f(idx);
  node->right=f(idx);
  return node;
}
```
