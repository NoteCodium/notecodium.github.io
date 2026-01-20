[0 - 1 Knapsack Problem | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)


# A object can only be took once
```cpp
int f(int idx, int k, int wt[], int val[], vector<vector<int>> &mem){
    if(k<0) return INT_MIN;
    if(k==0 or idx<0) return 0;
    if(mem[idx][k]!=-1) return mem[idx][k];
    return mem[idx][k]=max(f(idx-1,k,wt,val,mem),f(idx-1,k-wt[idx],wt,val,mem)+val[idx]);
}

int knapSack(int k, int wt[], int val[], int n) { 
    vector<vector<int>> mem(n,vector<int> (k+1,-1));
    return f(n-1,k,wt,val,mem);
}
```

# Dp state

```
dp[idx][k]=max(dp[idx-1][k],max[idx-1][k-wt[idx-1]]+val[idx-1])
dp[n][k] is the problem
dp[0][k]=0
dp[n][0]=0
```
```cpp
int knapSack(int k, int wt[], int val[], int n) { 
    vector<vector<int>> dp(n+1,vector<int> (k+1,0));
    for(int idx=1;idx<=n;idx++)
        for(int j=1;j<=k;j++){
            dp[idx][j]=dp[idx-1][j];
            if(j-wt[idx-1]>=0) dp[idx][j]=max(dp[idx][j],dp[idx-1][j-wt[idx-1]]+val[idx-1]);
        }
    return dp[n][k];
}
```

# Space optimized
```cpp
int knapSack(int k, int wt[], int val[], int n) { 
    vector<int> prev(k+1,0),curr(k+1);
    for(int idx=1;idx<=n;idx++){
        for(int j=1;j<=k;j++){
            curr[j]=prev[j];
            if(j-wt[idx-1]>=0) curr[j]=max(curr[j],prev[j-wt[idx-1]]+val[idx-1]);
        }
        prev=curr;
    }
    return curr[k];
}
```
