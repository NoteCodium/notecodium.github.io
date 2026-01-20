[leetcode.com](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

1. non empty
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a7ab7f8e-5f75-468e-8d98-515afa2fcbd2--image.png)

1. A tree can not have a left subtreee or right subtree about a turn point
2. Maximum sum path can lie in
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a0735b45-9e54-4fc4-8c4f-179a36572077--image.png)
3. for each left and right subtree, we need its ans, and maximum sum which originate with the root of the subtree


```cpp
pair<int,int> f(TreeNode* root){
    if(!root) return {INT_MIN,0};
    pair<int,int> lst=f(root->left);
    pair<int,int> rst=f(root->right);
    int l_max_con_sum=lst.second;
    int r_max_con_sum=rst.second;

    int max_con_sum= root->val + max({0,l_max_con_sum,r_max_con_sum});
    //either of the two left or right things will be taken , we have
    //to make continous sum so cant take both 2

    int lans=lst.first;
    int rans=rst.first;

    int ans=max({lans,rans,root->val+max(0,l_max_con_sum)+max(0,r_max_con_sum)});
    //is wale me dono le sakte hain to make a new answer, 
    //and compare with preexisting answers

    return {ans,max_con_sum};
}

int maxPathSum(TreeNode* root) {
    return f(root).first;
}
```
