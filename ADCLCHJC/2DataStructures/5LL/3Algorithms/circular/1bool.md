1. Detect a loop in a linked list.


```python
class Solution {
public:
    bool hasCycle(ListNode *head) {
    ListNode* s=head;
    ListNode* f=head;

    while(f and f->next){
        s=s->next;
        f=f->next->next;
        if(f==s) return 1;
        //in linear they will never meet
    }  
    return 0;
    }
};

```

```python
Not optimal solutions
```

```python
bool hasCycle(ListNode *head) { 
    unordered_map<long long, bool> ma; 
    ListNode* curr=head;  
    while(curr){ 
        if(ma.count((long long)curr)) return 1; 
        ma[(long long)curr]; 
        curr=curr->next; 
    } 
    return 0; 
}
```



