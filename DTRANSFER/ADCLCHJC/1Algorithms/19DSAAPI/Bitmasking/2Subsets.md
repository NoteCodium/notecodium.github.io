---
title: 2Subsets
---

{% raw %}
Given an integer array nums of unique elements, return all possible subsets (the power set).

https://leetcode.com/problems/subsets/description/

```python
vector<vector<int>> subsets(vector<int>& v) {
    vector<vector<int>> ans;
    int n=v.size(); 
    int subsetCnt=(1<<n);
    vector<vector<int>> subsets;
    for(int mask=0;mask<subsetCnt;mask++){
        vector<int> subset;
        for(int idx=0;idx<n;idx++){
            if(mask & (1<<idx)){
                subset.push_back(v[idx]);
            } 
        }
        subsets.push_back(tmp);
    }
    return ans;
}
```
{% endraw %}
