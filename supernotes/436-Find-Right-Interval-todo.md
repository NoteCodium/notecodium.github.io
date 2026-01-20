[Just a moment...](https://leetcode.com/problems/find-right-interval/description/)

```cpp
int custom_lower_bound(vector<vector<int>>& ma, int k, int n){
    if(k>ma[n-1][0]) return -1;
    //for each k, the smallest element greater then or equal to int
    int l=0,h=n-1,ans=-1;
    while(l<=h){
        int m=(l+h)/2;
        if(ma[m][0]>=k){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ma[ans][2];
}

vector<int> findRightInterval(vector<vector<int>>& ma1) {
    int n=ma1.size();
    vector<vector<int>> ma2;
    for(int i=0;i<n;i++){
        ma2.push_back({ma1[i][0],ma1[i][1],i});
    }
    sort(ma2.begin(),ma2.end());
    vector<int> ans(n);
    for(auto vv:ma2){
        ans[vv[2]]=custom_lower_bound(ma2,vv[1],n);
    }
    return ans;
}
```
