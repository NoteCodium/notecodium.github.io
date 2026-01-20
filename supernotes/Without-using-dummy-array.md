```cpp
int x=1,y=1; // for tracking row 0 and column 0
for(int c=0;c<cc;c++) if(!ma[0][c]) x=0;
for(int r=0;r<cc;r++) if(!ma[r][0]) y=0;

for(int r=1;r<rr;r++){
  for(int c=1;c<cc;c++){
    if(!ma[r][c]){
      ma[0][c]=0;
      ma[r][0]=0;
    }
  }
}
for(int r=1;i<rr;r++){
    for(int c=1;c<cc;c++){
      if(!ma[r][0] or !ma[0][c]) ma[r][c]=0;
  }
}
if(!x) for(int c=0;c<cc;c++) ma[0][c]=0;
if(!y) for(int r=0;r<rr;r++) ma[r][0]=0;
```
If the 0 row and 0 column elements have became 0 due to tracking, no problem, you wanted to them be anyway, the remaining 1 are good as it is