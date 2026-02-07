r+c is even then move upwards north east
r+c is odd south west

![image.png](../images/7e879589-55b1-49e3-a364-ee65cd334c88--image.png)


```cpp
while(cnt--){
  ans.pb(ma[r][c]);
  if(r+c is even){
    if(r==0) c++;
    else if(c==cc-1) r++;
    else r--,c++;
  }
  else{
    if(r==rr-1) c++;
    else if(c==0) r++;
    else r++,c--;
  }
}
```

