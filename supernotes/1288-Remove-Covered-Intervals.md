[Just a moment...](https://leetcode.com/problems/remove-covered-intervals/description/)

```cpp
int removeCoveredIntervals(vector<vector<int>>& ma) {
    sort(ma.begin(),ma.end(),[](auto &a, auto &b){
        if(a[0]!=b[0]) return a[0]<b[0];
        return a[1]>b[1];
    });
    int n=ma.size();
    int ans=n;  
    int l=-1,r=-1;
    for(auto v: ma){
        if(v[1]<=r) ans--;
        r=max(r,v[1]);
    }

    return ans;
}
```
