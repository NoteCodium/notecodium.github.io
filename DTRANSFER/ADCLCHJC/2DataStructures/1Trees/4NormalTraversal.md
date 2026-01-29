---
title: 4NormalTraversal
---

{% raw %}
# Traditional  
1. Preorder: root l r
2. Inorder:  l root r
3. Post order: l r root

https://leetcode.com/problems/binary-tree-preorder-traversal/description/  
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0001.png)

```python
class Solution {
    public:
        void preorder(TreeNode* root, vector<int>& res) {
            if (!root) return;
            res.push_back(root->val);              // Visit node
            preorder(root->left, res);             // Traverse left subtree
            preorder(root->right, res);            // Traverse right subtree
        }
    
        vector<int> preorderTraversal(TreeNode* root) {
            vector<int> res;
            preorder(root, res);
            return res;
        }
    };
```

preorder traversal where null nodes are represented as -1

```python
void f(Node* n){
    if(!node){
      v.pb(-1);
      return;
    } 
    v.pb(n->val);
    f(n->left);
    f(n->right);
  }
```

# Iterative

## Preorder
https://leetcode.com/problems/binary-tree-preorder-traversal/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0002.png)

suppose you printed root and done node=node->left, how will you comeback to node->right

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0003.png)  
in recursion f(7) was made to wait while we do f(3)

```python
vector<int> preorderTraversal(TreeNode* root) {
    stack<TreeNode*> st;
    vector<int> traversal;
    if(!root) return traversal;
    //
    st.push(root);
    while(!st.empty()){
        TreeNode* node=st.top();
        st.pop();   
        traversal.push_back(node->val);
        if(node->right) st.push(node->right);
        if(node->left) st.push(node->left);
    }
    return traversal;
}
```

## Inorder
https://leetcode.com/problems/binary-tree-inorder-traversal/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0004.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0005.png)

```python
vector<int> inorderTraversal(TreeNode* root) {
    stack<pair<TreeNode*,bool>> st;
    vector<int> traversal;
    if(!root) return traversal;
    st.push({root,0});
    while(!st.empty()){
        auto node=st.top();
        st.pop();
        if(node.second) traversal.push_back(node.first->val);
        else{
            if(node.first->right) st.push({node.first->right,0});
            st.push({node.first,1});
            if(node.first->left) st.push({node.first->left,0});                
        }
    }
    return traversal;
}
```

# FAANG

without flag

## Postorder
https://leetcode.com/problems/binary-tree-postorder-traversal/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0006.png)

```python
// vector<int> inorderTraversal(TreeNode* root) {
//     stack<pair<TreeNode*,bool>> st;
//     vector<int> traversal;
//     if(!root) return traversal;
//     st.push({root,0});
//     while(!st.empty()){
//         pair<TreeNode*,bool> node=st.top();
//         st.pop();
//         if(node.second) traversal.push_back(node.first->val);
//         else{
//             if(node.first->right) st.push({node.first->right,0});
//             st.push({node.first,1});
//             if(node.first->left) st.push({node.first->left,0});                
//         }
//     }
//     return traversal;
// }
vector<int> postorderTraversal(TreeNode* root) {
    stack<pair<TreeNode*,bool>> st;
    vector<int> traversal;
    if(!root) return traversal;
    st.push({root,0});
    while(!st.empty()){
        auto node=st.top();
        st.pop();
        if(node.second) traversal.push_back(node.first->val);
        else{
            st.push({node.first,1});
            if(node.first->right) st.push({node.first->right,0});
            if(node.first->left) st.push({node.first->left,0});                
        }
    }
    return traversal;        
}
```

# FAANG

Preorder, Inorder, and Postorder Traversal in one Traversal  
https://www.naukri.com/code360/problems/tree-traversal_981269   
# Unintuituve

https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_4NormalTraversal__att_0007.png)
{% endraw %}
