```cpp
bool isLeaf(Node* node){
    return (!node->left and !node->right);
}
```

```cpp
bool hasSingleChild(Node* node){
    return (node->left and !node->right) or (!node->left and node->right);
}
```