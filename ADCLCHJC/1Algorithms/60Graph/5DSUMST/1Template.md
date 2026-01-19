```python
//using it 
dsu d(n);
```

```python
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
            if(par[node]==node){
                return node;
            } 
            return par[node]=find(par[node]);
            //caching the values at the same time
        }
    
        void union_(int i, int j){
            int rooti=find(i),rootj=find(j);
            if(rooti==rootj){
                return;
            } 
            int sizei=size[rooti],sizej=size[rootj];
            if(size[rooti]<size[rootj]) swap(rooti,rootj);
            par[rootj]=rooti;
            size[rooti]+=size[rootj];
            components--;
        }
    };
```

//the gfg question regarding
union by size
union by rank


They attach the "smaller" tree under the "larger" one.

They work well with path compression, making all DSU operations nearly O(α(n)), where α is the inverse Ackermann function (extremely slow-growing, nearly constant for all practical purposes).


https://www.geeksforgeeks.org/problems/union-find/1    
union by rank    
Attach the tree with lower depth (rank) under the tree with higher depth.  


```python
void union_( int u, int v, int par[], int rank[]) {
    int rootU=find(par,u), rootV=find(par,v);
    if(rootU==rootV) return;
    int rankU=rank[u],rankV=rank[v];
    if(rankU>rankV){
      par[rootV]=rootU;
      rank[rootU]++;
    }
    else{
      par[rootU]=rootV;
      rank[rootV]++;
    }
}

```

```python
class dsu {
    public:
        vector<int> par;
        dsu(int n){
            for(int i=0;i<n;i++){
                par.push_back(i); 
            } 
        }
        void union_(int i, int j) {
            par[find(i)] = find(j);
            //skiping rank and size optimization
        }

        int find(int i) {
            if(par[node]==node){
                return node;
            } 
            return par[node]=find(par[node]);
        }

        void reset(int i) { 
            par[i] = i; 
        }
    };
    
```
