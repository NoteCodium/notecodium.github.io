```cpp
vector<int> subsetSums(vector<int> v, int n){
    vector<int> ans;
    ans.push_back(0);
    for(int i=0;i<n;i++){
        int sum=0;
        for(int j=i;j<n;j++){
            sum+=v[j];
            ans.push_back(sum);
        }
    }
    return ans;
}
```