[Largest Perimeter Triangle - LeetCode](https://leetcode.com/problems/largest-perimeter-triangle/description/)

```cpp
int largestPerimeter(vector<int>& v) {
    int n=v.size();
    sort(v.begin(),v.end(),greater<int>());
    for(int i=0;i<=n-3;i++) if(v[i]<v[i+1]+v[i+2]) return v[i]+v[i+1]+v[i+2];
    return 0;
}
```