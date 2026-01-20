```cpp
int ans=0;
vector<int> vis(n,0);
for(int i=0;i<n;i++){
    if(vis[i]) continue;
    ans++;
    dfs(i,al,vis);
}
```

```cpp
void dfs(int node, vector<int> al[], vector<int> &visited){
    visited[node]=1;
    for(int i=0;i<al[node].size();i++){
        if(visited[al[node][i]]) continue;
        dfs(al[node][i],al,visited);
    }
}
```
