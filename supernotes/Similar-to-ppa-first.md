[Rearrange an array with O(1) extra space | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article)


[Rearrange Array | InterviewBit](https://www.interviewbit.com/problems/rearrange-array/)

```
//v[i]=v[v[i]]
```
```cpp
vector<long long> tmp(n);
for(int i=0;i<n;i++){
    tmp[i]=v[v[i]];
}
```

### PPA
```cpp
//v[i]=v[v[i]]
for(int i=0;i<n;i++){
    v[i]=(v[v[i]%n]%n)*n + v[i]%n;
}
for(int i=0;i<n;i++){
    v[i]=v[i]/n;
}  
```



