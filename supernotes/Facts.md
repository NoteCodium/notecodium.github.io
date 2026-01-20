# checking ith bit 
```
n & (1)
```



1. n & n-1 removes the right most set bit
2. n | n+1 set rightmost 0 to 1
3. turn on: element | mask
4. turn off: element & ~mask
```
6. flip: element ^ mask
```

7. Turning off last k set bits at once
```cpp
ll mask=1ll<<k;
x=x&mask;
```
8. Swapping two numbers
```cpp

```

 