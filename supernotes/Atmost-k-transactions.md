[188. Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)

```cpp
    int h(vector<int>& v, int idx, int canBuy, int n, int cap){
        if(idx>=n or cap<=0) return 0;
        if(canBuy){
            return max(-v[idx]+h(v,idx+1,0,n,cap),h(v,idx+1,1,n,cap));
        }
        else{
            return max(v[idx]+h(v,idx+1,1,n,cap-1),h(v,idx+1,0,n,cap));
        }
    }


    int maxProfit(int k, vector<int>& prices) {
        int n=prices.size();
        return h(prices,0,1,n,k);
    }
```


```cpp
int maxProfit(int k, vector<int>& v) {
    int n=v.size();
    int dp[1001][2][101];
    memset(dp,0,sizeof dp);
    for(int i=n-1;i>=0;i--){
        for(int cap=1;cap<=k;cap++){
            dp[i][1][cap]=max(-v[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
            dp[i][0][cap]=max(v[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);
        }
    }
    return dp[0][1][k];
}
```


# Space optimization
```cpp
int maxProfit(int k, vector<int>& v) {
    int n=v.size();
    vector<vector<int>> prev(2,vector<int>(k+1,0)),curr(2,vector<int>(k+1)); 
    for(int i=n-1;i>=0;i--){
        for(int cap=1;cap<=k;cap++){
            curr[1][cap]=max(-v[i]+prev[0][cap],prev[1][cap]);
            curr[0][cap]=max(v[i]+prev[1][cap-1],prev[0][cap]);

            prev[0][cap]=curr[0][cap];
            prev[1][cap]=curr[1][cap];
        }
    }
    return curr[1][k];
}
```

[DP 38. Buy and Stock Sell IV | Recursion to Space Optimisation - YouTube](https://youtu.be/IV1dHbk5CDc?si=WooTedSVgYCg7gTg)

