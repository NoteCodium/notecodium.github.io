[Pow(x, n) - LeetCode](https://leetcode.com/problems/powx-n/description/)


```cpp
double helper(double n, int p) {
    if(p==0) return 1;
    double x= myPow(x,p/2);
    if(p%2==0) return x*x;
    return x*x*n;   
}
double myPow(double n, int p){
    double tmp=helper(n,abs(p));
    return p>=0?tmp:1/tmp;
}

```
