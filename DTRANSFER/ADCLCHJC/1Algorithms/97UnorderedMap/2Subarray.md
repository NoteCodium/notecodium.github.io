---
title: 2Subarray
---

{% raw %}
no. of subarray with a sum k

```python
int ans=0;
m[0]=1;
int ps=0;
for(int x: v){
    ps+=x;
    ans+=m[ps-x];
    m[ps]++;
}
```

```python
//xor k
int ans=0;
m[0]=1;
int px=0;
for(int x: v){
    px^=x;
    ans+=m[px^x];
    m[px]++;
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_97UnorderedMap_2Subarray__att_0001.png)

```python
m[0]=-1;// will help in calculation of len, you will see it later
int ps=0;
int ans=0;
for(int i=0;i<n;i++){
    ps+=v[i];
    if(m.count(ps-k)){
        ans=max(ans, i-(m[ps-k]+1)+1); //r-l+1
    }
    if(!m.count(ps)){
        //We want the window to be as big as possible
        m[ps]=i;
    }
}
```
{% endraw %}
