1. trilogy question from leetcode or somewhere

Given an integer array `nums`, find the subarray
with the largest sum, and return *its sum*.

[Maximum Subarray - LeetCode](https://leetcode.com/problems/maximum-subarray/description/)


```cpp
int maxSubArray(vector<int>& v) {
    int n=v.size(),curr_sum=0,ans=INT_MIN;
    for(int x: v){
        curr_sum+=x;
        if(curr_sum>ans){
            ans=curr_sum;
        }
        if(curr_sum<0){
            curr_sum=0;
        }
    }
    return ans;
}
```
