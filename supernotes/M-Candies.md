[M - Candies](https://atcoder.jp/contests/dp/tasks/dp_m)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1c710391-41b0-4180-a860-e7a0a0369596--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9b001360-32cc-4dc7-b210-dc009f014ea3--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b82d6837-2aba-4d58-b4eb-f43b8c26114c--image.png)

```cpp
void solve() {  
    //0 to 
    iinp(n);
    iinp(k);
    vinp(v,n);
    //dp[i][j]
    //dp[n][k] final sub problem
    //dp[i][j] = dp[i-1][j] + dp[i-1][j-1]+ ....... + dp[i-1][j-v[i]]
    //dp[i][j-1]= dp[i-1][j-1] + dp[i-1][j-2] + ...... dp[i-1][j-v[i]] + dp[i-1][j-v[i-1]-1]
    //dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-v[i-1]-1]
    vvl dp(n+1,vl(k+1,0));
    //dp[0][any]=0
    //dp[any][0]=1
    //dp[0][0]=1

    for(ll i=0;i<=n;i++){
        dp[i][0]=1;
    }
    for(ll i=1;i<=n;i++){
        for(ll j=1;j<=k;j++){
            dp[i][j]= moda(dp[i-1][j],dp[i][j-1]);
            if(j-v[i-1]-1>=0) dp[i][j]=moda(dp[i][j],-dp[i-1][j-v[i-1]-1]);
        }
    }

    pri(dp[n][k]);

}
```
