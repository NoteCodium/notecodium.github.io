[Two Sum - LeetCode](https://leetcode.com/problems/two-sum/description/)

```cpp

unordered_map<int,int> um;
int n=v.size();
for(int i=0;i<n;i++){
    if(um.count(k-v[i])) return {um[k-v[i]],i};
    um[v[i]]=i;
}
return {-1,-1};

```

1. If you sort it you wil change the indices

