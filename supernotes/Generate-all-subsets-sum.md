[Subset Sums | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/subset-sums2234/1)

```cpp
void findSum(vector<int> &ans, vector<int> &v, int idx, int &sum){
    if(idx==-1){
        ans.push_back(sum);
        return;
    }
    findSum(ans,v,idx-1,sum);
    sum+=v[idx];
    findSum(ans,v,idx-1,sum);
    sum-=v[idx];
}

vector<int> subsetSums(vector<int> v, int n){
    vector<int> ans;
    int sum=0;
    findSum(ans,v,n-1,sum);
    return ans;
}
```
