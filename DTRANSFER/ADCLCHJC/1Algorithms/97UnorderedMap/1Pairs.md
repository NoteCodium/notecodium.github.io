---
title: 1Pairs
---

{% raw %}
q. Two elements having sum k, return their indices

```python
//Without sorting, as sorting will destroy the indices
```

q. count pairs with given sum k

```python
//possible without sorting and two pointers also
//total (not ditinct)
for(int x: v){
    ans+=m[k-x];
    m[x]++;
}

//with xor k
for(int x: v){
    ans+=m[k^x];
    m[x]++;
}
```
{% endraw %}
