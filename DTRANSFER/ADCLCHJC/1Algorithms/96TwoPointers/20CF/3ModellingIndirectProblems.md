---
title: 3ModellingIndirectProblems
---

{% raw %}
Max no. of consecutive 1 that you can get in a binary array if you are allowed to flip at most k zeros

Basically we have to find  
Longest subarray having <=k zeros

```python
class Solution { 
    public: 
        int longestOnes(vector<int>& v, int k) { 
            int l=0,h=0,n=v.size(),count=0,ans=0; 
            while(h<n){ 
                if(!v[h]) count++; 
                while(count>k and l<h){ 
                    if(!v[l]) count--; 
                    l++; 
                } 
                if(count<=k and l<=h) ans=max(ans,h-l+1); 
                h++; 
            } 
            return ans; 
        } 
    };
```
{% endraw %}
