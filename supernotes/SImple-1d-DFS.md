```cpp
void dfs(int node, int vis[], vector<int> &al){
  if(vis[node]) return;
  vis[node]=1;
  for(int x: al[node]) dfs(x);
}
```


# 2D DFS on the fly
```cpp
void dfs(int r, int c, vector<vector<int>> &vis){
  if(!isValid(r,c)) return;
  if(vis[r][c]) return;
  vis[r][c]=1;
  for(int v: dir) dfs(r+v[0],c+v[1]);
}
```
