---
title: 5BSTLCA
---

{% raw %}
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_2BST_5BSTLCA__att_0001.png)

then r is the lca

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_2BST_5BSTLCA__att_0002.png)

edge case

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_2BST_5BSTLCA__att_0003.png)

if the curr reached any of the node then return that node

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_2BST_5BSTLCA__att_0004.png)

# FAANG    
iterative approach

```python
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
{% endraw %}
