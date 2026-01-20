```cpp
class dsu {
public:
    vector<int> par;
    dsu(int n) 
    {
        for(int i=0;i<n;i++) par.push_back(i); 
    }
    void union_(int i, int j) 
    {
        par[find(i)] = find(j);
    }
    int find(int i) 
    {
        if(par[node]==node) return node;
        return par[node]=find(par[node]);
    }
    void reset(int i) 
    { 
        par[i] = i; 
    }
};

```
