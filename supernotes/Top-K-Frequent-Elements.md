[Top K Frequent Elements - LeetCode](https://leetcode.com/problems/top-k-frequent-elements/description/)

```cpp
vector<int> topKFrequent(vector<int>& v, int k) {
    unordered_map<int,int> m;
    for(int x:v) m[x]++;
    vector<pair<int,int>> vop;
    for(auto p:m) vop.push_back({p.second,p.first});
    priority_queue< pair<int,int> > pq(vop.begin(),vop.end());
    vector<int> ans;
    while(k--){
        ans.push_back(pq.top().second);pq.pop();
    }
    return ans;

}
```