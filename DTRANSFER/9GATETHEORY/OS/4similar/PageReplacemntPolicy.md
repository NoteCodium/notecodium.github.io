---
title: PageReplacemntPolicy
---

{% raw %}
# Why Optimal Page Replacemnt is not possible  
sometimes it depends on user inputs

page replacement algorithms because the pages used once can be used once again

# FIFO  
Not intelligent (very simple)  
## Belady anamoly ⇒    
increasing capacity actually increases page misses

# random replacement

perform better then fifo

not intelligent

# Based on history

# MFU  
If something used a lot it means its work is done (the code)

replacing the most commonly used page

1. cons: does not consider spatial or temporal locality

# LFU  
better then MFU 

1. based on spatial or temporal locality ??? DOUBTS

in these 2 we are not considering time 

# considering time

![image.png](/transfernew/notebook_images/transfernew_9GATETHEORY_OS_4similar_PageReplacemntPolicy__att_0001.png)

Implementing it 
Queue  
DLL

implementation heavy, for cache is fine because cache is small, for pages it becomes heavy
ram can have a lot of pages

# LRU approxiamation
{% endraw %}
