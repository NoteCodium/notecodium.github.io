```cpp
int minCostII(vector<vector<int>>& ma) {
    int n=ma.size();        
    int colors=ma[0].size();
    vector<vector<int>> dp(n+1,vector<int>(colors,0));
    for(int i=1;i<=n;i++){
        for(int j=0;j<colors;j++){
            dp[i][j]=INT_MAX;
            for(int k=0;k<colors;k++){
                if(k!=j) dp[i][j]=min(dp[i][j],dp[i-1][k]);
            }
            dp[i][j]+=ma[i-1][j];
        }
    }
    return *min_element(dp[n].begin(),dp[n].end());
}
```
Maintaing two minimum of the last column
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1f770ca2-2a98-4047-96cd-2e089692145f--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ad9b0b5d-bea9-44cc-ad6f-0a3c44fee599--image.png)

# nk

# Memory optimization
