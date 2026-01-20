[Perfect Sum Problem | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1)

```cpp
int f(int v[], int idx, int k){
    if(k==0 and idx==-1) return 1;
    if(idx==-1 or k<0) return 0;
    moda(f(v,idx-1,k),f(v,idx-1,k-v[idx]));
}


int perfectSum(int v[], int n, int k){
    return f(v,n-1,k);
    
}
```

```cpp
int f(vector<vector<int>> &mem, int v[], int idx, int k){
    if(k==0 and idx==-1) return 1;
    if(idx==-1 or k<0) return 0;
    if(mem[idx][k]!=-1) return mem[idx][k];
    return mem[idx][k]=moda(f(mem,v,idx-1,k),f(mem,v,idx-1,k-v[idx]));
}


int perfectSum(int v[], int n, int k){
    vector<vector<int>> mem(n,vector<int>(k+1,-1));
    return f(mem,v,n-1,k);
}
```

```cpp
int perfectSum(int v[], int n, int k){
    vector<vector<int>> dp(n+1,vector<int>(k+1,0));
    //dp[0][any thing]=0
    dp[0][0]=1;
    for(int i=1;i<=n;i++){
        for(int j=0;j<=k;j++){
            dp[i][j]=dp[i-1][j];
            if(j-v[i-1]>=0) dp[i][j]=moda(dp[i][j],dp[i-1][j-v[i-1]]);
        }        
    }
    return dp[n][k];

```

# SCC
```cpp
dp[i][j]=dp[i-1][j]+ dp[i-1][j-v[i-1]];
```



```cpp
int perfectSum(int v[], int n, int k){
    vector<int> prev(k+1),curr(k+1);
    prev[0]=1;
    for(int i=1;i<=n;i++){
        for(int j=0;j<=k;j++){
            curr[j]=prev[j];
            if(j-v[i-1]>=0) curr[j]=moda(curr[j],prev[j-v[i-1]]);
        }        
        for(int j=0;j<=k;j++) prev[j]=curr[j];
    }
    return curr[k];
}
```

