min. no of operations required  to change t into s when we can do following with s

```
dp[0][any]=any;
dp[any][0]=0;
dp[0][0]=0;
```

```
dp[i][j]= s[i-1]==t[i-1]?dp[i-1][j-1]:min(
dp[i][j-1]. //added a character in s which mateched with t and the next char of t got activated
dp[i-1][j].// deleted a char of s
dp[i-1][j-1] //replaced a character of s which matched with t
);
```

