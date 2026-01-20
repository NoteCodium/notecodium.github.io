# Perfect squares
1. There are sqrt(n) perfect squares between 1 and n

# Integer Square root in logn
```cpp
int mySqrt(int x) { 
    if(x==0) return 0; 
    int m,l=1,h=x,ans=-1; 
    while(l<=h){ 
        m=l+(h-l)/2; 
        if(m<=x/m){ 
            ans=m; 
            l=m+1; 
        } 
        else h=m-1; 
    } 
    return ans; 
}
```
 
