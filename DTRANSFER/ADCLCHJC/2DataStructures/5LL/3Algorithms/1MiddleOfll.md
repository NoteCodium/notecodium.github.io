---
title: 1MiddleOfll
---

{% raw %}
```python
//for even f becomes null
//for odd f->next becomes null
while(f and f->next){
	s=s->next;
	f=f->next->next;
}
```

1. s will point to the middle node
2. for even nodes, gives the right middle
{% endraw %}
