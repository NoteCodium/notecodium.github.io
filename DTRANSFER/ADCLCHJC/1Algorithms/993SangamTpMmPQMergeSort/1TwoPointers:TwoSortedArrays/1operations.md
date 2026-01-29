---
title: 1operations
---

{% raw %}
# Union

```python
vector<int> ans;
int i=0,j=0;
while(i<n1 and j<n2){
    int q=a[i],w=b[j];
    if(q==w){
        ans.push_back(q);
        while(i<n1 and q==a[i]) i++;
        while(j<n2 and w==b[j]) j++;
    }
    else{
        int minn=min(q,w);
        ans.push_back(minn);
        if(minn==q){
            while(q==a[i])
            i++;
        }
        else{
            while(w==b[j])
            j++;  
        }
    }
}

while(i<n1){
    int q=a[i];
    ans.push_back(a[i]);
    while(i<n1 and q==a[i])
    i++;
}

while(j<n2){
    int w=b[j];
    ans.push_back(b[j]);
    while(j<n2 and w==b[j])
    j++;
}
```

# Intersection

```python
vector<int> intersection(vector<int>& a, vector<int>& b) {
    vector<int> ans;
    int i=0,j=0;
    while(i<n1 and j<n2){
        int q=a[i],w=b[j];
        if(q==w){
            ans.push_back(q);
            while(i<n1 and q==a[i]) i++;
            while(j<n2 and w==b[j]) j++;
        }
        else if(a[i]>b[j]) j++;
        else i++;
    }
    return ans;
}
```
{% endraw %}
