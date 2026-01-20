[Problem - 1288C - Codeforces](https://codeforces.com/problemset/problem/1288/C)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/e5b686f8-6005-4e63-b194-1ac162333d31--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f9031049-fae9-402e-9d40-299fd84d9ead--image.png)

```cpp
void solve() {  
    ll x,len;
    inp(x,len);
    //dp[idx][x]=dp[idx-1][x]+dp[idx-1][x-1]+....dp[idx-1][1]
    //dp[idx][x-1]=dp[idx-1][x-1]+dp[idx-1][x-2] ...dp[idx-1][1]

    //dp[idx][x]=dp[idx-1][x]+dp[idx][x-1]

    //ans dp[2*len][1]+ dp[2*len][2]+  dp[2*len][x]
    //dp[i][j]=dp[i-1][j]+ dp[i][j-1]
    //dp[0][any]=1
    //dp[any][0]=0


    vvl dp(2*len,vl(x+1,0));
    for(ll i=1;i<=x;i++){
        dp[0][i]=1;
    }
    for(ll i=1;i<=2*len-1;i++){
        for(ll j=1;j<=x;j++){
            dp[i][j]=moda(dp[i-1][j],dp[i][j-1]);
        }
    }
    ll ans=0;
    for(ll i=1;i<=x;i++){
        ans=moda(ans,dp[2*len-1][i]);
    }
    pri(ans);
    
}

```
