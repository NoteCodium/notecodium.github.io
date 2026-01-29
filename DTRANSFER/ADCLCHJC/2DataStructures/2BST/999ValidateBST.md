---
title: 999ValidateBST
---

{% raw %}
https://leetcode.com/problems/validate-binary-search-tree/description/

given a bst, its inoder traversal will be sorted

```python
by traversal
```

```python
class Solution {
    public:
        void t(TreeNode* node, bool &ans, long &prev){
            if(!node or !ans) return;
            t(node->left,ans,prev);
            if(prev<node->val){
                prev=node->val;
            }
            else{
                ans=0;
                return;
            }
            t(node->right,ans,prev);
        }
    
        bool isValidBST(TreeNode* root) {
            bool ans=1;
            long prev=LONG_MIN;
            t(root,ans,prev);
            return ans;
        }
    };
```

way2

```python
vector<long> t(TreeNode* node){
    if(!node){
        return {LONG_MAX,LONG_MIN,1};
    } 
    if(!node->left and !node->right){
        return {node->val,node->val,1};            
    }

    auto l=t(node->left);
    auto r=t(node->right);
    bool flag=l[2] and r[2] and node->val>l[1] and node->val<r[0];
    long minn=min(l[0],(long)node->val);
    long maxx=max(r[1],(long)node->val);
    return {minn,maxx,flag};

}

bool isValidBST(TreeNode* root) {
    return t(root)[2];
}
```
{% endraw %}
