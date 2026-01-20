```
//dp[0][j]=0
//dp[i][0]=0
//dp[i][j]  ::such that the substring end at i and j
//ans=0
//dp[i][j] = s1[i-1]==s2[j-1]?1+dp[i-1][j-1]:0
// keep on doing ans=max(ans,dp[i][j])
```
[Longest Common Substring | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1)
```cpp
int ans=0;
  vector<vector<int>> dp(n+1,vector<int>(m+1,0));
  for(int i=1;i<=n;i++){
      for(int j=1;j<=m;j++){
          dp[i][j] = s[i-1]==t[j-1]?1+dp[i-1][j-1]:0;
          ans=max(ans,dp[i][j]);
      }
  }
  return ans;
```

# Do it from Top bottom?
```cpp
int h(string &s1, string &s2, int i, int j){
    if(i==-1 or j==-1) return 0;
    return s1[i]==s2[j]
}

int longestCommonSubstr (string s1, string s2, int n, int m){
    
}
```
