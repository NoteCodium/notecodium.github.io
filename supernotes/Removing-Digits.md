[CSES - Removing Digits](https://cses.fi/problemset/task/1637)

```cpp
ll f(ll k){
    if(k<10 and k>=0) return 1;
    ll minn=LLONG_MAX;
    for(char c: to_string(k)){
        if(c=='0') continue;
        minn=min(minn,1+f(k-(c-'0')));
    }
    return minn;
}
```

# Greedy solution

```cpp
void solve() {  
    iinp(n);
    ll ans=0;
    while(n!=0){
        ll maxx=0;
        for(char c: to_string(n)){
            maxx=max(maxx,(ll)c-'0');
        }
        n-=maxx;
        ans++;
    }
    pri(ans);
}
```
