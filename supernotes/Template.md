```cpp
dsu d(n);
```

```cpp
class dsu{
public: 
      vector<int> par,size;
      int components;
      dsu(int n){
          for(int i=0;i<n;i++){
              par.push_back(i);
              size.push_back(1);
          }
        components=par.size();
      }
    
    int find(int node){
        if(par[node]==node) return node;
        return par[node]=find(par[node]);
    }

    void union_(int i, int j){
        if(find(i)==find(j)) return;
        int rooti=find(i),rootj=find(j);
        int sizei=size[rooti],sizej=size[rootj];
        if(size[rooti]<size[rootj]) swap(rooti,rootj);
        par[rootj]=rooti;
        size[rooti]+=size[rootj];
        components--;
    }
};
```
