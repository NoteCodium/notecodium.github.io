[leetcode.com](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description/?envType=study-plan-v2&envId=dynamic-programming-grandmaster)

[Maximum Number of Events That Can Be Attended II DP II Binary Search II 0/1Knapsack II Leetcode 1751 - YouTube](https://youtu.be/zrLGGXSeTa8?si=ny9Em_vCnhTJfjFL)



```cpp
class Solution {
public:

    int f(vector<vector<int>>& events, int idx, int n, vector<int> &dp){
        if(idx==n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        vector<int> tmp={events[idx][1],0,0};
        int i=lower_bound(events.begin(),events.end(),tmp)-events.begin();
        return dp[idx]=max(f(events,idx+1,n,dp),events[idx][2]+f(events,i,n,dp));
    }


    int maxValue(vector<vector<int>>& events) {
        sort(events.begin(),events.end());
        int n=events.size();
        vector<int> dp(n,-1);
        return f(events, 0,n,dp);
    }


    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        int n=startTime.size();
        vector<vector<int>> events;
        for(int i=0;i<n;i++) events.push_back({startTime[i],endTime[i],profit[i]});
        return maxValue(events);
    }
};
```
