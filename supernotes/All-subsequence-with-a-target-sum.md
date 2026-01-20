1. You can take an element any number of times
[Combination Sum - LeetCode](https://leetcode.com/problems/combination-sum/description/)

```cpp
void f(vector<int> &temp, vector<vector<int>> &ans, vector<int>& v, int k, int i){
    if(k==0){
        ans.push_back(temp);
        return;
    }
    if(k<0 or i==-1) return;
    temp.push_back(v[i]);
    f(temp,ans,v,k-v[i],i);
    temp.pop_back();

    f(temp,ans,v,k,i-1);
}

vector<vector<int>> combinationSum(vector<int>& v, int k) {
    //generate all the subsequence such that the sum is k
    vector<vector<int>> ans;
    vector<int> temp;
    int n=v.size();
    f(temp,ans,v,k,n-1);
    return ans;
}
```

# Conatain repetitions, any number can be took only once
[Combination Sum II - LeetCode](https://leetcode.com/problems/combination-sum-ii/description/)

```cpp
void f(vector<int> &v, int idx, int k, vector<int> &tmp, vector<vector<int>> &ans){
    if(k==0){
        ans.push_back(tmp);
        return;
    }
    if(k<0 or idx==-1) return;
    tmp.push_back(v[idx]);
    f(v,idx-1,k-v[idx],tmp,ans);
    tmp.pop_back();

    int val=v[idx];
    while(idx<v.size() and v[idx]==val) idx--;
    f(v,idx,k,tmp,ans);
}


vector<vector<int>> combinationSum2(vector<int>& v, int k) {
    vector<vector<int>> ans;
    sort(v.begin(),v.end());
    int n=v.size();
    vector<int> tmp;
    f(v,n-1,k,tmp,ans);
    return ans;
}
```
