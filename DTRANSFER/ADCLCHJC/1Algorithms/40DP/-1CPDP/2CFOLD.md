---
title: 2CFOLD
---

{% raw %}
# Lift     
https://codeforces.com/problemset/problem/1249/E

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_40DP_-1CPDP_2CFOLD__att_0001.png)

```python
void solve() {
    ll n,c;
    inp(n,c);
    vinp(s,n-1);
    vinp(e,n-1);
    vvl dp(n+1,vl(2));
    dp[1][0]=0;
    dp[1][1]=c;
    cout<<min(dp[1][0], dp[1][1])<<" ";
    ///o-> you ae on stairs
    //1-> you are on lift
    for(ll i=2;i<=n;i++){
        dp[i][0]=min(s[i-2]+dp[i-1][1],s[i-2]+dp[i-1][0]);
        dp[i][1]=min(e[i-2]+dp[i-1][0]+c,e[i-2]+dp[i-1][1]);
        cout<<min(dp[i][0],dp[i][1])<<" ";
    }
    pri();    
}
```

# Tetrahedron

https://codeforces.com/problemset/problem/166/E

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_40DP_-1CPDP_2CFOLD__att_0002.png)

```python
void solve() {  
    iinp(n);
    //dp[i][j]
    //dp[n][0]
    //dp[0][0]=1
    //dp[0][any]=0
    //dp[1][0]=0
    //dp[1][1]=dp[1][2]=dp[1][3]=1
    //dp[i][0]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3]
    vvl dp(n+1,vl(4,0));
    dp[0][0]=dp[1][1]=dp[1][2]=dp[1][3]=1;
    for(ll i=1;i<=n;i++){
        dp[i][0]=moda(dp[i-1][1],moda(dp[i-1][2],dp[i-1][3]));
        dp[i][1]=moda(dp[i-1][0],moda(dp[i-1][2],dp[i-1][3]));        
        dp[i][2]=moda(dp[i-1][1],moda(dp[i-1][0],dp[i-1][3]));
        dp[i][3]=moda(dp[i-1][1],moda(dp[i-1][2],dp[i-1][0]));
    }
    pri(dp[n][0]);
}
```

```python
//space optimized
void solve() {  
    iinp(n);
    //dp[i][j]
    //dp[n][0]
    //dp[0][0]=1
    //dp[0][any]=0
    //dp[1][0]=0
    //dp[1][1]=dp[1][2]=dp[1][3]=1
    //dp[i][0]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3]
    int prev[4],curr[4];
    memset(prev,0,sizeof prev);
    prev[0]=1;
 
    for(int i=1;i<=n;i++){
        curr[0]=moda(prev[3],moda(prev[1],prev[2]));
        curr[1]=moda(prev[3],moda(prev[0],prev[2]));
        curr[2]=moda(prev[0],moda(prev[1],prev[3]));
        curr[3]=moda(prev[0],moda(prev[1],prev[2]));
        for(int i=0;i<4;i++){
            prev[i]=curr[i];
        }
    }
    pri(curr[0]);
}
```
{% endraw %}
