

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

bool isLeaf(Node* node){
    return (!node->left and !node->right);
}

bool hasSingleChild(Node* node){
    return (node->left and !node->right) or (!node->left and node->right);
}

Node* deleteLeaf(Node*node, Node*par){
    if(par->left==node) par->left=nullptr;
    else par->right=nullptr;
    return node;
}

Node* deleteSingleChild(Node*node, Node*par){
    if(node->right){
        if(par->right==node) par->right=node->right;
        else par->left=node->right;
        node->right=nullptr;
    }
    else{
        if(par->right==node) par->right=node->left;
        else par->left=node->left;
        node->left=nullptr;
    }
    return node;
}

pair<Node*, Node*> maxNode(Node* root, Node* par){
    Node* pred=root;
    Node* predPar=par;
    while(pred->right){
        predPar=pred;
        pred=pred->right;
    }
    return {pred,predPar}; 
}


Node* deleteDoubleChild(Node*node, Node*par){
    //dont call it directly for roots
    pair<Node*, Node*> p=maxNode(node->left,node);
    Node* pred=p.first;
    Node* predPar=p.second;
    Node* attach=nullptr;
    if(isLeaf(pred)) attach=deleteLeaf(pred,predPar);
    else attach=deleteSingleChild(pred,predPar);
    //root node deletion will have par equals to null
    if(par and par->right==node) par->right=attach;
    else if(par and par->left==node) par->left=attach;
    attach->left=node->left;
    attach->right=node->right;
    node->left=nullptr;
    node->right=nullptr;
    return node;
}    

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

public:
Node* deleteNode(Node* root, int k) {
    auto p=getNodeAndPar(root, k);
    Node* node=p.first;
    Node* parent=p.second;
    if(!node) return root;
    if(node==root) return deleteRoot(root);
    Node* tmp=nullptr;
    if(isLeaf(node)) tmp=deleteLeaf(node,parent);
    else if(hasSingleChild(node)) tmp=deleteSingleChild(node,parent);
    else tmp=deleteDoubleChild(node,parent);
    delete(tmp);
    return root;
}
```