https://leetcode.com/problems/delete-node-in-a-bst/description/

# Brute force

generate an array out of tree

delete element

generate tree out of array

# Method

![image.png](/images/image-303.png)



Always track the parent of the node to be deleted

1. Leaf node 
2. Easiest to delete

```
bool isLeaf(Node* node){
    return (!node->left and !node->right);
}
```

```cpp
//returns The address of the deleted leaf
Node* deleteLeaf(Node*node, Node*par){
    if(par->left==node) par->left=nullptr;
    else par->right=nullptr;
    return node;
}
//what if we dont return the node
```



1. Single child node

![image.png](/images/image-299.png)

k=35



![image.png](/images/image-300.png)

![image.png](/images/image-301.png)

![image.png](/images/image-302.png)





![image.png](/images/image-304.png)



This node will either a single child node or a leaf node

```
Node* maxNode(Node* root){
    while(root->right){
        root=root->right;
    }
    return root; 
}
```

```cpp
pair<Node*, Node*> maxNode(Node* root, Node* par){
    Node* node=root;
    while(node->right){
        par=node;
        node=node->right;
    }
    return {node,par}; 
}
```

```
bool hasSingleChild(Node* node){
    return (node->left and !node->right) or (!node->left and node->right);
}
```

![image.png](/images/image-305.png)

```cpp
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
```