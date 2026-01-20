[CSES - Restaurant Customers](https://cses.fi/problemset/task/1619)

```cpp
void solve(){
    ll n;
    cin>>n;
    vector<vector<long long>> ma;
    while(n--){
        ll l,r;
        cin>>l>>r;
        ma.push_back({l,1});
        ma.push_back({r,-1});
    }
    ll ans=1;
    sort(it(ma));
    ll cnt=0;
    for(auto v: ma){
        cnt+=v[1];
        ans=max(cnt,ans);
    }

    cout<<ans<<endl;
}
```