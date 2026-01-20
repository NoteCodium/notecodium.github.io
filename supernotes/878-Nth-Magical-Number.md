[Nth Magical Number - LeetCode](https://leetcode.com/problems/nth-magical-number/description/)

```cpp
long f(long m, long a, long b){
    long lcm=(a*b)/gcd(a,b);
    return m/a+m/b-m/lcm;
}

int nthMagicalNumber(int n, int a, int b) {
    long l=1,h=(long)n*min(a,b),ans=-1;
    while(l<=h){
        long m= (l+h)/2;
        if(f(m,a,b)>=n){
            if(m%a==0 or m%b==0) ans=m;
            h=m-1;
        } 
        else l=m+1;
    }
    return ans%(int)(1e9+7);
}
```