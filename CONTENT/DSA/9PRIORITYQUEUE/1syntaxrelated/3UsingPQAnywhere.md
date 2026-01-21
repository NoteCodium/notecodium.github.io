https://leetcode.com/problems/find-k-closest-elements/description/   
Find K Closest Elements


![image.png](3UsingPQAnywhere_images/image.png)


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
