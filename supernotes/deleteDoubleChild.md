![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f9215db6-7846-4b27-acdc-2c436d5f953e--image.png)

```cpp
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
```