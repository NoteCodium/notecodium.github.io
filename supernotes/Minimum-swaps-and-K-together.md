![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/37aeb679-94ee-4dcc-9f35-03d18df95bd7--image.png)

[Minimum swaps and K together | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)


```cpp
int minSwap(int v[], int n, int k) {
    int ws=0;
    for(int i=0;i<n;i++) if(v[i]<=k) ws++;
    if(ws==0) return 0;
    int cnt=0,maxx=0;
    for(int i=0;i<=ws-2;i++) if(v[i]<=k) cnt++;
    for(int i=ws-1;i<n;i++){
        if(v[i]<=k) cnt++;
        maxx=max(maxx,cnt);
        if(v[i-ws+1]<=k) cnt--;
    }
    return ws-maxx;
}
```



1. find cnt of all numbers <=k
2. ws===cnt
3. find in which window, maximum such number is occuring

ws-maxx 

is answer

https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

```cpp
int minSwap(int v[], int n, int k) {
    int ws=0;
    for(int i=0;i<n;i++) if(v[i]<=k) ws++;
    if(ws==0) return 0;
    int cnt=0,maxx=0;
    for(int i=0;i<=ws-2;i++) if(v[i]<=k) cnt++;
    for(int i=ws-1;i<n;i++){
        if(v[i]<=k) cnt++;
        maxx=max(maxx,cnt);
        if(v[i-ws+1]<=k) cnt--;
    }
    return ws-maxx;
}
```

