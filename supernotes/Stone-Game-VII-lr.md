[Stone Game VII - LeetCode](https://leetcode.com/problems/stone-game-vii/description/)

```
// they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row

//The winner is the one with the higher score when there are no stones left to remove.
```

```cpp
int f(int l, int r, int sum, vector<int> &v){
    if(l>r) return 0;
    return max(sum-v[l]-f(l+1,r,sum-v[l],v), sum-v[r]-f(l,r-1,sum-v[r],v));
}

int stoneGameVII(vector<int>& v) {
    int sum=accumulate(v.begin(),v.end(),0); 
    int n=v.size();
    return f(0,n-1,sum,v);
}
```
