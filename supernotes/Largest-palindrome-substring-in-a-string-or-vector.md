This is illegeal for substring, true for subsequence
```
//dp[i][j]= s[i]==s[j]?2+dp[i+1][j-1]:max(dp[i+1][j],dp[i][j-1]);
```

We use to fill the dp matrix, and see which is the length of largest palindrome

```
//dp[i][j]= s[i]==s[j] and dp[i+1][j-1]
//dp[i][i]=1
```


```cpp
string longestPalindrome(string s) {
    int n=s.size();
    int fi=0,len=1;
    vector<vector<bool>> dp(n,vector<bool>(n,1));
    for(int d=1;d<n;d++){
        int i=0,j=d;
        while(i<n and j<n){
            dp[i][j]= s[i]==s[j] and dp[i+1][j-1];
            if(dp[i][j]){
                if(j-i+1>len){
                    len=j-i+1;
                    fi=i;
                }
            }
            i++;
            j++;
        }
    }
    return s.substr(fi,len);
}
```

