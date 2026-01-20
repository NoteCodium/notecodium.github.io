[Peak Index in a Mountain Array - LeetCode](https://leetcode.com/problems/peak-index-in-a-mountain-array/description/)

```cpp
// left most < < <
//right  > > >
int n=v.size(),
int ans=-1;
int l=0,h=n-1;
while(l<=h){
    int m=(l+h)/2;
    if(m==0 or v[m-1]<v[m]){
        ans=m;
        l=m+1;
    }
    else if(m==n-1 or v[m]>v[m+1]) h=m-1;
}
return ans;
```