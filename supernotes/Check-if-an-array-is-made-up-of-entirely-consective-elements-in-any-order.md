# Brute force 
sort and check

# Using unordered map
```cpp
bool areConsecutives(long long v[], int n) { 
    long long minn=*min_element(v,v+n),maxx=*max_element(v,v+n);
    if(maxx-minn!=n-1) return 0;
    unordered_map <long long, int> um;
    for(int i=0;i<n;i++){
        um[v[i]]++;
        if(um[v[i]]>1) return 0;
    } 
    for(int i=minn;i<=maxx;i++) if(um[i]!=1) return 0;
    return 1;

}
```