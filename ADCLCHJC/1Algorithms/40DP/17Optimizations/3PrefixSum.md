WAY1


![image.png](3PrefixSum_images/image.png)


way2 (archieve?)


![image.png](3PrefixSum_images/image.png)


![image.png](3PrefixSum_images/image.png)


![image.png](3PrefixSum_images/image.png)


https://codeforces.com/problemset/problem/1288/C


![image.png](3PrefixSum_images/image.png)


all the elements in array b are smaller then min and hence smaller then all the elements in b till minn


![image.png](3PrefixSum_images/image.png)


![image.png](3PrefixSum_images/image.png)


->      
    |    
    v    
<-    

continuously increasing loop


![image.png](3PrefixSum_images/image.png)


f[i][j-1]= f[i-1][1]+f[i-1][2]+......+ f[i-1][j-1]


f[i][j]= f[i][j-1]+f[i-1][j]


so basically we have to make a subsequence of length 2*len from elements      
1 to limit such that it is increasing 


```python
vvl dp(2*len+1,vl(limit+1,0));
for(ll i=1;i<=limit;i++){
    dp[1][i]=1;
}
for(ll i=2;i<=2*len;i++){
    for(ll j=1;j<=limit;j++){   
        dp[i][j]=moda(dp[i-1][j],dp[i][j-1]);
    }
}
ll ans=0;
for(ll i=1;i<=limit;i++){
    ans=moda(ans,dp[2*len][i]);
}
```

![image.png](3PrefixSum_images/image.png)


![image.png](3PrefixSum_images/image.png)


https://atcoder.jp/contests/dp/tasks/dp_m


![image.png](3PrefixSum_images/image.png)


```python
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

https://atcoder.jp/contests/abc222/tasks/abc222_d


![image.png](3PrefixSum_images/image.png)


![image.png](3PrefixSum_images/image.png)


matter




