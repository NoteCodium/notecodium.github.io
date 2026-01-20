[Subarrays with K Different Integers - LeetCode](https://leetcode.com/problems/subarrays-with-k-different-integers/description/)

1. f(k)-f(k-1)
```cpp
return f(v,k)-f(v,k-1);
```