[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/1/practice/contest/307092/problem/C)

You are given two arrays a and b, sorted in non-decreasing order. Find the number of pairs (i,j)for which ai=bj.

```cpp
int i=0,j=0;
ll ans=0;
while(i<n and j<m){
    int q=a[i],w=b[j];
    if(q==w){
        ll cnt1=0,cnt2=0;
        while(i<n and q==a[i]) cnt1++,i++;
        while(j<m and w==b[j]) cnt2++,j++;
        ans+=(cnt1*cnt2);
    }
    else if(a[i]>b[j]) j++;
    else i++;
}
```
