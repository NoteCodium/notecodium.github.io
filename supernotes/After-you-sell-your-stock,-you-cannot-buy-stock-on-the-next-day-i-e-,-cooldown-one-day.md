[Best Time to Buy and Sell Stock with Cooldown - LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/)

```cpp
int h(vector<int>& v, int idx, int canBuy, int n){
    if(idx>=n) return 0;
    if(canBuy){
        return max(-v[idx]+h(v,idx+1,0,n),h(v,idx+1,1,n));
    }
    else{
        return max(v[idx]+h(v,idx+2,1,n),h(v,idx+1,0,n));
    }
}


int maxProfit(vector<int>& prices) {
    int n=prices.size();
    return h(prices,0,1,n);
}
```

```cpp

int maxProfit(vector<int>& v) {
    int n=v.size();
    vector<vector<int>> dp(n+2,vector<int>(2,0));
    for(int i=n-1;i>=0;i--){
        dp[i][1]=max(-v[i]+dp[i+1][0],dp[i+1][1]);
        dp[i][0]=max(v[i]+dp[i+2][1],dp[i+1][0]);
    }
    return dp[0][1];
}

```

