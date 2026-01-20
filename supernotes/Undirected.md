[Detect cycle in an undirected graph | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1)

https://youtu.be/zQ3zgFypzX4?si=pXhwqqg82b94lVS_

1. Undirected can be made directed

# DFS
```cpp
bool dfs(int node, int par, vector<int> &vis, vector<int> al[]){
    vis[node]=1;
    for(int nei: al[node]){
        if(!vis[nei]){
            if(dfs(nei,node,vis,al)==1) return 1;
        } 
        else if(nei!=par) return 1;
    }
    return 0;
}

bool isCycle(int n, vector<int> al[]) {
    vector<int> vis(n,0);
    for(int i=0;i<n;i++){
        if(!vis[i]){
            if(dfs(i,-1,vis,al)==1) return 1;
        }
    }
    return 0;
}
```

