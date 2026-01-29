---
title: 1CommonSum
---

{% raw %}
```python
//easy
int l=0, h=n-1;
while(l<h){
    int sum=v[l]+v[h];
    if(sum==k){

    }
    else if(sum>k){
        h--;
    }
    else{
        l++;
    }
}
```

```python
int l=0, h=n-1;
while(l<h){
    int sum=v[l]+v[h];
    if(sum==k){
        int p=v[l],q=v[h];
        if(p==q){
            break;
        }
        while(l<n and v[l]==p){
            l++;
        }
        while(h>=0 and v[h]==q){
            h--;
        }

    }
    else if(sum>k){
        h--;
    }
    else{
        l++;
    }
}
```

```python
ansAl.add(new ArrayList<>(Arrays.asList(v[l],v[h])));
```

```python
int l=0, h=n-1;
while(l<h){
    int sum=v[l]+v[h];
    if(sum==k){
        int p=v[l],q=v[h];
        if(p==q){
            int tmp=h-l+1;
            ans+=(ll)(((tmp)*(tmp-1))/2);
            break;
        }
        int cnt1=0, cnt2=0;
        while(l<n and v[l]==p){
            cnt1++;
            l++;
        }
        while(h>=0 and v[h]==q){
            cnt++;
            h--;
        }
        ans+=(cnt1*cnt2);
    }
    else if(sum>k){
        h--;
    }
    else{
        l++;
    }
}
```
{% endraw %}
