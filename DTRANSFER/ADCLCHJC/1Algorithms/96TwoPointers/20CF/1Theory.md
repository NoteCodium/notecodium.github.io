---
title: 1Theory
---

{% raw %}
# No Negatives

no. of subarray whose sum is>=k  
If a smaller subarray has it, the bigger one including it will definitely have it

cant these two codes be unified

```python
int l=0,h=0;
int sum=0;
while(h<n){
    sum+=v[h];
    while(sum>=k and l<=h){
        ans+=(n-h);
        sum-=v[l];
        l++;    
    }
    h++;
}
```

associated problem

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_20CF_1Theory__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_20CF_1Theory__att_0002.png)

no. of subarray whose sum is<=k  
If a larger subarray has it, the smaller one including it will definitely have it

```python
int l=0,h=0;
int sum=0;
while(h<n){
    sum+=v[h];
    while(sum>k and l<h){
        sum-=v[l];
        l++;    
    }
    if(sum<=k and l<=h){
        ans+=(h-l+1);
    }
    h++;
}
```

# Similarly

smallest subarray with sum>=k

```python
int l=0,h=0,sum=0,ans=INT_MAX;
while(h<n){
    sum+=v[h];
    while(sum>=k and l<=h){ 
      //condition for answer
        ans=min(ans,h-l+1);
        sum-=v[l];
        l++;
    }
    h++;  
}  
```

largest subarray with sum<=k

```python
int l=0,h=0,sum=0,ans=0;
while(h<n){
    sum+=v[h]; //same as above
    while(sum>k and l<h){
      sum-=v[l];
      l++;
    }
    if(sum<=k and l<=h) ans=max(ans,h-l+1); 
    h++;  
}
```
{% endraw %}
