with unordered map

```cpp
int subarraySum(vector<int>& v, int k) {
    int ans=0;
    int n=v.size();
    unordered_map<int,int> um;
    um[0]=1;
    int ps=0;
    for(int x: v){
        ps+=x;
        ans+=um[ps-k];
        um[ps]++;
    }
    return ans;
}
```
