# Find OA link
# Verify

```cpp
Node* f(int idx){
  if(idx>=n) return nullptr;
  if(pre[idx]==-1){
    idx++;
    return nullptr;
  }
  Node* node= new Node(pre[idx]);
  idx++;
  node->left=f(idx);
  node->right=f(idx);
  return node;
}
```

# Generation
```cpp
void f(Node* n){
  if(!node){
    v.pb(-1);
    return;
  } 
  v.pb(n->val);
  f(n->left);
  f(n->right);
}
```
