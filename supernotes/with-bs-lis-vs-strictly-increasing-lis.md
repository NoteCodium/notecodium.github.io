[leetcode.com](https://leetcode.com/problems/longest-increasing-subsequence/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0f90983d-a04c-4e0f-82a0-15718f2f3bca--image.png)

# strictly

```cpp
int lengthOfLIS(vector<int>& v) {
    int n=v.size();
    vector<int> tmp;
    tmp.push_back(v[0]);
    for(int i=1;i<n;i++){
        int x=v[i];
        if(x>tmp.back()) tmp.push_back(x);
        else{
            int idx=lower_bound(tmp.begin(), tmp.end(),x)-tmp.begin();
            tmp[idx]=x;
        }
    }
    return tmp.size();
}
```
# Non strictly
```cpp
int lengthOfLIS(vector<int>& v) {
    vector<int> tmp;
    tmp.push_back(v[0]);
    int n=v.size();
    for(int i=1;i<n;i++){
        if(v[i]>=tmp.back()) tmp.push_back(v[i]);
        else{
            int idx=upper_bound(tmp.begin(), tmp.end(),v[i])-tmp.begin();
            tmp[idx]=v[i];
        }
    }
    return tmp.size();
}
```

# You can also construct dp array
# Strictly 


```cpp

```
# Non strictly
[Find the Longest Valid Obstacle Course at Each Position - LeetCode](https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/?envType=study-plan-v2&envId=dynamic-programming)

```cpp
vector<int> longestObstacleCourseAtEachPosition(vector<int>& v) {
    int n=v.size();
    vector<int> tmp,dp(n);
    tmp.push_back(v[0]);
    dp[0]=1;
    for(int i=1;i<n;i++){
        int x=v[i];
        if(x>=tmp.back()){
            tmp.push_back(x);
            dp[i]=tmp.size();
        } 
        else{
            int idx=upper_bound(tmp.begin(), tmp.end(),x)-tmp.begin();
            tmp[idx]=x;
            dp[i]=idx+1;
        }
    }
    return dp;      
}
```



![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cfab9fbb-5e5b-4708-b759-b3db62ae93fb--image.png)
1. still the lis is 5 8
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b22b223d-08f3-4af0-9f6d-3e198d5508c4--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/95041cca-4c86-4ffa-84ad-85bbb2ef14d7--image.png)

