[CSES - Dice Combinations](https://cses.fi/problemset/task/1633)
https://cses.fi/problemset/task/1635

```cpp
ll f(ll k, vl &v, int n){
    if(k==0) return 1;
    if(k<0) return 0;
    ll sum=0;
    for(ll i=0;i<n;i++){
        sum+=f(k-v[i],v,n);
    }
    return sum;
}
```


```
//dp[k] 
//dp[k]=dp[k-v[0]]+dp[k-v[1]]+dp[k-v[2]]......dp[k-v[n-1]] 
//dp[0]=1 
//dp[k]
```
```cpp
vl dp(k+1,0); 
dp[0]=1; 
for(int i=1;i<=k;i++){ 
  ll buff=0; 
  for(int j=0;j<n;j++){ 
    if(i-v[j]>=0) buff=moda(buff,dp[i-v[j]]); 
  } 
  dp[i]=buff; 
} 
print(dp[k
```
# Optimizing space

