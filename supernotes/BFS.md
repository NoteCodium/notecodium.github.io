```cpp
void bfs(int src){
    vector<bool> vis(n,0);
	queue<int> q;
	q.push(src);
	vis[src]=1;
	while(!q.empty()){
		int x=q.front(); q.pop();
		for(int y: al[x]){
			if(vis[y]) continue;
			vis[y]=1;
			q.push(y);
		}
	}
}
```
