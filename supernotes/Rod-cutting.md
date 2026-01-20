1. Knapsack but you can take an element more then once, the wt of the things will be fixed


```cpp
int knapRepeat(vector<int> &pri, vector<int> &wei, int k)  { 
int n=pri.size(); 
vector<vector<int>> dp(n+1,vector<int> (k+1,0)); 
for(int r=1;r<=n;r++){ 
    for(int c=1;c<=k;c++){ 
        dp[r][c]=dp[r-1][c]; 
        if(c-wei[r-1]>=0) dp[r][c]=max(dp[r][c],pri[r-1]+dp[r][c-wei[r-1]]); 
    } 
} 
return dp[n][k];          
}


int cutRod(int price[], int k) {
    vector<int> wei,pri(price,price+k);
    for(int i=1;i<=k;i++) wei.push_back(i);
    return knapRepeat(pri,wei,k);    
}
```

# Independent
```cpp
  int f(int idx, int k,int val[]){
    if(k==0) return 0;
    if(idx<0 or k<0) return INT_MIN;
    return max(f(idx-1,k,val),f(idx,k-(idx+1),val)+val[idx]);
}

int cutRod(int price[], int n) { 
   return f(n-1,n,price);
}
```


```
dp[standing on the nth element ][make_sum==n]

dp[i][j]= max(dp[i-1][j] , dp[i][c-r] + price[r-1])
```

```cpp
int cutRod(int pri[], int n) {
    vector<vector<int>> dp(n+1,vector<int> (n+1,0)); 
    for(int r=1;r<=n;r++){ 
        for(int c=1;c<=n;c++){ 
            dp[r][c]=dp[r-1][c]; 
            if(c-r>=0) dp[r][c]=max(dp[r][c],pri[r-1]+dp[r][c-r]); 
        } 
    } 
    return dp[n][n];   
}
```

```cpp
int cutRod(int pri[], int n) {
    vector<int> ans(n+1,0);
    for(int r=1;r<=n;r++){ 
        for(int c=1;c<=n;c++){ 
            if(c-r>=0) ans[c]=max(ans[c],pri[r-1]+ans[c-r]); 
        } 
    } 
    return ans[n];   
}
```
