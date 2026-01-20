[maang.in](https://maang.in/problems/Solve-Intervals-3-488?resourceUrl=cs80-cp494-pl3331-rs488)

```cpp
void solve(){
    ll n;
    cin>>n;
    vector<vector<long long>> ma;
    while(n--){
        ll l,r,x;
        cin>>l>>r>>x;
        ma.push_back({l,0,x});
        ma.push_back({r,2,x});
    }
    ll q;
    cin>>q;
    for(ll i=0;i<q;i++){
        ll y,z;
        cin>>y>>z;
        ma.push_back({y,1,i,z});
    }
    sort(it(ma));
    multiset<ll> se;
    vl ans(q);    
    for(auto vv: ma){
        if(vv[1]==0) se.insert(vv[2]);
        else if(vv[1]==2) se.erase(se.find(vv[2]));
        else{
            auto ptr=se.upper_bound(vv[3]);
            if(ptr==se.begin() or se.empty()) ans[vv[2]]=-1;
            else{
                ptr--;
                ans[vv[2]]=*ptr;
            }
                
        }
    }
    for(ll an: ans){
        cout<<an<<endl;
    }
    cout<<endl;

}
```