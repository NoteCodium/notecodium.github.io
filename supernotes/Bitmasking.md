I have done it somewhere ache se

Need formal introduction to bitmaskiuing I thin from dp notes

Priyansh DP bootcamp

These topics in cp bits samsung noes


# n 2 ^n
Higher time complexity

[Subsets - LeetCode](https://leetcode.com/problems/subsets/)
```cpp
vector<vector<int>> subsets(vector<int>& v) {
    vector<vector<int>> ans;
    int n=v.size();
    int mask=(1<<n);
    //mask containing n once in its binary representation
    for(int x=0;x<mask;x++){
        vector<int> tmp;
        for(int idx=0;idx<n;idx++){
                if(x & (1<<idx)) tmp.push_back(v[idx]);
        }
        ans.push_back(tmp);
    }
    return ans;
}
```
