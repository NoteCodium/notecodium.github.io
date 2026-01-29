---
title: 3Theorems
---

{% raw %}
CAP Theorem:  
Designing efficient distributed storage

Consistency  
Availability  
Partition tolerance

Availability even when some nodes fail

Partition tolerance  
    System should not fail if partition happens bw two db  

Partion happened
Then either
Availabale
Or 
Consistent

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Theorem_3Theorems__att_0001.png)

CA database after partition happened  
    Only possible for single node

CP
Consitency
Partition tolerance  

When a partition happen, the system has to turn off all the inconsistent nodes untill the partition is fixed 

ex  
MongoDB
Banking

Doubt  
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Theorem_3Theorems__att_0002.png)

AP
Don’t turn off the nodes which are disconnected due to partition  

Apache cassandra, Amazon DynamoDB  
Facebook, higly available: need not be consistent

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Theorem_3Theorems__att_0003.png)

?????????????????????????????????
Synchronous update make availability go down

Asynchronously make consistency
////////////////////////////////

Weak consistency  
    updates in 1 replica need not to be communicated to others


Eventual consistency/Async updates  
    Email

Strong consistency
    Synchrounous updates

doubt  
![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Theorem_3Theorems__att_0004.png)
{% endraw %}
