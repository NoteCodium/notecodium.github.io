[Triangle - LeetCode](https://leetcode.com/problems/triangle/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1594be69-fffc-4cd0-9de3-08f81e27b8a3--image.png)

```cpp
int f(vector<vector<int>>& ma, int r, int c, int rr){
    if(c>=ma[r].size()) return INT_MAX;
    if(r==rr-1) return ma[r][c];
    return ma[r][c]+ min(f(ma,r+1,c,rr),f(ma,r+1,c+1,rr));
}

int minimumTotal(vector<vector<int>>& ma){
    int rr=ma.size();
    return f(ma,0,0,rr);
}
```


```cpp
class Solution {
public:
    int minimumTotal(vector<vector<int>>& ma){

        //dp[i][j]=ma[i][j]+max(dp[i-1][j-1],dp[i-1][j])
        //min of dp[rr-1][c] for last row
        //dp[0][0]=ma[0][0]

        int n=ma.size();
        vector<vector<int>> dp(n,vector<int>(n,INT_MAX));
        dp[0][0]=ma[0][0];
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=dp[i-1][j];
                if(j-1>=0) dp[i][j]=min(dp[i][j],dp[i-1][j-1]);
                dp[i][j]+=ma[i][j];
            }
        }
        int ans=INT_MAX;
        for(int i=0;i<n;i++) ans=min(ans,dp[n-1][i]);
        return ans;
    }
};
```
