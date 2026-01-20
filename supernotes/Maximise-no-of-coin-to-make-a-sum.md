[Maximize The Cut Segments | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/cutted-segments1642/1)

```cpp
int maximizeTheCuts(int k, int x, int y, int z){
  vector<int> v(3);
  v[0]=x;
  v[1]=y;
  v[2]=z;
  vector<int> dp(k+1);
  dp[0]=0;
  for(int i=1;i<=k;i++){
      int maxx=INT_MIN;
      for(int j=0;j<v.size();j++){
          if(i-v[j]>=0) maxx=max(maxx,dp[i-v[j]]);
      }
      dp[i]=maxx;
      if(dp[i]!=INT_MIN) dp[i]++;   
  }
  return dp[k]!=INT_MIN?dp[k]:0;

}
```
