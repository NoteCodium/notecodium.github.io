```python
Node* p1=head;
Node* p2=head;
while(n--) p2=p2->next;
//maintaining a distance of n between the pointers
if(!p2){
	//nth node from the end is the head
	Node* tmp=head->next;
	delete(head);
	return tmp;
}
else{
	//now the distance between them is maintained to be n
	while(p2->next){
		p1=p1->next;
		p2=p2->next;
	}
	//p1 will point to the parent of nth node from the end
	Node* tmp=p1->next;
	p1->next=p1->next->next;
	delete(tmp);
}
```
