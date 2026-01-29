---
title: 2mpow
---

{% raw %}
i think algozenith

https://leetcode.com/problems/powx-n/description/

```python
class Solution {
public:
    double helper(double n, long p) {
        if(p==0) return 1;
        double x= helper(x,p/2);
        if(p%2==0) return x*x;
        return x*x*n;   
    }
    double myPow(double n, int pInput){
        long p=abs((long)pInput);
        double tmpAns=helper(n,p);
        return pInput>=0?tmpAns:1/tmpAns;
    }
};
```
{% endraw %}
