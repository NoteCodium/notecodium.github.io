```cpp
Node* deleteLeaf(Node*node, Node*par){
    if(par->left==node) par->left=nullptr;
    else par->right=nullptr;
    return node;
}
```