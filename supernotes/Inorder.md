[Binary Tree Inorder Traversal - LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ebc32413-4bc4-46e5-9352-5ce3be71ede6--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4893c004-4d46-49ae-9be2-f79812bdd22f--image.png)

```cpp
vector<int> inorderTraversal(TreeNode* root) {
    stack<pair<TreeNode*,bool>> st;
    vector<int> traversal;
    if(!root) return traversal;
    st.push({root,0});
    while(!st.empty()){
        pair<TreeNode*,bool> node=st.top();
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




# Without flag and hence saving space