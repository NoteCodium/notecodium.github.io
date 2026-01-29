---
title: 1Basics
---

{% raw %}
The average work done is more in each step

```python
int f(n,k){
	if(k==0) return 1;
	int x=f(n,k/3);
	if(k%3==0) return x*x*x;
	if(k%3==1)return x*x*x*n;
    else return x*x*x*n*n;
}
```
{% endraw %}
