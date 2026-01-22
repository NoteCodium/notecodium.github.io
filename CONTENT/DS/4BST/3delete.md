https://leetcode.com/problems/delete-node-in-a-bst/description/

# Brute force

generate an array out of tree

delete element

generate tree out of array

# Method

![image.png](/images/image-303.png)



Always track the parent of the node to be deleted

1. Leaf node:, Easiest to delete





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

