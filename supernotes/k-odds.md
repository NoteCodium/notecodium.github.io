[Count Number of Nice Subarrays - LeetCode](https://leetcode.com/problems/count-number-of-nice-subarrays/description/)

1. f(k)-f(k-1)
```cpp
int numberOfSubarrays(vector<int>& v, int k) {
    return f(v,k)-f(v,k-1);
}
```


3. Unordered_map with transformation
```cpp
int f(vector<int>& v, int k) {
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

int numberOfSubarrays(vector<int>& v, int k) {
    for(int &x: v) x=x%2?1:0;
    return f(v,k);
}
```
