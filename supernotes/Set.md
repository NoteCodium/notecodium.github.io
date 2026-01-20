[Implementing Dijkstra Algorithm | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/0)

vvl al

node number => nodes it is connected to, weight

```cpp
vector <int> dijkstra(int n, vector<vector<int>> al[], int src)
{
    vector<int> dis(n,INT_MAX);
    vector<bool>vis(n,false);
    set<pair<int,int>> se;
    se.insert({0,src});
    dis[src]=0;
    while(!se.empty())
    {
        auto p=*se.begin();
        int u=p.second;
        se.erase(se.begin());
        if(vis[u]) continue;
        vis[u]=true;
        for(auto p: al[u])
        {
            int v=p[0];
            int wt=p[1];
            if(dis[u]+wt<dis[v])
            {
                dis[v]=dis[u]+wt;
                se.insert({dis[v],v});
            }
        }
    }
    return dis;
}
```