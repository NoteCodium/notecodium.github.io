[Previous Permutation With One Swap - LeetCode](https://leetcode.com/problems/previous-permutation-with-one-swap/description/)

https://youtu.be/qwFSeqYH6jc?si=ZEpRMRmjlPArYtQ7

```cpp
vector<int> prevPermOpt1(vector<int>& v) {
    int n=v.size();
    int i=n-2;
    while(i>=0 and v[i]<=v[i+1]) i--;
    if(i>=0){
            int ans=-1,j=i+1,maxx=INT_MIN;
            //find biggest element that is right of the elemeent and smaller them
            //v[i] and occuring first 
            while(j<n){
                if(v[j]<v[i] and v[j]>maxx){
                    ans=j;
                    maxx=v[j];
                }
                j++;
            }
            swap(v[i],v[ans]);
        }
    return v;
}
```
