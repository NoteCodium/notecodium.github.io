the resources in ppa problems


Grid wala advanced  


```python
#include<bits/stdc++.h>
using namespace std;

typedef long long ll;

ll extendedEuclidean(ll a, ll b, ll& x, ll& y) {
   x = 1, y = 0;
   ll x1 = 0, y1 = 1, a1 = a, b1 = b;
   while (b1) {
      ll q = a1 / b1;
      tie(x, x1) = make_tuple(x1, x - q * x1);
      tie(y, y1) = make_tuple(y1, y - q * y1);
      tie(a1, b1) = make_tuple(b1, a1 - q * b1);
   }
   return a1;
}

ll moduloInverse(ll a, ll m){
   ll x, y;
   ll g = extendedEuclidean(a, m, x, y);
   if(g!=1) return -1;
   x = (x%m+m)%m;
   return x;
}

ll modAdd(ll x, ll y, ll m){return ((x%m)+(y%m))%m;}
ll modSub(ll x, ll y, ll m){return ((x%m)-(y%m)+m)%m;}
ll modMul(ll x, ll y, ll m){return ((x%m)*(y%m))%m;}
ll modDiv(ll x, ll y, ll m){return ((x%m)*(moduloInverse(y, m)%m))%m;}

vector<ll> factmod(ll n, ll m) {
   vector<ll> f(n+1, 0);
   f[0] = 1;
   for(ll i = 1; i<=n; i++){
      f[i] = modMul(f[i-1], i, m);
   }
   return f;
}

ll nCr(ll n, ll r, ll m, vector<ll> &fact){
   return modMul(fact[n], modMul(moduloInverse(fact[n-r], m), moduloInverse(fact[r], m), m), m);
}

int famerIntheFarm(int r, int c){
   r--;
   c--;
   ll mod = 1000000007;
   ll ans = 0;
   ll n = max(r, c);
   vector<ll> fact = factmod(n+1, mod);
   for(int one = 0; one<=r; one++){
      if((r-one)%2!=0)  continue;
      int two = (r-one)/2;
      int sum = one*2+two;
      if(sum!=c)  continue;
      ans += nCr(one+two, one, mod, fact);
      ans %= mod;
   }
   return (int)ans;
}
```
