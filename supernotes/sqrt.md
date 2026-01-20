  [LeetCode - The World's Leading Online Programming Learning Platform](https://leetcode.com/problems/sqrtx/description/)

```cpp
int mySqrt(int x) {
  if(x<=1) return x;
  int l=1,h=x/2,ans=-1;
  while(l<=h){
  int m=(l+h)/2;
  if(m<=x/m){
  ans=m;
  l=m+1;
  }
  else h=m-1;
  }
  return ans;
}
```
