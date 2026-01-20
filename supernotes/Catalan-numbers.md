
1. That discord tle doubt

https://cses.fi/problemset/task/2187

2. n pair of brackets given, find number of different configurations such that all are balanced

https://cses.fi/problemset/task/2064/

# is nth catalan number

```
cat[0]=1
cat[i]=  (4i-2) // (i+1)   *  cat[i-1]   
```

```cpp
vl dp(n+1);
dp[0]=dp[1]=1;
for(ll i=2;i<=n;i++){
    for(ll j=0;j<i;j++){
        dp[i]=moda(dp[i],modm(dp[j],dp[i-j-1]));
    }
}
```
