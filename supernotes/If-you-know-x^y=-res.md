1. This quantity will not be zero because these two elements are different
2. 1100
     ^ The first bit difference betwen x and y

3. Creating a mask
```cpp
ll mask=1ll<<31;
while(maask and !(mask & res)) mask>>=1;
//The mask created can now differntiates between two groups of numbers
```
```cpp
int ans=0;
for(int x: v) if(x & mask) ans^=x;
```


