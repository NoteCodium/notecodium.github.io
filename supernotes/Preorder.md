[Binary Tree Preorder Traversal - LeetCode](https://leetcode.com/problems/binary-tree-preorder-traversal/)


```cpp
vector<int> preorderTraversal(TreeNode* root) {
    stack<TreeNode*> st;
    vector<int> traversal;
    if(!root) return traversal;
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


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/fb4899e8-6338-4ac7-af85-2fcb0740664b--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/319edd6e-fbfe-4334-999f-1073a3a0dc7a--image.png)
Getting back to rst after you have got to lst

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/417fd7c9-4dc0-4d52-aa70-3e701ece98aa--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/6402c588-7de7-4cde-8280-b22a444c3816--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2d29870a-d328-41ea-b3c9-27650c18ae0a--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f8fdd232-a6cf-4e1c-ab8c-7d791b98512c--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/838907b9-564e-4838-a483-1dff0eb95301--image.png)

