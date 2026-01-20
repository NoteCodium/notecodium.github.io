[maang.in](https://maang.in/problems/Max-AND-Subsequences-54?resourceUrl=cs101-cp509-pl3417-rs54)

```cpp
void solve(){
    ll n, x;
    cin>>n>>x;
    vinp(v,n);
    ll mask=1ll<<31;
    ll ans=0;
    while(mask){
        vl tmp;
        for(ll x: v){
            if(x&mask){
                tmp.push_back(x);
            }
        }
        if(tmp.size()>=x){
            ans+=mask;
            v=tmp;
        }
        mask>>=1;
    }
    cout<<ans<<endl;
}
```