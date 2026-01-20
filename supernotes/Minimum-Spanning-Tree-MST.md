1. Connecting n nodes by n-1 edges such that the cost is minimum
# Kruskal
1. sort all the edges by their weights
2. keep unionining

![image.png](https://supernotes-resources.s3.amazonaws.com/profile-photos/7d02518f-343a-4a91-ad8f-bf9f4165d5b7--image.png)
[Minimum Spanning Tree | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)

#IO GFG
```cpp
//vector<vector<int>> al[]
vector<vector<int>> edges;
for(int i=0;i<n;i++)
{
    for(auto v: al[i])
    {
        edges.push_back({v[1],v[0],i});
    }
}
sort(edges.begin(),edges.end());
dsu d(n);
int ans=0;
for(auto edge: edges)
{
    int wt=edge[0];
    int u=edge[1];
    int v=edge[2];
    if(!d.sameRoot(u,v))
    {
        ans+=wt;
        d.union_(u,v);
    }
    
}
```


```cpp
class dsu{
public: 
      vector<int> par,size;
      dsu(int n)
      {
          for(int i=0;i<n;i++)
          {
              par.push_back(i);
              size.push_back(1);
          }
      }
    
    int find(int node){
        if(par[node]==node) return node;
        return par[node]=find(par[node]);
    }
    
    bool sameRoot(int i, int j){
        return find(i)==find(j);
    }
    
    void union_(int i, int j){
        if(sameRoot(i,j)) return;
        int rooti=find(i),rootj=find(j);
        int sizei=size[rooti],sizej=size[rootj];
        if(size[rooti]<size[rootj]) swap(rooti,rootj);
        par[rootj]=rooti;
        size[rooti]+=size[rootj];
    }
    
  
};



int spanningTree(int n, vector<vector<int>> al[])
{   
    vector<vector<int>> edges;
    for(int i=0;i<n;i++)
    {
        for(auto v: al[i])
        {
            edges.push_back({v[1],v[0],i});
        }
    }
    sort(edges.begin(),edges.end());
    dsu d(n);
    int ans=0;
    for(auto edge: edges)
    {
        int wt=edge[0];
        int u=edge[1];
        int v=edge[2];
        if(!d.sameRoot(u,v))
        {
            ans+=wt;
            d.union_(u,v);
        }
        
    }
    
    return ans;
}
```
