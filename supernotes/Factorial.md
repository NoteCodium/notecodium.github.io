
```cpp
ll fac(ll x){
    if(x==0 or x==1) return 1;
    vector<ll> fact(x+1);
    fact[0] = fact[1] = 1;
    for(ll i=2; i<=x; i++)
    (fact[i] = i*fact[i-1]) %= mod;
    return fact[x];
}
```