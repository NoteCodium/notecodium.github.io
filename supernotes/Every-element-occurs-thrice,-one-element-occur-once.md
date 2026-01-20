1. res xor will be xor of all the unique elements
2. ADDITION OF BITS IS USED

```cpp
ll mask=1ll<<31;
ll ans=0;
while(mask){
  int cnt=0;
  for(int x: v) if(x & mask) cnt++;
  if(cnt%3) ans+=mask;
  mask>>=1;
}
```