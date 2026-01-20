[Solution: Find the Missing Number](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63dd93ca488110f74a920bfe)

1. easy bits solution
```cpp
int missingNumber(vector<int>& v) {
    int n=v.size();
    int ans=0;
    for(int i=0;i<n;i++) ans=ans^v[i]^(i+1);
    return ans;
}
```


1. Sort in Onlogn then: 
```cpp
  for(int i=0;i<n;i++){
    if(v[i]!=i) return i;
  }
  return n;
```

# The learning will be here sorting n elements between 0 to n in linear time with cyclic algorithms, not sort but the concepts like sort that you will learn

```cpp
static vector<int> sort(vector<int> &v) {
  int n=v.size();
  for(int i=0;i<n;i++){
    while(v[i]!=n and v[i]!=i){
      int idx=v[i];
      swap(v[i],v[idx]);
    }
  }
  return v;
}

static int findMissingNumber(vector<int> &v) {
    sort(v);
    int n=v.size();
    for(int i=0;i<n;i++){
      if(v[i]!=i) return i;
    }
    return n;
}
```
