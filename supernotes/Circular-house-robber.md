[House Robber II - LeetCode](https://leetcode.com/problems/house-robber-ii/description/)

```cpp
int robHelp(vector<int>& v) { 
    int n=v.size(); 
    vector<int> dp(n+1); 
    dp[0]=0; 
    dp[1]=v[0];
    for(int i=2;i<=n;i++) dp[i]=max(dp[i-1],v[i-1]+dp[i-2]);
    return dp[n];
} 
int rob(vector<int>& v){
    int n=v.size();
    if(n==1) return v[0];
    int buff=v[0];
    v[0]=0;
    int max1=robHelp(v);
    v[0]=buff;
    v[n-1]=0;
    int max2=robHelp(v);
    return max(max1,max2);   
}
```

