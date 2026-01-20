[leetcode.com](https://leetcode.com/problems/longest-increasing-subsequence/)

```cpp
class Solution {
public:
int f(int idx, int prev_idx, int n, vector<int> &v, vector<vector<int>> &mem){
    if(idx==n) return 0;
    if(mem[idx][prev_idx+1]!=-1) return mem[idx][prev_idx+1];
    int notTake= 0 + f(idx+1,prev_idx,n,v,mem);
    int take= prev_idx==-1 or v[idx]>v[prev_idx]? 1+ f(idx+1,idx,n,v,mem):0;
    return mem[idx][prev_idx+1]=max(notTake,take);
}


int lengthOfLIS(vector<int>& v) {
    int n=v.size();
    vector<vector<int>> mem(n,vector<int>(n,-1));
    return f(0,-1,n,v,mem);   
}
};
```
