[leetcode.com](https://leetcode.com/problems/longest-mountain-in-array/description/)




```cpp
int ans=0;
for(int i=1;i<=n-2;){
    if(v[i-1]<v[i] and v[i]>v[i+1]){
    //find the peak
        int cnt=1;
    //length of peak
        int j=i;
    //going left
        while(j>0 and v[j-1]<v[j]){
            cnt++;
            j--;
        }
    //going right
        while(i<=n-2 and v[i]>v[i+1]){
            cnt++;
            i++;
        }
        ans=max(ans,cnt);
    }
    else i++;
}
```


[Longest Mountain in Array Leetcode 845 || Medium - YouTube](https://youtu.be/VXeukMTbxkw?si=lVTrcOxN2WLyd3vM)
