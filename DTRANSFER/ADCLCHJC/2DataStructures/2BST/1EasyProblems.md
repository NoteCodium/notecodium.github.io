---
title: 1EasyProblems
---

{% raw %}
https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

inorder traveral will give data in sorted manner

```python

void t(TreeNode* node, vector<int> &v){
    if(!node) return;
    t(node->left,v);
    v.push_back(node->val);
    t(node->right,v);
}

int kthSmallest(TreeNode* root, int k) {
    vector<int> v;
    t(root,v);
    return v[k-1];
}
```

```python
void t(TreeNode* node, int &ans, int &cnt, int k){
    if(!node or ans) return;
    t(node->left,ans,cnt,k);
    if(cnt++==k) ans=node->val;
    t(node->right,ans,cnt,k);
}

int kthSmallest(TreeNode* root, int k) {
    int ans=0,cnt=1;
    t(root,ans,cnt,k);
    return ans;
    }
```

https://leetcode.com/problems/range-sum-of-bst/description/?envType=daily-question&envId=2024-01-08    
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_2BST_1EasyProblems__att_0001.png)

```python
int rangeSumBST(TreeNode* root, int l, int h) {
    if(!root) return 0;
    int val=root->val;
    if(val>=l and val<=h) return val+rangeSumBST(root->left,l,h)+rangeSumBST(root->right,l,h);
    if(val<l) return rangeSumBST(root->right,l,h);
    else return rangeSumBST(root->left,l,h);
}
```

https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1?category%5B%5D=Binary%2520Search%2520Tree&page=1&query=category%5B%5DBinary%2520Search%2520Treepage1category%5B%5DBinary%2520Search%2520Tree

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_2BST_1EasyProblems__att_0002.png)
{% endraw %}
