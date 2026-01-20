```cpp
Node* deleteRoot(Node* root){
    Node* ans=nullptr;
    if(isLeaf(root)){
        delete(root);
        return nullptr;
    }
    if(hasSingleChild(root)){
        ans=root->left?root->left:root->right;
        delete(root);
        return ans;
    }
    pair<Node*, Node*> p=maxNode(root->left,root);
    Node* pred=p.first;
    deleteDoubleChild(root,nullptr);
    return pred;        
}
```