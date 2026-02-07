[leetcode.com](https://leetcode.com/problems/validate-binary-search-tree/description/)

![image.png](../images/a6c2d8c6-36a8-44c2-ac42-f1ef79f5ee77--image.png)

![image.png](../images/8d3096e3-b925-4ace-8e5a-d6772eff3b02--image.png)
![image.png](../images/cfe1aecd-00a8-4615-ba8f-8041ee62f291--image.png)

```cpp
vector<long> t(TreeNode* node){
    if(!node) return {LONG_MAX,LONG_MIN,1};
    auto l=t(node->left);
    auto r=t(node->right);
    bool flag=l[2] and r[2] and node->val>l[1] and node->val<r[0];
    long minn=min({l[0],r[0],(long)node->val});
    long maxx=max({l[1],r[1],(long)node->val});
    return {minn,maxx,flag};

}

bool isValidBST(TreeNode* root) {
    return t(root)[2];
}
```
