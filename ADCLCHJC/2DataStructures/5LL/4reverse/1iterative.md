![image.png](1iterative_images/image.png)


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
