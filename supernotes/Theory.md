# Union by rank
[Union-Find | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/union-find/1)

```cpp
int find(int par[],int node){
    if(par[node]==node) return node;
    return par[node]=find(par,par[node]);
    //path compression
    //due to which the O(n) things almost become a constatnt time operation O(4alpha)
}

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


bool isConnected(int u,int v, int par[], int rank[]){
    int ru=find(par,u), rv=find(par,v);
    return ru==rv;
}
```
