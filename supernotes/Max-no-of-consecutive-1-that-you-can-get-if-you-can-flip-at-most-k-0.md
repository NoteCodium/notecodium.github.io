1. Longet subarray having <=k zero
longest subarray with atmost k 0
[leetcode.com](https://leetcode.com/problems/max-consecutive-ones-iii/description/)


```cpp
int l=0,h=0,cnt=0,ans=0;
while(h<n){
    if(v[h]==0) cnt++; //same as above
    while(cnt>k and l<=r){
      //this is not the condition of answer
      if(v[l]==0) cnt--;
      l++;
    }
    if(cnt<=k and l<=h) ans=max(ans,h-l+1); 
    h++;  
}
```





