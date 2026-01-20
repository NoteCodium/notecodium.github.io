for n=0 {}
      n=1 {root}

```cpp
vector<TreeNode*> f(int n){
    if(n==0){
        vector<TreeNode*> ans;
        ans.push_back(nullptr);
        return ans;
    }   
    vector<TreeNode*> ans;
    for(int i=0;i<=n-1;i++){
        vector<TreeNode*> lsts=f(i);
        vector<TreeNode*> rsts=f(n-1-i);
        for(auto TreePtrI:lsts) for(auto TreePtrJ:rsts) ans.push_back(new TreeNode(0,TreePtrI,TreePtrJ)); 
    }
    return ans;
} 

vector<TreeNode*> allPossibleFBT(int n) {
    return f(n);
}
```
