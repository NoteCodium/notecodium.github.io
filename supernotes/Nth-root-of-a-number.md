[Find Nth root of M | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article)
![image.png](../images/d3ebceb7-7d69-4412-b06f-7cf6e1d4c2dc--image.png)

```cpp
#define ll long long

ll ff(int m, int n){
    int mul=1;
    while(n--){
        mul*=m;
    }    
    return mul;
}

bool f(int m, int n, int x){
    ll mul=1;
    while(n--){
        mul*=m;
        if(mul>x) return 0;
    }
    return 1;
}

int NthRoot(int n, int x){
    if(n==1) return x;
    ll l=1,h=sqrt(x),ans=-1;
    while(l<=h){
        int m=(l+h)/2;
        if(f(m,n,x)) ans=m, l=m+1;
        else h=m-1;
    }
    return ff(ans,n)==x?ans:-1;
}  

```