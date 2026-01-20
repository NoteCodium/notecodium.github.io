[Longest Sub-Array with Sum K | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)

```cpp
int lenOfLongSubarr(int v[],  int n, int k) { 
    unordered_map<int,int> um;
    um[0]=-1;
    //actually 0 but for our use later
    int ans=0;
    long long ps=0;
    for(int i=0;i<n;i++){
        ps+=v[i];
        if(um.count(ps-k)){
            ans=max(ans,i-(um[ps-k]+1)+1);
        }
        //oldest occurence of each prefix sum should be saved only
        if(!um.count(ps)){
            um[ps]=i;
        }
    }
    return ans;
}
```

prefix sum between l and r is
```
ps[r]-ps[l-1];
```
