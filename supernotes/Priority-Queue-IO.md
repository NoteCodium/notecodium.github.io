[Coding Ninjas Studio](https://www.codingninjas.com/studio/problems/dijkstra's-shortest-path_985358?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0)

```cpp
vector <int> dijkstra(int n, vector<vector<int>> al[], int src){
    vector<int> dis(n,INT_MAX);
    priority_queue<vector<int>> pq;
    dis[src]=0;
    pq.push({0,src});
    while(!pq.empty()){
        int d=-pq.top()[0];
        int node=pq.top()[1];
        pq.pop();
        for(auto v: al[node]){
            int ewei=v[1];
            int adjNode=v[0];
            if(d+ewei<dis[adjNode]){
                dis[adjNode]=d+ewei;
                pq.push({-dis[adjNode],adjNode});
            }
        }
        
    }
    
    return dis;
}

vector<int> dijkstra(vector<vector<int>> &edges, int n, int en, int src){
    vector<vector<int>> al[n];
    for(auto e: edges){
        al[e[0]].push_back({e[1],e[2]});
        al[e[1]].push_back({e[0],e[2]});
    }
    return dijkstra(n, al,src);

}
```

[Coding Ninjas Studio](https://www.codingninjas.com/studio/problems/shortest-path-in-dag_8381897?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1)


```cpp
vector <int> dijkstra(int n, vector<vector<int>> al[], int src){
    vector<int> dis(n,INT_MAX);
    priority_queue<vector<int>> pq;
    dis[src]=0;
    pq.push({0,src});
    while(!pq.empty()){
        int d=-pq.top()[0];
        int node=pq.top()[1];
        pq.pop();
        for(auto v: al[node]){
            int ewei=v[1];
            int adjNode=v[0];
            if(d+ewei<dis[adjNode]){
                dis[adjNode]=d+ewei;
                pq.push({-dis[adjNode],adjNode});
            }
        }
        
    }
    for(int &x: dis) if(x==INT_MAX) x=-1;
    return dis;
}


vector<int> shortestPathInDAG(int n, int ne, vector<vector<int>> &edges){
    vector<vector<int>> al[n];
    for(auto e: edges){
        al[e[0]].push_back({e[1],e[2]});
    }
    return dijkstra(n, al,0);
}

```
