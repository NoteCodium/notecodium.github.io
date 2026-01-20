
`std::set` requires the comparator to accept const references.


```cpp
struct cmp{
    bool operator()(const vl &a,const vl &b)const{
        if(a[0]!=b[0]) return a[0]>b[0];
        return a[1]<b[1];
    }
};



set<vector<ll>,cmp> se;
```

```cpp
auto cmp=[](const vl &a,const vl &b){
        if(a[0]!=b[0]) return a[0]>b[0];
        return a[1]<b[1];
    };


set<vector<ll>,decltype(cmp)> se(cmp);
```

