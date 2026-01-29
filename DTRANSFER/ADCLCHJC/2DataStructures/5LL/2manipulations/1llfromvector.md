---
title: 1llfromvector
---

{% raw %}
```python
Node* head=nullptr;
Node* tail=nullptr;
for(int x: v){
	Node* n=new Node(x);
	if(!head){
		head=n;
		tail=n;
		//head and tail start pointing to the same node which is at present pointed by n	
	}
	else{
		tail->next=n; //tail is pointing to the last node, now the last node will point to the new node
		tail=n;       //tail point to the same node which is pointed bu n			
	}
}
```
{% endraw %}
