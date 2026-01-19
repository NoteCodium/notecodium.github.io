# Number of equal in two sorted


```python
int i=0,j=0;
ll ans=0;
while(i<n and j<m){
    int q=a[i],w=b[j];
    if(q==w){
        ll cnt1=0,cnt2=0;
        while(i<n and q==a[i]) cnt1++,i++;
        while(j<m and w==b[j]) cnt2++,j++;
        ans+=(cnt1*cnt2);
    }
    else if(a[i]>b[j]) j++;
    else i++;
}
```

# Number of Smaller in two arrays
1. two sorted arrays
For each element of the second array, find the number of elements in the first array strictly less than it.


```python
ll i=0,prev_cnt=0;
for(ll x: v2){
    ll curr_cnt=0;
    while(i<n and a[i]<x){
        curr_cnt++;
        i++;
    }
    cout<<prev_cnt+curr_cnt<<" ";
    prev_cnt=prev_cnt+curr_cnt;
}
```

or


```python
ll i=0,cnt=0;
for(ll x: v2){
    while(i<n and a[i]<x){
        cnt++;
        i++;
    }
    cout<<cnt<<" ";
}
```
