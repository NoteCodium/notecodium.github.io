---
title: raid
---

{% raw %}
```python
look for raid formulae
```

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0001.png)

Doubt, what is data stripping?

raid 0  
we do data stripping 
parallel reads will be possible, so performance will be better

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0002.png)

Raid 1  
mirroring

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0003.png)

Raid 1+ 0 / nested raid

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0004.png)

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0005.png)

Raid 3:    
Parity, helps use to recover if one of the disk fails

bottleneck because all reads and writes have to go through one parity

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0006.png)

Raid 4:  
No difference from raid 3: 

(raid 0)==> divinding data
raid 1=== mirror 
raid 1+0===
raid 2===extict, at byte level
raid 3==== parity
raid 4== same as raid 2 (hence raid 2 and 4 are both useless)

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0007.png)

Raid 5:  
Distribute the parities

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0008.png)

Raid 6:  
two separate parities are calculated  
we can recover even if 2 disks fail  (try to feel it)

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_DB_Mis_raid__att_0009.png)
{% endraw %}
