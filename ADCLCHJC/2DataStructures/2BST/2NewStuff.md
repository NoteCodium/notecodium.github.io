# Largest BST in a Binary Tree


https://www.geeksforgeeks.org/problems/largest-bst/1


single node is a bst 


```python
// vector<long> t(TreeNode* node){
//     if(!node){
//         return {LONG_MAX,LONG_MIN,1};
//     } 
//     if(!node->left and !node->right){
//         return {node->val,node->val,1};            
//     }

//     auto l=t(node->left);
//     auto r=t(node->right);
//     bool flag=l[2] and r[2] and node->val>l[1] and node->val<r[0];
//     long minn=min(l[0],(long)node->val);
//     long maxx=max(r[1],(long)node->val);
//     return {minn,maxx,flag};

// }

// bool isValidBST(TreeNode* root) {
//     return t(root)[2];
// }
```

for writing cleaner code, instead of vector   
![image.png](2NewStuff_images/image.png)





![image.png](2NewStuff_images/image.png)    
https://leetcode.com/problems/recover-binary-search-tree/description/    


![image.png](2NewStuff_images/image.png)


the special case when you swap the inorder successor with predecessor


![image.png](2NewStuff_images/image.png)


![image.png](2NewStuff_images/image.png)


![image.png](2NewStuff_images/image.png)





given a bst, check if a pair sum is k or not   
https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1


1. doing with unordered map
2. Inorder traversal to get a sorted array    



Both taking space


Find median of bst    
https://www.geeksforgeeks.org/problems/median-of-bst/1    
https://leetcode.com/problems/find-median-from-data-stream/solutions/74166/Solution-using-Binary-Search-Tree/


![image.png](2NewStuff_images/image.png)


![image.png](2NewStuff_images/image.png)


doubt    
![image.png](2NewStuff_images/image.png)


# MAANg

https://www.geeksforgeeks.org/find-median-bst-time-o1-space/


pairs violating bst property:    
https://www.geeksforgeeks.org/problems/pairs-violating-bst-property--212515/1    


solve in n logn




