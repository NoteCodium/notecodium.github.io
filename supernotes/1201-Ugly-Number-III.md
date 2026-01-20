[Just a moment...](https://leetcode.com/problems/ugly-number-iii/description/)

```cpp
long f(long m, long a, long b, long c){
    long lcm1=(a*b)/gcd(a,b);
    long lcm2=(c*b)/gcd(c,b);
    long lcm3=(a*c)/gcd(a,c);
    long lcmabc=c*lcm1/gcd(c,lcm1);
    return m/a+m/b+m/c-m/lcm1-m/lcm2-m/lcm3+m/lcmabc;
}

int nthUglyNumber(int n, int a, int b, int c) {
    long l=1,h=(long)n*min({a,b,c}),ans=-1;
    while(l<=h){
        long m= (l+h)/2;
        if(f(m,a,b,c)>=n){
            if(m%a==0 or m%b==0 or m%c==0) ans=m;
            h=m-1;
        } 
        else l=m+1;
    }
    return ans;
}
```