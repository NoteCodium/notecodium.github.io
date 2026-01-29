---
title: 2WaysToScale
---

{% raw %}
Query optimization: read about prepared statements

connection pool

cache non dynamic data  
 booking history  
 payment history  
 user profile

Database replication  
helps in disaster recovery  
related to clustering

Command
Query
Responsibility
Segregation
Cqrs

doubt

![image.png](/DTRANSFER/notebook_images/DTRANSFER_9GATETHEORY_DB_scalingDB_2WaysToScale__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_9GATETHEORY_DB_scalingDB_2WaysToScale__att_0002.png)


gaurav sen gyaan

![image.png](/DTRANSFER/notebook_images/DTRANSFER_9GATETHEORY_DB_scalingDB_2WaysToScale__att_0003.png)

Partitioning    
    availability  
    performance  
    parallelism  
    manageability  
    reduce cost (horizontal scaling cheaper then vertical scaling)

Sharding  

Whats the difference from partitioning?  

technique to do horizontal partitioning ?  
we also have to introduce a routing layer

bad when your data is spread over different db instances (analytical type of queries, scatter-gather problem)
{% endraw %}
