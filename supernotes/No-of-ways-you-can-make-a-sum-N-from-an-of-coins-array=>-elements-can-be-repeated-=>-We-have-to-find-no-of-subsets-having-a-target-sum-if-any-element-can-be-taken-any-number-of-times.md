[CSES - Coin Combinations II](https://cses.fi/problemset/task/1636)

2. Even when you are taking an element, dont change the index

1. The array elements do not contain 0
```cpp
ll f(ll idx, ll k, vl &v){ 
    if(k==0) return 1;   
    if(idx==-1 or k<0) return 0;      
    f(idx-1,k,v)+f(idx,k-v[idx],v); 
} 
```

```cpp
ll f(ll idx, ll k, vvl &mem, vl &v){ 
    if(k==0) return 1;   
    if(idx==-1 or k<0) return 0;     
    if(mem[idx][k]!=-1) return mem[idx][k]; 
    return mem[idx][k]=f(idx-1,k,mem,v)+f(idx,k-v[idx],mem,v); 
} 
```

```cpp
//dp[0][any sum]=0
vvl dp(n+1,vl(k+1,0));
//dp[any sum][0]=1
for(int i=0;i<=n;i++) dp[i][0]=1; 
for(int i=1;i<=n;i++){ 
    for(int j=1;j<=k;j++){                 
        dp[i][j]=dp[i-1][j]; 
        if(j-v[i-1]>=0) dp[i][j]=moda(dp[i][j],dp[i][j-v[i-1]]); 
    }       
} 
print(dp[n][k]);
```
# Space optimized

```cpp
//dp[i][j]=
//dp[i-1][j] + dp[i][j-v[i-1]]
In the worst case dp[i][j] depends on the previous row of the dp matrix

We can even do it only with one vector
```

```cpp
ans[0]=1; 
for(int i=1;i<=n;i++){ 
    for(int j=1;j<=k;j++){ 
        if(j-v[i-1]>=0) ans[j]=moda(ans[j],ans[j-v[i-1]]); 
    }       
} 
print(ans[k]); 
```



