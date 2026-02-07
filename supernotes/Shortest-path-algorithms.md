

[leetcode.com](https://leetcode.com/problems/cheapest-flights-within-k-stops/description/)


![image.png](../images/bd9081ac-c5c4-4324-83f7-77d2b4d0f4be--image.png)

[G-38. Cheapest Flights Within K Stops - YouTube](https://youtu.be/9XybHVqTHcQ)

```cpp
int findCheapestPrice(int n, vector<vector<int>>& ma, int src, int des, int k) {
    vector<vector<int>> al[n];
    for(auto v: ma){
        al[v[0]].push_back({v[1],v[2]});
    }
    vector<int> dis(n,INT_MAX);
    queue<vector<int>> q;
    q.push({0,0,src});
    dis[src]=0;
    while(!q.empty()){
        auto v=q.front();
        int stops=v[0];
        int cost=v[1];
        int node=v[2];
        q.pop();
        if(stops>k) continue;
        for(auto vv: al[node]){
            int adjNode=vv[0];
            int eW=vv[1];
            if(cost+eW<dis[adjNode]){
                dis[adjNode]=cost+eW;
                q.push({stops+1,dis[adjNode],adjNode});
            }
        }
    }
    return dis[des]==INT_MAX?-1:dis[des];


}
```








```cpp
vector<int> edges;
for(int i=0;i<n;i++)
{
    for(auto v: al)
    {
        edges.push_back(v[1],v[0],i);
    }
}

```
