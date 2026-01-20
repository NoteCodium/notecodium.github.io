[Stone Game VI - LeetCode](https://leetcode.com/problems/stone-game-vi/description/)

[1686. Stone Game VI || Leetcode - YouTube](https://youtu.be/iEf6bWgqHZo?si=Uu-abimfAl4t4HOh)

```cpp
int stoneGameVI(vector<int>& v1, vector<int>& v2) {
    int n=v1.size();
    vector<vector<int>> v;
    for(int i=0;i<n;i++) v.push_back({v1[i]+v2[i],v1[i],v2[i]});
    sort(v.begin(),v.end(),greater<vector<int>>());
    int a=0,b=0;
    for(int i=0;i<n;i++){
        if(i%2==0) a+=v[i][1];
        else b+=v[i][2];
    }
    if(a==b) return 0;
    if(a>b) return 1;
    else return -1;
}
```