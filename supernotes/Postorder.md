rst lst root
[Binary Tree Postorder Traversal - LeetCode](https://leetcode.com/problems/binary-tree-postorder-traversal/description/)
=> using the same approach as done in inorder


```cpp
vector<int> postorderTraversal(TreeNode* root) {
    stack<pair<TreeNode*,bool>> st;
    vector<int> traversal;
    if(!root) return traversal;
    st.push({root,0});
    while(!st.empty()){
        pair<TreeNode*,bool> node=st.top();
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

