[Divide Two Integers - LeetCode](https://leetcode.com/problems/divide-two-integers/description/?envType=list&envId=ejvqgi2s)


# Brute force
```cpp
int divide(int dividend, int divisor) {
    if(dividend==INT_MIN and divisor==-1) return INT_MAX;
    if(dividend==INT_MIN and divisor==1) return INT_MIN;
    //handling the case when dividend is INT_MIN,because moding will create problem

    if(divisor==INT_MIN and dividend==INT_MIN) return 1;
    if(divisor==INT_MIN) return 0;
  
    int sign=(dividend>=0)==(divisor>=0)?1:-1;
    int ans=0;
    long convDividend=abs(dividend),convDivisor=abs(divisor);
    while(convDividend>=convDivisor){
        ans++;
        convDividend-=convDivisor;
    }
    return sign*ans;
}
```

# Optimal
[Divide Two Integers | Leetcode - 29 - YouTube](https://youtu.be/m4L_5qG4vG8?si=tzk4i8AWErj-gotP)

```cpp
int divide(int dividend, int divisor) {
    if(dividend==INT_MIN and divisor==-1) return INT_MAX;
    if(dividend==INT_MIN and divisor==1) return INT_MIN;

    if(divisor==INT_MIN and dividend==INT_MIN) return 1;
    if(divisor==INT_MIN) return 0;
  
    int sign=(dividend>=0)==(divisor>=0)?1:-1;
    int ans=0;
    long convDividend=abs(dividend),convDivisor=abs(divisor);
    while(convDividend>=convDivisor){
        int cnt=0;
        while(convDividend>=(convDivisor<<(cnt+1))) cnt++;
        ans+=(1<<cnt);
        convDividend-=(convDivisor<<cnt);
    }
    return sign*ans;
}
```


