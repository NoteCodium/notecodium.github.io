---
title: 2WithAl
---

{% raw %}
Distance from src node to each node in an undirected graph   
https://www.naukri.com/code360/problems/single-source-shortest-path_8416371?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

```python
void bfs(int src, vector<vector<int>> &al, vector<int> &ans){
    int n=al.size();
    vector<bool> vis(n,0);
    queue<vector<int>> q;
    q.push({src,0});
    vis[src]=1;
    while(q.size()){
        auto v=q.front(); 
        q.pop();
        int d=v[1],x=v[0];
        ans[x]=d;
        for(int y: al[x]){
            if(vis[y]){
                continue;
            } 
            vis[y]=1;
            q.push({y,d+1});
        }
    }
}
vector<int> shortestPath(int n, vector<vector<int>>&edges, int src) {
    vector<vector<int>> al(n);
    for(auto e: edges){
        al[e[0]].push_back(e[1]);
        al[e[1]].push_back(e[0]);
    }
    vector<int> ans(n,-1);
    bfs(src,al,ans);
    return ans;
}
```
{% endraw %}
