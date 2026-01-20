[codeforces.com](https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/C)

![image.png](https://supernotes-resources.s3.amazonaws.com/profile-photos/a04bfae2-13cd-40d8-92ed-e15007af6692--image.png)

```cpp
void solve() {
    iinp(n);
    iinp(m);
    dsu d(n);
 
    for(ll i=0;i<m;i++){
        sinp(s);
        if(s=="join"){
            ll u,v;
            inp(u,v);
            u--,v--;
           d.union_(u,v);
        }
        else if(s=="add"){
            iinp(p);
            iinp(gain);
            p--; 
            d.pending[d.findRoot(p)]+=gain;
        }
        else{
            iinp(p);
            p--;
            pri(d.exp[p]+d.pending[d.findRoot(p)]);
        }
    }
}
```

```cpp
class dsu{
    public:
        vector<ll> par,size,exp,pending;
        vector<set<ll>> vos; 
        dsu(ll n){
            for(ll i=0;i<n;i++){
                par.push_back(i);
                size.push_back(1);
                exp.push_back(0);
                pending.push_back(0);
                vos.push_back({i});
            }
        }
 
        ll findRoot(ll node){
            if(par[node]==node) return node;
            return par[node]=findRoot(par[node]);
        }
 
        void union_(ll u, ll v){
            ll pu=findRoot(u), pv=findRoot(v);
            if(pu==pv) return ;
            if(size[pu]>=size[pv]) swap(pu,pv);  
            size[pv]+=size[pu];
            ll add=pending[pu]-pending[pv];
            for(ll x: vos[pu]){
                exp[x]+=add;
                vos[pv].insert(x);
            }
            vos[pu].clear();
            par[pu]=pv;
        }
 
};
```

