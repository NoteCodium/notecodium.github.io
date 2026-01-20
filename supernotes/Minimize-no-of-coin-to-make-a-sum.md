[Coin Change - LeetCode](https://leetcode.com/problems/coin-change/description/)


```cpp
int f(int k, vector<int>& v){
    if(k==0) return 0;
    if(k<0) return INT_MAX;
    int minn=INT_MAX;
    for(int i=0;i<v.size();i++) minn=min(minn,f(k-v[i],v));
    if(minn==INT_MAX) return INT_MAX;
    return 1+minn;
}

    
int coinChange(vector<int>& v, int k) {
    if(f(k,v)==INT_MAX) return -1;
    return f(k,v);     
}
```
```cpp
  int coinChange(vector<int>& v, int k){
      //dp[k]
      //dp[i]= 1 + minn(dp[i-various elements of v])
      //dp[0]=1
      vector<int> dp(k+1);
      dp[0]=0;
      for(int i=1;i<=k;i++){
          int minn=INT_MAX;
          for(int j=0;j<v.size();j++){
              if(i-v[j]>=0) minn=min(minn,dp[i-v[j]]);
          }
          dp[i]=minn;
          if(dp[i]!=INT_MAX) dp[i]++;   
      }
      return dp[k]!=INT_MAX?dp[k]:-1;
  }
```
