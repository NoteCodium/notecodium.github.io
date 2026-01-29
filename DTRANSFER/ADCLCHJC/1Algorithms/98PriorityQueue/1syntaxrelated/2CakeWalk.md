---
title: 2CakeWalk
---

{% raw %}
```python
priority_queue<int> pq(v.begin(),v.end());
while(pq.size()!=1 and pq.size()!=0){
    int max1=pq.top();
    pq.pop();
    int max2=pq.top();
    pq.pop();
    if(max1==max2) continue;
    pq.push(max1-max2);
}
if(pq.empty()) return 0;
return pq.top();
```

```python
class Solution {
    public:
        vector<int> topKFrequent(vector<int>& v, int k) {
            unordered_map<int,int> m;
            for(int x:v) m[x]++;
            vector<vector<int>> vv;
            for(auto p:m) vv.push_back({p.second,p.first});
            priority_queue< vector<int> > pq(vv.begin(),vv.end());
            vector<int> ans;
            while(k--){
                ans.push_back(pq.top()[1]);
                pq.pop();
            }
            return ans;
        }
    };
```
{% endraw %}
