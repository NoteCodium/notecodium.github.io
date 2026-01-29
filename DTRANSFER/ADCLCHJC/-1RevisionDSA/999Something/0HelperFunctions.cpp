#include <bits/stdc++.h>
using namespace std;

#define inf LLONG_MAX
#define ll long long
#define vl vector<int>
#define vl vector<long long>
#define it(v) v.begin(),v.end() 

ll sumArrayCalc(vl &v){return accumulate(it(v),0ll);}
ll minEl(vl &v){return *min_element(it(v));}
ll maxEl(vl &v){return *max_element(it(v));}

#define mod 1000000007  
ll moda(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a + b) % cm) + cm) % cm;}
ll modm(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a * b) % cm) + cm) % cm;}
ll mods(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a - b) % cm) + cm) % cm;}
int mpow(int base, int exp, long long cmod=mod){base %= cmod;long long result = 1;while (exp > 0) {if (exp & 1) result = ((long long)result * base) % cmod;base = ((long long)base * base) % cmod;exp >>= 1;}return result;}    
ll inv(ll a, ll m) {return mpow(a, m - 2, m);}
ll modd(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (modm(a, inv(b, cm), cm) + cm) % cm;}


vl preMaxCalc(vl &v){
    ll n=v.size();
    vl preMax(n);
    preMax[0]=v[0];
    for(ll i=1;i<n;i++){
      preMax[i]=max(preMax[i-1],v[i]);
    }
    return preMax;
  }
  
  vl postMaxCalc(vl &v){
    ll n=v.size();
    vl postMax(n);
    postMax[n-1]=v[n-1];
    for(ll i=n-2;i>=0;i--){
      postMax[i]=max(postMax[i+1],v[i]);
    }
    return postMax;
  }
  