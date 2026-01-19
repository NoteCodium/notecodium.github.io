Any path having maximum sum of values


https://leetcode.com/problems/binary-tree-maximum-path-sum/description/


![image.png](2Path_images/image.png)


```python
//ans, max_con_sum
vector<int> f(TreeNode* root){
    if(!root) return {INT_MIN,0};
    if(!root->left and !root->right) return {root->val,root->val};
    auto lst=f(root->left);
    auto rst=f(root->right);
    int l_max_con_sum=lst[1];
    int r_max_con_sum=rst[1];

    int max_con_sum= root->val + max({0,l_max_con_sum,r_max_con_sum});
    //either of the two left or right things will be taken , we have
    //to make continous sum so cant take both 2

    int lans=lst[0];
    int rans=rst[0];

    int ans=max({lans,rans,root->val+max(0,l_max_con_sum)+max(0,r_max_con_sum)});
    //is wale me dono le sakte hain to make a new answer, 
    //and compare with preexisting answers

    return {ans,max_con_sum};
}

int maxPathSum(TreeNode* root) {
    return f(root)[0];
}
```
