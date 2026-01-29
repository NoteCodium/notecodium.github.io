---
title: 3InequalitySum
---

{% raw %}
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_3InequalitySum__att_0001.png)

```python
int l=0, h=n-1;
int ans=0;
while(l<r){
    int sum=v[l]+v[h];
    if(sum>k){
        ans+=(h-l);//all the pairs except v[l] alone
        h--;
    }
    else{
      l++;              
    }
}
```

You are given an array of integers nums and an integer target. Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_3InequalitySum__att_0002.png)

```python
int l=0,h=n-1;
while(l<=h){
    int sum=v[l]+v[h];
    if(sum<=k){
        int len=h-l+1;
        ans=moda(ans,mpow(2,len-1));
        l++;
    }
    else h--;
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_96TwoPointers_15Inequality_3InequalitySum__att_0003.png)
{% endraw %}
