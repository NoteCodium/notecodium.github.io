[leetcode.com](https://leetcode.com/problems/diameter-of-binary-tree/description/)

0. The biggest distance between any two nodes
1. Will always be between two leaves
2. Even in skew tree, where the definition of a leaf node is a node having only one node



# Method 1
1. Max of 1+h1+h2 at all the nodes
2. Explanation: h1 is the biggest distance from that node till the end leaf node of that subtree
3. Diameter has to pass through one of the nodes


```cpp
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
    }
```


# Method 2
![image.png](../images/f18f3fa0-9892-43a5-a902-389d5d117b52--image.png)

![image.png](../images/39fef474-8cf7-434d-b608-f7ae8c6d385d--image.png)

# Optimization
![image.png](../images/c5d5518d-131f-4749-9755-860a7a4264d5--image.png)
![image.png](../images/15bcf3f1-876b-45a3-b8a2-03f9ace4e4f2--image.png)

# Method 3
![image.png](../images/b4b2282c-23c7-4495-9f1c-27328838aa3f--image.png)
![image.png](../images/6f17ca33-dee1-40dc-be8d-30164147138a--image.png)
