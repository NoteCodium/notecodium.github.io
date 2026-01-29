---
title: 6ApplicationOfSerializationDeserializat
---

{% raw %}
https://leetcode.com/problems/find-duplicate-subtrees/description/

1. return all duplicate subtrees.
2. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
3. vector<TreeNode*>

```python
void utilitySerialize(TreeNode* node, string &res){
    if(!node){
        res+="#,";
        return;
    }
    res+=(to_string(node->val)+",");
    utilitySerialize(node->left,res);
    utilitySerialize(node->right,res);
}

void fun(TreeNode* node , unordered_map<string , int> &m ,vector<TreeNode*> &ans){
     if(!node) return;
     string s = "";
     utilitySerialize(node , s);

    //we are serializing every subtree and seeing if that string repeats

     if(m[s] == 0){
        m[s]++;
     }
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
}|
```

Subtree of another tree

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_6ApplicationOfSerializationDeserializat__att_0001.png)

# Brute force     
1. Checking for equal trees at each node O(n^2)

by serialzation, but there is one problem

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_6ApplicationOfSerializationDeserializat__att_0002.png)

special serialization

```python
void us(TreeNode* node, string &res){
    if(!node){
        res+="#,";
        return;
    }
    res+=("^"+to_string(node->val)+",");
    us(node->left,res);
    us(node->right,res);
}
```

```python
void us(TreeNode* node, string &res){
    if(!node){
        res+="#,";
        return;
    }
    res+=("^"+to_string(node->val)+",");
    us(node->left,res);
    us(node->right,res);
    }
    
bool isSubtree(TreeNode* root, TreeNode* subRoot) {
    string subS,s;
    us(subRoot, subS);
    us(root,s);
    int found= s.find(subS);
    if(found==string::npos) return 0;
    //kmp runs linearly
    return 1;
}
```
{% endraw %}
