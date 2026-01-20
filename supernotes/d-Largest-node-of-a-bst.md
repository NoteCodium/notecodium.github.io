
move right
always a node having single child

```cpp
Node* maxNode(Node* root){
    while(root->right){
        root=root->right;
    }
    return root; 
}
```



```cpp
pair<Node*, Node*> maxNode(Node* root, Node* par){
    Node* pred=root;
    Node* predPar=par;
    while(pred->right){
        predPar=pred;
        pred=pred->right;
    }
    return {pred,predPar}; 
}
```