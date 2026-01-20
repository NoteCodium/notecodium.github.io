[Minimum Path Sum - LeetCode](https://leetcode.com/problems/minimum-path-sum/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/eae2794a-d471-4709-be38-ddc62dd20276--image.png)

```cpp
int f(int r,int c,vector<vector<int>> &ma){
    if(r==0 and c==0) return ma[0][0];
    if(r<0 or c<0) return INT_MAX;
    return ma[r][c]+min(f(r-1,c,ma),f(r,c-1,ma));
}
        
    
    

int minPathSum(vector<vector<int>>& ma) {
    int rr=ma.size(),cc=ma[0].size();
    return f(rr-1,cc-1,ma);
}  
```

```cpp
int minPathSum(vector<vector<int>>& ma) {
    //dp[i][j]
    //dp[i][j]=ma[i][j]+min(dp[i-1][j],dp[i][j-1]);
    //dp[0][0]=ma[0][0]
    //dp[m-1][n-1]
    int m=ma.size(),n=ma[0].size();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(i==0 and j==0) continue;
            int minn=INT_MAX;
            if(i-1>=0) minn=min(minn,ma[i-1][j]);
            if(j-1>=0) minn=min(minn,ma[i][j-1]);
            ma[i][j]+=minn;
        }
    }
    return ma[m-1][n-1];
}
```
