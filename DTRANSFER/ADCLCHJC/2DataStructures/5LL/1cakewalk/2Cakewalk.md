---
title: 2Cakewalk
---

{% raw %}
# Traversing

https://practice.geeksforgeeks.org/problems/count-nodes-of-linked-list/1

```python
//finding len
if(!head) return 0;
Node* curr=head;
while(curr){
	curr=curr->next;
	len++;
}
```

```python
//search
if(!head) return 0;
Node* curr=head;
while(curr){
	if(curr->data==k) return 1;
	curr=curr->next;
}
return 0;
```
{% endraw %}
