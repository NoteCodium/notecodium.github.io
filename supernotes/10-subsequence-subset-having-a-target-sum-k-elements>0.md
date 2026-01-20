[Check if there exists a subsequence with sum K | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1?page=1&sortBy=newest&query=page1sortBynewest)

https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
```cpp
bool f(int idx, int k, vector<int>& v){
    if(k==0) return 1;
    if(idx<0 or k<0) return 0;
    return f(idx-1,k,v) or f(idx-1,k-v[idx],v);
}

bool checkSubsequenceSum(int n, vector<int>& v, int k) {
    return f(n-1,k,v);
}
```

```cpp
bool f(int idx, int k, vector<int>& v, vector<vector<int>> &mem){
    if(k==0) return 1;
    if(idx<0 or k<0) return 0;
    if(mem[idx][k]!=-1) return mem[idx][k];
    return mem[idx][k]=f(idx-1,k,v,mem) or f(idx-1,k-v[idx],v,mem);
}

bool checkSubsequenceSum(int n, vector<int>& v, int k) {
    vector<vector<int>> mem(n,vector<int> (k+1,-1));
    return f(n-1,k,v,mem);
}
```

```cpp
vector<vector<bool>> dp(n+1,vector<bool>(k+1));
//dp[elements from front][target sum]
//dp[any element][0]=1 is it alwaus possible to make 0 sum
//dp[i][j]= dp[i-1][j] or dp[i-1][j-v[i-1]]
for(int i=0;i<=n;i++) dp[i][0]=1;
//dp[0][any] =0
//dp[0][0]= 1
for(int i=1;i<=n;i++){
    for(int j=1;j<=k;j++){
            dp[i][j]=dp[i-1][j];
            if(j-v[i-1]>=0) dp[i][j]= dp[i][j] or dp[i-1][j-v[i-1]];
        }
}
return dp[n][k];
}

```



