[Pizza With 3n Slices - LeetCode](https://leetcode.com/problems/pizza-with-3n-slices/description/)

You are restricted to pick n//3 slices only. In house robber 2 number of things you pick can exceed it

```cpp

int f(vector<int>& v, int k,int idx){
    if(idx<0 or k==0) return 0;
    int take=f(v,k-1,idx-2) + v[idx];
    int leave=f(v,k,idx-1);
    return max(take,leave);
}

int maxSizeSlices(vector<int>& v) {
    int n=v.size();
    int k=n/3;
    int tmp=v[0];
    v[0]=0;
    int case1=f(v,k,n-1);
    v[0]=tmp;
    v.back()=0;
    int case2=f(v,k,n-1);
    return max(case1,case2);
}  
```
