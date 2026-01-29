---
title: 391PathSums
---

{% raw %}
q. Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1)

https://leetcode.com/problems/minimum-falling-path-sum/description/

```python
int f(vector<vector<int>>& ma, int r, int c, int n){
    if(c>=n or c<0) return INT_MAX;
    if(r==0) return ma[r][c];
    return ma[r][c]+min({
            f(ma,r-1,c,n),
            f(ma,r-1,c+1,n),
            f(ma,r-1,c-1,n)
        });
}

int minFallingPathSum(vector<vector<int>>& ma) {
    int n=ma.size();
    int ans=INT_MAX;
    for(int i=0;i<n;i++){
        ans=min(ans,f(ma,n-1,i,n));
    }
    return ans;        
}
```

dp[r][c]=ma[r][c]+min({dp[r-1][c-1],dp[r-1][c],dp[r-1][c+1]});

```python

class Solution {
    public:
        int minFallingPathSum(vector<vector<int>>& ma) {
            int rr=ma.size();
            int cc=rr;
            for(int i=1;i<rr;i++){
                for(int j=0;j<cc;j++){
                    int minn=ma[i-1][j];
                    if(j-1>=0) minn=min(minn,ma[i-1][j-1]);
                    if(j+1<cc) minn=min(minn,ma[i-1][j+1]);
                    ma[i][j]+=minn;
                }
            }
            return *min_element(ma[rr-1].begin(),ma[rr-1].end());        
        } 
    };
```

q. Given a triangle array, return the minimum path sum from top to bottom.
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

```python
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

```python
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
{% endraw %}
