All possible full binary tree 


A full binary tree nodes will have either 0 or 2 children
No. of nodes in any subtree is odd, actually, the no. of nodes in the subtree rooted at root (the actual tree) is also odd


https://leetcode.com/problems/all-possible-full-binary-trees/description/


unoptimized


```python
//n will be odd
//no of nodes in lst will vary from 1 to n-2
vector<TreeNode*> f(int n){
    //vl ans will store all the possible subtree with that many nodes
    vector<TreeNode*> ans;
    if(n==1){
        ans.push_back(new TreeNode());
        return ans;
    }   
    for(int i=1;i<=n-2;i+=2){
        vector<TreeNode*> lsts=f(i);
        vector<TreeNode*> rsts=f(n-1-i);
        for(auto TreePtrI:lsts){
            for(auto TreePtrJ:rsts){
                ans.push_back(new TreeNode(0,TreePtrI,TreePtrJ)); 
            } 
        } 
    }
    return ans;
} 

vector<TreeNode*> allPossibleFBT(int n) {
    return f(n);
}
```

```python
vector<TreeNode*> allPossibleFBT(int n) {
    vector<vector<TreeNode*>> trees(n+1);
    trees[1].push_back({new TreeNode(0)});
    //generating results for 3 to n nodes  
    for(int i=3;i<=n;i+=2){
        for(int j=1;j<i;j+=2){
            vector<TreeNode*> lsts=trees[j];
            vector<TreeNode*> rsts=trees[i-1-j];
            for(auto TreePtrI:lsts){
                for(auto TreePtrJ:rsts){
                    trees[i].push_back(new TreeNode(0,TreePtrI,TreePtrJ));
                }
            }
        }
    }
    return trees[n];        
}
```

normal tree


```python
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
        for(auto TreePtrI:lsts){
            for(auto TreePtrJ:rsts){
                ans.push_back(new TreeNode(0,TreePtrI,TreePtrJ)); 
            } 
        } 
    }
    return ans;
} 

vector<TreeNode*> allPossibleFBT(int n) {
    return f(n);
}
```
