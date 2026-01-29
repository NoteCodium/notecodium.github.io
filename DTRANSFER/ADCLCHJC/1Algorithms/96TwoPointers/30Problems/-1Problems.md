---
title: -1Problems
---

{% raw %}
1. sorted array
2. return k
3.	closest integer to x   

658 leetcode

```python
//using pq (using extra space)    
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

```python
//in Conastant space (sort to yahi bhi ho raha hain)
vector<int> findClosestElements(vector<int>& v, int noOfClosestElem, int k) {
    int n=v.size();
    sort(v.begin(),v.end());
    int idx=lower_bound(v.begin(),v.end(),k)-v.begin();
    int l=idx-1,h=idx;
    int cnt=0;
    vector<int> ans;
    while(l>=0 and h<n and cnt!=noOfClosestElem){
        if(abs(v[l]-k)<=abs(v[h]-k)){
            ans.push_back(v[l]);
            l--;
        }
        else{
            ans.push_back(v[h]);
            h++;                
        }
        cnt++;
    }
    if(l>=0){
        while(cnt!=noOfClosestElem){
            ans.push_back(v[l]);
            l--; 
            cnt++;               
        }
    }
    else{
        while(cnt!=noOfClosestElem){
            ans.push_back(v[h]);
            h++; 
            cnt++;            
        }
    }

    sort(ans.begin(),ans.end()); 
    return ans;  
}
```
{% endraw %}
