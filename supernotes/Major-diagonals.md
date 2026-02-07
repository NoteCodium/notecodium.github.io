1. the row index equals the column index. for the main major diagonal


![image.png](../images/b148f5d7-e563-4f43-b117-6470adab7154--image.png)

# DP diagonal traversal
```cpp
for(int d=1;d<n;d++){
  int r=0,c=d;
  while(r<n and c<n){

    r++;
    c++;
  }
}
```

