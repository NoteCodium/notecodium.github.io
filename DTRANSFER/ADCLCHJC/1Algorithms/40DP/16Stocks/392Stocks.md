---
title: 392Stocks
---

{% raw %}
q. You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.  
(https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/)

```python
int h(vector<int>& v, int idx, int canBuy, int n){
    if(idx==n) return 0;
    if(canBuy){
        return max(-v[idx]+h(v,idx+1,0,n),h(v,idx+1,1,n));
    }
    else{
        return max(v[idx]+h(v,idx+1,1,n),h(v,idx+1,0,n));
    }
}


int maxProfit(vector<int>& prices) {
    int n=prices.size();
    return h(prices,0,1,n);
}
```

```python
dp[i][0] not holding stock
dp[i][1] holding stock

dp[0][0]=0
dp[0][1]=-v[0]

dp[i][0] = max(v[i]+dp[i-1][1],dp[i-1][0])
dp[i][1] = max(-v[i-1]+dp[i-1][0],dp[i-1][1])
```

```python
int maxProfit(vector<int>& v) {
    int n=v.size();
    vector<vector<int>> dp(n,vector<int>(2));

    dp[0][0]=0;
    dp[0][1]=-v[0];

    for(int i=1;i<n;i++){
        dp[i][0] = max(v[i]+dp[i-1][1],dp[i-1][0]);
        dp[i][1] = max(-v[i]+dp[i-1][0],dp[i-1][1]);
    }
    return dp[n-1][0];
}
```

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).  
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

```python
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

```python

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

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

```python
int h(vector<int>& v, int idx, int canBuy, int n, int fee){
    if(idx>=n) return 0;
    if(canBuy){
        return max(-v[idx]+h(v,idx+1,0,n,fee),h(v,idx+1,1,n,fee));
    }
    else{
        return max(-fee+v[idx]+h(v,idx+1,1,n,fee),h(v,idx+1,0,n,fee));
    }
}


int maxProfit(vector<int>& prices, int fee) {
    int n=prices.size();
    return h(prices,0,1,n,fee);
}
```

```python
class Solution {
    public:
        int maxProfit(vector<int>& v, int fee) {
            int n=v.size();
            vector<vector<int>> dp(n+1, vector<int>(2,0));
            for(int i=n-1;i>=0;i--){
                dp[i][1]=max(-v[i]+dp[i+1][0],dp[i+1][1]);
                dp[i][0]=max(-fee+v[i]+dp[i+1][1],dp[i+1][0]);
            }
            return dp[0][1];
        }
    };
```

q. You may complete at most two transactions.  

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).  
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/)

```python
int h(vector<int>& v, int idx, int canBuy, int n, int cap){
    if(idx>=n or cap<=0) return 0;
    if(canBuy){
        return max(-v[idx]+h(v,idx+1,0,n,cap),h(v,idx+1,1,n,cap));
    }
    else{
        return max(v[idx]+h(v,idx+1,1,n,cap-1),h(v,idx+1,0,n,cap));
    }
}


int maxProfit(vector<int>& prices) {
    int n=prices.size();
    return h(prices,0,1,n,2);
}
```

```python
class Solution {
    public:
        int h(vector<int>& v, int idx, int canBuy, int n, int cap, int mem[100001][2][3]){
            if(idx>=n or cap<=0) return 0;
            if(mem[idx][canBuy][cap]!=-1) return mem[idx][canBuy][cap];
            int ans;
            if(canBuy){
                ans=max(-v[idx]+h(v,idx+1,0,n,cap,mem),h(v,idx+1,1,n,cap,mem));
            }
            else{
                ans=max(v[idx]+h(v,idx+1,1,n,cap-1,mem),h(v,idx+1,0,n,cap,mem));
            }
            return ans=mem[idx][canBuy][cap];
        }
    
    
        int maxProfit(vector<int>& prices) {
            int n=prices.size();
            int mem[100001][2][3];
            // The fastest way to initialize all elements of mem[100001][2][3] to -1 is by using memset, 
            // which efficiently sets all bytes to -1 in constant time.
            memset(mem, -1, sizeof(mem));
            return h(prices,0,1,n,2,mem);
        }
    };
```

```python
class Solution {
    public:
        int h(vector<int>& v, int idx, int canBuy, int n, int cap, int mem[100001][2][3]){
            if(idx>=n or cap<=0) return 0;
            if(mem[idx][canBuy][cap]!=-1) return mem[idx][canBuy][cap];
            int ans;
            if(canBuy){
                ans=max(-v[idx]+h(v,idx+1,0,n,cap,mem),h(v,idx+1,1,n,cap,mem));
            }
            else{
                ans=max(v[idx]+h(v,idx+1,1,n,cap-1,mem),h(v,idx+1,0,n,cap,mem));
            }
            return ans=mem[idx][canBuy][cap];
        }
    
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        // dp[day][canBuy][cap] where:
        // canBuy = 1 if we can buy, 0 if we can sell
        // cap = number of transactions remaining (max 2)
        int dp[100001][2][3];
        memset(dp,0,sizeof dp);

        //if cap is 0, their answers will be autoatically 0

        for (int idx = n - 1; idx >= 0; idx--) {//reverse of recursive
            for (int canBuy = 0; canBuy <= 1; canBuy++) {//reverse of recursive
                for (int cap = 1; cap <= 2; cap++) {//reverse of recursive
                    if (canBuy) {
                        dp[idx][canBuy][cap] = max(
                            -prices[idx] + dp[idx + 1][0][cap],  // Buy
                            dp[idx + 1][1][cap]                  // Skip
                        );
                    } else {
                        dp[idx][canBuy][cap] = max(
                            prices[idx] + dp[idx + 1][1][cap - 1], // Sell
                            dp[idx + 1][0][cap]                   // Skip
                        );
                    }
                }
            }
        }

        return max({dp[0][1][2]}); // Start at day 0, canBuy = 1, cap = 2
    }

};
```

# Another method without using the cap and can buy, only using tranNum

```python
class Solution {
    public:
        int h(vector<int>& v, int idx, int tranNum, int n, int cap){
            if(idx>=n or tranNum>=2*cap) return 0;
            //buy in even
            if(tranNum%2==0){
                return max(-v[idx]+h(v,idx+1,tranNum+1,n,cap),h(v,idx+1,tranNum,n,cap));
            }
            else{
                return max(v[idx]+h(v,idx+1,tranNum+1,n,cap),h(v,idx+1,tranNum,n,cap));
            }
        }


        int maxProfit(vector<int>& prices) {
            int n=prices.size();
            return h(prices,0,0,n,2);
        }
};
```

```python
class Solution {
    public:
        int maxProfit(vector<int>& prices) {
            int n=prices.size();
            // return h(prices,0,0,n,2);
            //int cap=2;
            vector<vector<int>> dp(n+1,vector<int>(5,0));
            for(int i=n-1;i>=0;i--){
                for(int j=3;j>=0;j--){
                    int ans;
                    if(j%2==0){
                        ans=max(-prices[i]+dp[i+1][j+1],dp[i+1][j]);
                    }
                    else{
                        ans=max(prices[i]+dp[i+1][j+1],dp[i+1][j]);
                    }
                    dp[i][j]=ans;
                }
            }
            return max({dp[0][4],dp[0][2],dp[0][0]});

        }
};
```

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/  
Atmost k transactions

```python
class Solution {
    public:
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
    };
```

```python
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

```python
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
{% endraw %}
