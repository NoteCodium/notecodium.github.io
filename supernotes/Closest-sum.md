
# Three sum closest
[leetcode.com](https://leetcode.com/problems/3sum-closest/description/)
find 3 integers such that the sum is closest to k, return that sum
```cpp
int chk=INT_MAX;
for(int i=0;i<n;i++){
  if(i>0 and v[i]==v[i-1]) continue;
  int rem=k-v[i];
  int l=i+1,h=n-1;
  while(l<h){
      int sum=v[l]+v[h];
      if(sum==rem) return k;
      if(chk>abs(k-(v[i]+v[l]+v[h]))){
        ans=v[i]+v[l]+v[h];
        chk=abs(k-(v[i]+v[l]+v[h]));     
      }
      if(sum<rem) l++;
      else h--;
    }
}
```
