---
title: 3UsingPQAnywhere
---

{% raw %}
https://leetcode.com/problems/find-k-closest-elements/description/   
Find K Closest Elements

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_98PriorityQueue_1syntaxrelated_3UsingPQAnywhere__att_0001.png)

```python
vector<int> findClosestElements(vector<int>& v, int noOfClosestElem, int k) {
    vector<int> ans;
    auto cmp=[&](int &a, int &b){
        return abs(a-k)==abs(b-k)?a>b:abs(a-k)>abs(b-k);  
    };
    priority_queue<int,vector<int>,decltype(cmp)> pq(cmp,v);
    while(noOfClosestElem--){
        ans.push_back(pq.top());
        pq.pop();
    }
    sort(ans.begin(),ans.end()); 
    return ans;  
}
```
{% endraw %}
