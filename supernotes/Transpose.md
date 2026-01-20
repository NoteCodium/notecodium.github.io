
# Square
ma[j][i]

full
```cpp
iterate over all 
for(int r=0;r<rr;r++){
  for(int c=r+1;c<cc;c++){
  swap(ma[r][c],ma[c][r]);  
  }
}
```
# Rectangular
```cpp
vvl ans(cc,vl(rr));
for(int r=0;r<rr;r++){
  for(int c=0;c<cc;c++){
    ans[c][r]=ma[r][c]
  }
}
```
