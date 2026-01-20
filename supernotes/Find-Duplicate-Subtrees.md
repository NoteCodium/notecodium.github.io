[Find Duplicate Subtrees - LeetCode](https://leetcode.com/problems/find-duplicate-subtrees/description/)

 1.  return all **duplicate subtrees**.
 2.  For each kind of duplicate subtrees, you only need to return the root node of any **one** of them.
 3.  vector<TreeNode*>

```cpp
void us(TreeNode* node, string &res){

    if(!node){
        res+="#,";
        return;
    }
    res+=(to_string(node->val)+",");
    us(node->left,res);
    us(node->right,res);
}

void fun(TreeNode* node , unordered_map<string , int> &m ,vector<TreeNode*> &ans){
     if(!node) return;
     string s = "";
     us(node , s);

     if(m[s] == 0) m[s]++;
     else if(m[s]==1){
         ans.push_back(node);
         m[s]++;
     }
     fun(node->left , m , ans);
     fun(node->right , m , ans);
 }
vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
    unordered_map<string , int> m;
    vector<TreeNode*> ans;
    fun(root , m , ans);
    return ans;
}
```
