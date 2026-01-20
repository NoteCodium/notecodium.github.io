[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/1/practice/contest/307092/problem/B)

You are given two arrays, sorted in non-decreasing order. For each element of the second array, find the number of elements in the first array strictly less than it.

1. logn * m

n
m

```cpp
ll i=0,prev_cnt=0;
for(ll x: v2){
    ll curr_cnt=0;
    while(i<n and a[i]<x){
        curr_cnt++;
        i++;
    }
    cout<<prev_cnt+curr_cnt<<" ";
    prev_cnt=prev_cnt+curr_cnt;
}
```

Here is a great thing, dont refresh cnt

```cpp
ll i=0,cnt=0;
for(ll x: v2){
    while(i<n and a[i]<x){
        cnt++;
        i++;
    }
    cout<<cnt<<" ";
}
```
