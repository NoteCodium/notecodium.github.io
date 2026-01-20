[leetcode.com](https://leetcode.com/problems/remove-element/description/)
```cpp
int s=0,f=0;
while(f<n){
    if(v[f]!=k){
        v[s]=v[f];
        s++;
    }
    f++;
}
return s;
}  
```
