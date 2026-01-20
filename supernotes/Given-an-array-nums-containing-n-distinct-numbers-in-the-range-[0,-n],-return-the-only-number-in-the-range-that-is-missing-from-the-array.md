[Missing Number - LeetCode](https://leetcode.com/problems/missing-number/description/)

```cpp
int missingNumber(vector<int>& v) {
    int n=v.size();
    int ans=0;
    for(int i=0;i<n;i++) ans=ans^v[i]^(i+1);
    return ans;
}
```
