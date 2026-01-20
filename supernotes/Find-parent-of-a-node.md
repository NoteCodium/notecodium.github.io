```cpp
int find(int node){
    if(par[node]==node) return node;
    return par[node]=find(par[node]);
}
```