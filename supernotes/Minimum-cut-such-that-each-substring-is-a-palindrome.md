  [leetcode.com](https://leetcode.com/problems/palindrome-partitioning-ii/description/)

```
state
dp[i]= no of cuts to make the all the cuts from i to n-1 pallindrome
dp[n-1]=0
dp[0]=== problem
dp[i]= if pal[i][n-1]==1 is 0
        else   
```

```cpp

int minCut(string s) {
    int n=s.size();

    vector<vector<int>> pal(n,vector<int> (n,1));
    //pal[x][x]=1

    for(int i=1;i<n;i++){
        int r=0,c=i;
        while(c<n){
            pal[r][c]= s[r]==s[c] and pal[r+1][c-1];
            r++;
            c++;
        }
    }



    vector<int> dp(n);
    for(int idx=n-2;idx>=0;idx--){
        if(pal[idx][n-1]){
            dp[idx]=0;
            continue;
        } 
        int ans=INT_MAX;
        for(int i=idx;i<n;i++){
            if(pal[idx][i]) ans=min(ans,1+dp[i+1]);
        }
        dp[idx]=ans; 
    }
    return dp[0];   
}
```





```cpp

int f(int idx,  string &s,   vector<vector<int>> &pal, int n, vector<int> &mem){
    if(idx>=n-1 or pal[idx][n-1]) return 0;
    if(mem[idx]!=-1) return mem[idx];
    int ans=INT_MAX;
    for(int i=idx;i<n;i++){
        if(pal[idx][i]) ans=min(ans,1+f(i+1,s,pal,n,mem));
    }
    return mem[idx]=ans;
}

int minCut(string s) {
    int n=s.size();

    vector<vector<int>> pal(n,vector<int> (n,1));

    for(int i=1;i<n;i++){
        int r=0,c=i;
        while(c<n){
            pal[r][c]= s[r]==s[c] and pal[r+1][c-1];
            r++;
            c++;
        }
    }
    vector<int> mem(n,-1);
    return f(0,s,pal,n,mem);    
}
```

  `
  