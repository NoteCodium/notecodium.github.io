# checkPrime(x) O(sqrt(x))
# checkPrime for an array 1 to n O(nloglogn)
```cpp
vector<ll> sieve(ll n){ 
    vector<ll> primes; 
    vector<ll> checkPrime(n+1,1);  
    checkPrime[0]=checkPrime[1]=0;  
    for(ll i=2;i<=n;i++){  
        if(checkPrime[i]){ 
                primes.push_back(i); 
                for(ll j=i;i*j<=n;j++){  
                checkPrime[i*j]=0;  
            }        
        }  
    } 
    return primes; 
}
```

