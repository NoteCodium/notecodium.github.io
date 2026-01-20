[Best Time to Buy and Sell Stock with Transaction Fee - LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

```cpp
int h(vector<int>& v, int idx, int canBuy, int n, int fee){
    if(idx==n) return 0;
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