[Maximum Length of Pair Chain - LeetCode](https://leetcode.com/problems/maximum-length-of-pair-chain/description/?envType=study-plan-v2&envId=dynamic-programming)

```cpp
int f(vector<vector<int>>& events, int idx, int n, vector<int> &dp){
    if(idx>=n) return 0;
    if(dp[idx]!=-1) return dp[idx];
    vector<int> tmp={events[idx][1],INT_MAX};
    int i=upper_bound(events.begin(),events.end(),tmp)-events.begin();
    return dp[idx]=max(f(events,idx+1,n,dp),1+f(events,i,n,dp));
}


int maxValue(vector<vector<int>>& events) {
    sort(events.begin(),events.end());
    int n=events.size();
    vector<int> dp(n,-1);
    return f(events, 0,n,dp);
}


int findLongestChain(vector<vector<int>>& pairs) {
    return maxValue(pairs);
    // l1 < r1 < l2 < r2
    int f(vector<vector<int>>& events, int idx, int n, vector<int> &dp){
    if(idx>=n) return 0;
    if(dp[idx]!=-1) return dp[idx];
    vector<int> tmp={events[idx][1],INT_MAX};
    int i=upper_bound(events.begin(),events.end(),tmp)-events.begin();
    return dp[idx]=max(f(events,idx+1,n,dp),1+f(events,i,n,dp));
}


int maxValue(vector<vector<int>>& events) {
    sort(events.begin(),events.end());
    int n=events.size();
    vector<int> dp(n,-1);
    return f(events, 0,n,dp);
}


int findLongestChain(vector<vector<int>>& pairs) {
    return maxValue(pairs);
    // l1 < r1 < l2 < r2
    //given many intervals find the most number non intersecting intervals
    //given many jobs, find the maximum no. of jobs you can do
}
```
