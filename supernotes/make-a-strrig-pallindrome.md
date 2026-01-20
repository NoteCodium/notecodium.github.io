[Just a moment...](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/)

```
dp[i][j]= s[i]==s[j]?dp[i+1][j-1]: 1+ min(dp[i+1][j],dp[i][j-1])
```
    