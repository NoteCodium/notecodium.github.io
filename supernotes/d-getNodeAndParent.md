
Test it

```cpp
pair<Node*, Node*> getNodeAndPar(Node* root, int k){
    Node* node=root;
    Node* par=nullptr;
    while(node){
        if(node->val==k) return {node,par};
        par=node;
        if(k>node->val) node=node->right;
        else node=node->left;
    }
    return {nullptr,nullptr};
}
```


```cpp
pair<Node*, Node*> getNodeAndPar(Node* root, int k){
    Node* node=root;
    Node* par=nullptr;
    while(node){
        if(node->val==k) break;
        par=node;
        if(k>node->val) node=node->right;
        else node=node->left;
    }
    return {node,par};
}
```