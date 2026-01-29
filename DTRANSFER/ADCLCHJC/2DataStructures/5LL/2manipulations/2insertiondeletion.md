---
title: 2insertiondeletion
---

{% raw %}
1. Lets suppose we have 1 based indexing
2. Insert at position 4==the inserted node will have a position of 4

//Reach the k-1 position
//After hoping for k-2 times

After hopping for k-2 times, curr→next will be the position where you have to insert the new node

//edge case while hoping for k-2 times
// k=1 :::====? you have to insert at head and have to change the head

k=2, we have to hope 0 times and insert at the head

```python
Node *n= new Node(val);
if(pos!=1){
	Node *curr= head;
	int cnt=pos-2;
	while(cnt--) curr=curr->next;
/////////////////////////////	
	Node* tmp= curr->next;
	curr->next=n;
	n->next=tmp;
///////////////////////////////
}
else{
	n->next=head;
	head=n;
}
```

# Deletion

```python
Node *tmp=nullptr;
if(pos==1){
	tmp=head;
	head=head->next; //update the head of the ll
}
else{
	Node *curr= head;
	int cnt=pos-2;
	while(cnt--) curr=curr->next;
	////////////////////////////
	tmp= curr->next;
	curr->next=curr->next->next;
	////////////////////////////
}
delete(tmp);
```

//curr->next will not be null
//becase it will null after n-1 hops
//delete n+1th node 
//which is not possible
{% endraw %}
