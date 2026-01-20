[leetcode.com](https://leetcode.com/problems/longest-increasing-subsequence/)
1. not very tough to manipulate increasing and strictly increasing lis
2. 

```cpp
int ans=1;
vector<int> dp(n,1);
for(int i=1;i<n;i++){
    for(int j=0;j<i;j++){
        if(v[j]<v[i] and dp[j]+1>dp[i]) dp[i]=dp[j]+1;
    }
    ans=max(ans,dp[i]);
}
```
