---
title: 5InequalityDiffferece
---

{% raw %}
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_5InequalityDiffferece__att_0001.png)

```python
int l=0,h=1;
int ans=0;
while(h<n){
    if(v[h]-v[l]<k){
        ans+=(h-l);// all elements excluding v[l] alone
        h++;
    }
    else{
        l++;
    }
}
```

https://www.youtube.com/watch?v=LZDgz0xKIpg

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_5InequalityDiffferece__att_0002.png)

pairwise distinct make it further tough

let the difference bw 3

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_5InequalityDiffferece__att_0003.png)

ans1     
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_5InequalityDiffferece__att_0004.png)

similarly    
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_5InequalityDiffferece__att_0005.png)

continued n sliding window
{% endraw %}
