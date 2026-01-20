At every step prune the leaves, no of nodes after k prunnings





[Problem - E - Codeforces](https://codeforces.com/contest/1593/problem/E)


```cpp
void solve(){   
    iinp(n);
    iinp(k);
    vvl al(n,vl());
    for(ll i=1;i<n;i++){
        ll u,v;
        inp(u,v);
        u--,v--;
        al[u].push_back(v);
        al[v].push_back(u);
    }

    queue<ll> qprev;
    vl non(n);
    for(ll i=0;i<n;i++){
        non[i]=al[i].size();
    }
    
    for(ll i=0;i<n;i++){
        if(non[i]==1) qprev.push(i);
    }
    while(k--){
        if(n<=2){
            pri(0);
            return;
        }
        queue<ll> qcurr;
        while(!qprev.empty()){
            ll x=qprev.front();qprev.pop();n--;
            for(auto y:al[x]){
                non[y]--;
                if(non[y] == 1) qcurr.push(y);
            }
        }     
        qprev=qcurr;
    }
    pri(n);
}
```
