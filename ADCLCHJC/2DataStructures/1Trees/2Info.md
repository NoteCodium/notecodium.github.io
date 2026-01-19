```python
# Complete
1. filled level by level
2. height in logn
3. node->left karte karte
4. For a given root, either the LST or RST will be a perfect tree
```

4. For a given root, either the LST or RST will be a perfect tree


![image.png](2Info_images/image.png)


vice versa is not true


https://leetcode.com/problems/check-completeness-of-a-binary-tree/


![image.png](2Info_images/image.png)


![image.png](2Info_images/image.png)


![image.png](2Info_images/image.png)


# Perfect
1. total no. of nodes is 2^h -1
2. No. of nodes in the level h is 2^(h-1)

SO, total no. of nodes is (noOfNodesInLastLevel*2 -1)


this is the reason the number of nodes is proportional to the breadth of the tree.


```python
//check for Perfect tree
hleft==hright
```

## No. of nodes in a complete binary tree  
https://leetcode.com/problems/count-complete-tree-nodes/description/


//Method 1 in copy     
I have digitised it somewhere


```python
//Method 2  
//For a given root, either the LST or RST will be a perfect tree
pair<bool,int> isPerfect(TreeNode* root){
    TreeNode* tmp=root;
    int hleft=0;
    while(tmp){
        hleft++;
        tmp=tmp->left;
    }

    tmp=root;
    int hright=0;
    while(tmp){
        hright++;
        tmp=tmp->right;
    }
    return {hleft==hright,hleft};

}

int countNodes(TreeNode* root) {
    if(!root) return 0;
    int cnt=1;
    pair<bool,int> pLeft=isPerfect(root->left), pRight=isPerfect(root->right);

    if(pLeft.first) cnt+=pow(2,pLeft.second)-1;
    else cnt+=countNodes(root->left);


    if(pRight.first) cnt+=pow(2,pRight.second)-1;
    else cnt+=countNodes(root->right);

    return cnt;
}
```

```python
# Full
1. Every node have either 0 or 2 children
2. The nodes having 0 children are leaf node
```

3. Total no. of nodes in each subtree is odd 

