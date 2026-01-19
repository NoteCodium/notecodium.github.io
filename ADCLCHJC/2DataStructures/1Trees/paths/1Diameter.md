0. The biggest distance between any two nodes
1. Will always be between two leaves
2. Even in skew tree, where the definition of a leaf node is a node having only one node


https://leetcode.com/problems/diameter-of-binary-tree/description/


Max of 1+h1+h2 at all the nodes
Explanation: h1 is the biggest distance from that node till the end leaf node of that subtree
Diameter has to pass through one of the nodes


//length of path 
1. no. of nodes
2. no. of edges


```python
    int findHeight(TreeNode* root, int &maxNoOfNodes){
        if(!root) return 0;
        int h1=findHeight(root->left,maxNoOfNodes), h2=findHeight(root->right,maxNoOfNodes);
        maxNoOfNodes=max(maxNoOfNodes,1+h1+h2);
        return 1+max(h1,h2);
    }


    int diameterOfBinaryTree(TreeNode* root) {
        if(!root) return 0;
        int maxNoOfNodes=1;
        findHeight(root,maxNoOfNodes);
        return maxNoOfNodes-1;
        //return noOfEdges
    }
```
