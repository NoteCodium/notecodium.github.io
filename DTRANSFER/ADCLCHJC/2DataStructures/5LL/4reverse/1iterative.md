---
title: 1iterative
---

{% raw %}
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_5LL_4reverse_1iterative__att_0001.png)

at some time, let this be the configuration

```python
tmp=curr->next;
curr->next=prev;
prev=curr;
curr=tmp;
```

```python
Node * curr=head;
Node* prev= nullptr;
while(curr){
	tmp=curr->next;
	curr->next=prev;
	prev=curr;
	curr=tmp;
}
return prev;
```
{% endraw %}
