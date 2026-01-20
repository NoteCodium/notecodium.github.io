```cpp
int minSubArray(vector<int>& v) {
    int n=v.size(),curr_sum=0,ans=INT_MAX;
    for(int x: v){
        curr_sum+=x;
        if(curr_sum<ans){
            ans=curr_sum;
        }
        if(curr_sum>0){
            curr_sum=0;
        }
    }
    return ans;
}
```
