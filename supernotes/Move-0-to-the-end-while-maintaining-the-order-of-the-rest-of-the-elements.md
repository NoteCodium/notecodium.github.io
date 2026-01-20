[leetcode.com](https://leetcode.com/problems/move-zeroes/description/)

```cpp
int s=0,f=0;
while(f<n){
    if(v[f]){
        v[s]=v[f];
        s++;
    }
    f++;
}
while(s<n){
    v[s]=0;
    s++;
}
```

