---
title: 3Leaf2RootPath
---

{% raw %}
https://leetcode.com/problems/smallest-string-starting-from-leaf/description/

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_conver2Graph_3Leaf2RootPath__att_0001.png)

```python
class Solution {
public:
    void t(TreeNode* node, vector<TreeNode*> &leaves, unordered_map<TreeNode*, TreeNode*> &parent){
        if(!node) return;
        if(!node->left and !node->right){
            leaves.push_back(node);
        }
        if(node->left){
            parent[node->left]=node;
        }
        if(node->right){
            parent[node->right]=node;
        }
        t(node->left,leaves,parent);
        t(node->right,leaves,parent);
    }

    void tt(TreeNode* node, unordered_map<TreeNode*, TreeNode*> &parent, string &s){
        while(parent[node]){
            s.push_back(node->val+'a');
            node=parent[node];
        }
        s.push_back(node->val+'a');
    }


    string smallestFromLeaf(TreeNode* root) {
        unordered_map<TreeNode*, TreeNode*> parent;
        vector<TreeNode*> leaves;
        t(root, leaves, parent);
        vector<string> vos;
        for(auto leaf: leaves){
            string s;
            tt(leaf,parent,s);
            vos.push_back(s);
        }
        sort(vos.begin(),vos.end());
        return vos[0];
    }
};
```

itne jhanjhat karne badhiya all root to leaf path ka vos banate aur revrse karte

# Optimized

```python
class Solution {
    public:
        void f(TreeNode* node, string &ans, string &tmp){
            if(!node) return;
            tmp=char(node->val+'a')+tmp;
            if(!node->left and !node->right){
                if(ans=="" or tmp<ans){
                    ans=tmp;
                }
            }
            f(node->left,ans,tmp);
            f(node->right,ans,tmp);
            tmp.erase(0,1);
        }
    
    
        string smallestFromLeaf(TreeNode* root) {
            string ans="";
            string tmp="";
            f(root,ans,tmp);
            return ans;
        }
    };
```
{% endraw %}
