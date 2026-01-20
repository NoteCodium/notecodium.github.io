```cpp
um[0]=1;
int px=0;
for(int x: v){
  ps^=x;
  ans+=um[px^k];
  um[ps]++;
}
```
