# Brute force
[Lowest Common Ancestor of a Binary Tree - LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/)

### Edge cases
1. node is not present
2. duplicate value nodes

```cpp
void t(TreeNode* node, TreeNode* r1,TreeNode* r2,vector<TreeNode*> &p1, vector<TreeNode*> &p2, vector<TreeNode*> &tmp){
    if(!node) return;
    tmp.push_back(node);
    if(node==r1) p1=tmp;
    if(node==r2) p2=tmp;
    t(node->left,r1,r2,p1,p2,tmp);
    t(node->right,r1,r2,p1,p2,tmp);
    tmp.pop_back();
}



TreeNode* lowestCommonAncestor(TreeNode* r, TreeNode* r1, TreeNode* r2) {
    vector<TreeNode*> p1,p2,tmp;
    t(r,r1,r2,p1,p2,tmp);
    int i=0;
    while(i<p1.size() and i<p2.size()){
        if(p1[i]!=p2[i]) break;
        i++;
    }
    return p1[i-1];
}
```

# Optimized space
1. If you are standing at a node, and n1 and n2 are present in separate subtrees about that node, then that node is the lca
2. if both are in left you will go left r=r->left, keep doing till you get a lca, tc n^2
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/22de9eee-1f37-4f06-bb3a-e4c933dc1a8a--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2c92ed5d-ab3a-4004-915f-95401bd2ed21--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/57b64faa-349e-4aa7-be2e-5cc735430da4--image.png)


----------------------------------------------------------------------------------------------------------
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0e2218b0-7320-4771-aee6-70a34cc0cc34--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bc06e8f5-5329-443a-94b9-87ac00ab1fa8--image.png)



If we aready found the lca in a subtree
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/73cd3a48-b363-4775-8b7b-0b1a026e9fa1--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ccb0d6b6-d99e-48c1-ba79-b778de802664--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d7735761-e98f-4505-a60e-26c0cf162e94--image.png)

```cpp
TreeNode* lowestCommonAncestor(TreeNode* n, TreeNode* r1, TreeNode* r2) {
    if(!n) return NULL;
    if(n==r1 or n==r2) return n;
    TreeNode* lst=lowestCommonAncestor(n->left,r1,r2);
    TreeNode* rst=lowestCommonAncestor(n->right,r1,r2);
    if(!lst) return rst;
    if(!rst) return lst;
    //it means both lst and rst is non null
    return n;      
}
```



