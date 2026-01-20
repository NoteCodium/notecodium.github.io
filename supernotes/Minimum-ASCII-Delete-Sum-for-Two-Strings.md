[leetcode.com](https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/?envType=study-plan-v2&envId=dynamic-programming)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1a34e808-d0cb-476b-9553-4b00ce610a29--image.png)


```
  //dp[0][any]= sum of ascii of s2 
  //dp[any][0]=sum of ascii of s1
  //dp[0][0]=0
//dp[i][j]=s1[i-1]==s2[j-1]?dp[i-1][j-1]:min(s1[i-1]+dp[i-1][j],s2[j-1]+d[i][j-1])
```

```cpp
class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int n1=s1.size(),n2=s2.size();
        vector<vector<int>> dp(n1+1,vector<int>(n2+1));
        dp[0][0]=0;
        int sum=0;
        for(int i=0;i<n2;i++){
            sum+=s2[i];
            dp[0][i+1]=sum;
        }
        sum=0;
        for(int i=0;i<n1;i++){
            sum+=s1[i];
            dp[i+1][0]=sum;
        }     

        for(int i=1;i<=n1;i++)
            for(int j=1;j<=n2;j++)
                dp[i][j]=s1[i-1]==s2[j-1]?dp[i-1][j-1]:min(s1[i-1]+dp[i-1][j],s2[j-1]+dp[i][j-1]);
        return dp[n1][n2];

    }
};
```
