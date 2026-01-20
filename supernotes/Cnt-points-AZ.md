[maang.in](https://maang.in/problems/Count-Unique-Char-in-Substrings-63?resourceUrl=cs99-cp512-pl3478-rs63)


```cpp
void solve(){
    iinp(n);
    sinp(s);
    ll ans=0;
    vl v[26];
    for(ll i=0;i<26;i++){
        v[i].push_back(-1);
    }

    for(ll i=0;i<n;i++){
        char c=s[i];
        v[c-'a'].push_back(i);
    }
    

    for(ll i=0;i<26;i++){
        v[i].push_back(n);
    }

    for(ll i=0;i<26;i++){
        for(ll j=1;j<=(ll)(v[i].size()-2);j++){
            ans+=(v[i][j]-v[i][j-1])*(v[i][j+1]-v[i][j]);
        }
    }
    cout<<ans<<endl;
    
}
```