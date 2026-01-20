
1. You have to create srev
# longest repeating subsequence in a string
```cpp
int LongestRepeatingSubsequence(string s){
    string s1=s,s2=s;
    int n=s.size();
    int n1=n,n2=n;
    vector<vector<int>> dp(n1+1,vector<int>(n2+1,0));
    for(int i=1;i<=n1;i++){
        for(int j=1;j<=n2;j++){
            dp[i][j]= s1[i-1]==s2[j-1] and i!=j ? 1+dp[i-1][j-1] : max(dp[i-1][j],dp[i][j-1]);
        }
    }
    return dp[n1][n2];
}
```