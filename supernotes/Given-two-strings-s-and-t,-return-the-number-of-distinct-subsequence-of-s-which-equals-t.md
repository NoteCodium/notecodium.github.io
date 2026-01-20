Why recursion and not something else
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/439a36d2-1608-4fa6-b7d5-f245583d0a13--image.png)



There is not a one match, there can be many

```cpp
int f(int i, int j, string &s, string &t){
    if(j<0) return 1;
    if(i<0) return 0;
    if(s[i]==t[j]){
        return f(i-1,j-1,s,t)+f(i-1,j,s,t);
    }
    return f(i-1,j,s,t);
}


int numDistinct(string s, string t) {
    //no. of distinct subsequence of s which is same as t
    int ns=s.size(),nt=t.size();
    return f(ns-1,nt-1,s,t);
}
```

```
//dp[i][j]=
//if(s[i-1]!=p[j-1]) dp[i][j]=dp[i-1][j]
//else dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
//dp[0][any]=0
//dp[any][0]=1
//dp[0][0]=1
```


[leetcode.com](https://leetcode.com/problems/distinct-subsequences/description/)
```cpp
class Solution {
public:
    int numDistinct(string s, string p) {
            int ss=s.size(),ps=p.size();
            vector<vector<int>> dp(ss+1,vector<int> (ps+1,0));
            for(int i=1;i<=ss;i++) dp[i][0]=1;
            dp[0][0]=1
            for(int i=1;i<=ss;i++)
                for(int j=1;j<=ps;j++)
                    dp[i][j]= s[i-1]!=p[j-1]?dp[i-1][j]:dp[i-1][j-1]+dp[i-1][j];
            return dp[ss][ps];
        }
};
```

# Ac leetcode exception
```cpp
#define mod 10000000000
#define moda(a,b) ((a%mod)+(b%mod))%mod

class Solution {
public:
    int numDistinct(string s, string p) {
            int ss=s.size(),ps=p.size();
            vector<vector<int>> dp(ss+1,vector<int> (ps+1,0));
            for(int i=1;i<=ss;i++) dp[i][0]=1;
            dp[0][0]=1;
            for(int i=1;i<=ss;i++)
                for(int j=1;j<=ps;j++)
                    dp[i][j]= s[i-1]!=p[j-1]?dp[i-1][j]:moda(dp[i-1][j-1],dp[i-1][j]);
            return dp[ss][ps];
        }
};
```


# Space optimized
```cpp
#define mod 10000000000
#define moda(a,b) ((a%mod)+(b%mod))%mod

class Solution {
public:
int numDistinct(string s, string p) {
        int ss=s.size(),ps=p.size();
        vector<int> prev(ps+1,0),curr(ps+1);
        prev[0]=1;
        curr[0]=1;
        for(int i=1;i<=ss;i++){
            for(int j=1;j<=ps;j++){
                curr[j]= s[i-1]!=p[j-1]?prev[j]:moda(prev[j-1],prev[j]);
            }
            prev=curr;
        }
        return curr[ps];
    }
};
```



