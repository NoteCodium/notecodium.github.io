[Problem - 1833F - Codeforces](https://codeforces.com/problemset/problem/1833/F)

```cpp
void solve(){
    ll n,m;
    cin>>n>>m;
    vinp(v,n);
    map<ll,ll> mp;
    for(ll x: v){
       mp[x]++; 
    }
    vector<pair<long long, long long>> vp(it(mp));
    for(ll i=1;i<vp.size();i++){
        vp[i].second=modm(vp[i-1].second,vp[i].second);
    }
    ll ans=0;
    for(ll st=0;st+m-1<vp.size();st++){
        ll en=st+m-1;
        if(vp[en].first-vp[st].first<m){
            if(st==0){
                ans=moda(ans,vp[en].second);
            }
            else{
                ans=moda(ans,modd(vp[en].second,vp[st-1].second));
            }
        }
    }
    cout<<ans<<endl;
        
}
```