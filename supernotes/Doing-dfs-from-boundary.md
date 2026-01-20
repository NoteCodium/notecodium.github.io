```cpp
for(int i=0;i<rr;i++){
    for(int j=0;j<cc;j++) if(
        (i==0 or i==rr-1 or j==0 or j==cc-1) and ma[i][j]==1) dfs(i,j,ma);
}
```
