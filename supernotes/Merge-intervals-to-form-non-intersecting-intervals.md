[Merge Intervals - LeetCode](https://leetcode.com/problems/merge-intervals/description/)


``` cpp
vector<vector<int>> mergeH(vector<vector<int>>& intervals) {
    if(intervals.size()==0) return {};
    vector<vector<int>> merged;
    for(auto interval:intervals){
        if(merged.empty() or merged.back()[1]<interval[0]) merged.push_back(interval);
        else merged.back()[1]=max(merged.back()[1],interval[1]);
    }
    return merged;
}

vector<vector<int>> merge(vector<vector<int>>& intervals) {
    sort(intervals.begin(),intervals.end());
    return mergeH(intervals);
}
```
