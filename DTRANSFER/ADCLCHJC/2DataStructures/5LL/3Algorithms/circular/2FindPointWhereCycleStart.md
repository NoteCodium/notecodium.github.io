---
title: 2FindPointWhereCycleStart
---

{% raw %}
https://leetcode.com/problems/linked-list-cycle-ii/description/

```python
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* s=head;
        ListNode* f=head;
        bool isCycle=0;

        while(f and f->next){
            s=s->next;
            f=f->next->next;
            if(f==s){
                isCycle=1;
                break;
            }
        }

        if(!isCycle) return NULL;
        ListNode* startNode=head;
        ListNode* intersectionNode=s;

        while(startNode!=intersectionNode){
            startNode=startNode->next;
            intersectionNode=intersectionNode->next;
        }
        return startNode;
    }
};
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_5LL_3Algorithms_circular_2FindPointWhereCycleStart__att_0001.png)

```python
jab tak startingNode waha l1 travel karega, exactlly intersectingNode bhi wahi tak 
ayega
```

# Not optimal

```python
hashing
the first time the memory address repeat
```
{% endraw %}
