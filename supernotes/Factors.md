# Find number having k factors
1. 1 Factor => 1
2. 2 Factors => Prime numbers
3. 3 Factors => Square of prime numbers
4. Odd number of factors => Perfect squares

# Find number of factors
# sqrt n
```cpp
int countFactors(int n){
    int ans=0;
    for(int i=1;i*i<=n;i++){
        if(n%i==0){
            ans++;
            if(n/i!=i) ans++;
        }
    }
    return ans;
}
```