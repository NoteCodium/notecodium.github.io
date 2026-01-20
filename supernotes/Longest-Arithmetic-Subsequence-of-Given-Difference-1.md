[Longest Arithmetic Subsequence of Given Difference - LeetCode](https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/?envType=study-plan-v2&envId=dynamic-programming)

```cpp
int longestSubsequence(vector<int>& v, int k) {
    int n=v.size();
    int ans=1;
    vector<int> dp(n,1);
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(v[i]-v[j]==k and dp[j]+1>dp[i]) dp[i]=dp[j]+1;
        }
        ans=max(ans,dp[i]);
    }  
    return ans;
}
```
