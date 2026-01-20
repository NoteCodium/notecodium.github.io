[leetcode.com](https://leetcode.com/problems/binary-tree-paths/)

```cpp
void f(TreeNode* node, vector<int> &tmp, vector<string> &ans){
    if(!node) return;
    if(!node->left and !node->right){
        string s;
        for(int x:tmp){
            s+=to_string(x);
            s+="->";
        }
        s.pop_back();
        s.pop_back();
        ans.push_back(s);

        return;
    }
    tmp.push_back(node->val);
    f(node->left,tmp,ans);
    f(node->right,tmp,ans);
    tmp.pop_back();

}

    vector<string> binaryTreePaths(TreeNode* root) {
        vector<int> tmp;
        vector<string> ans;
        if(!root) return ans;
        f(root,tmp,ans);
        return ans;
    }
```