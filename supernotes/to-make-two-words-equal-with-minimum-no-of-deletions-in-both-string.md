https://leetcode.com/problems/delete-operation-for-two-strings/description/
```
//dp[i][j]= s1[i-1]==s2[j-1]?dp[i-1][j-1]: 1+ min(dp[i-1][j],dp[i][j-1])
```
