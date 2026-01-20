[leetcode.com](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)
- 10 11 14 22 3 8
- rotated sorted array 1
- left half > v[n-1]
- right half <=v[n-1]

```cpp
    int n=v.size();
    if(n==1) return v[0]==k?0:-1;
    int pivot=v.back();
    int l=0,h=n-1,ans=-1;

    while(l<=h){
        int m=(l+h)/2;
        if(v[m]>pivot) ans=m,l=m+1;
        else h=m-1;
    }
```

# Search
```cpp
if(k>pivot) return binary_search(v.begin(),v.begin()+ans+1,k) ? lower_bound(v.begin(),v.begin()+ans+1,k)-v.begin() : -1;
return binary_search(v.begin()+ans+1,v.end(),k) ? lower_bound(v.begin()+ans+1,v.end(),k)-v.begin() : -1;
```

# minn and maxx
```cpp
cout<<v[ans+1]<<" "<<v[ans];
```
1.  If the array is [1, 2, 3]
2.  Then your code will give wa

```cpp
if(n==1){
    cout<<v[0]<<" "<<v[0];
    pri();
    return;        
}
if(v[0]<v.back()){
    cout<<v[0]<<" "<<v.back();
    pri();
    return ;
}

```
