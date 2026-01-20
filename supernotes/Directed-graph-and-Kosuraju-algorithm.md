present in ppa

1. for directed graphs only

subgraph in which there is a directed path from every vertex to every other vertex.

In simpler terms, a strongly connected component is a set of vertices within a directed graph where there is a directed path from any vertex in the set to any other vertex in the set

# Topological sort
# Strongly connected components
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b79d6bcc-ed77-47d9-a015-595ab1f67705--image.png)
[Strongly Connected Components (Kosaraju's Algo) | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?track=placement)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bdabde44-6594-43a8-8ea2-7a69d5430cdf--image.png)
1. reverse the edges
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0e4a4b1e-3ee9-4ebb-88f2-94a8de028ee7--image.png)

Now if we start the dfs at scc1, it will not go to other components

1. but that will happen as long as we are starting dfs at scc1 at 0

=> sort all the edges according to finishing 

=>reverse the graph

=> dfs 


[G-54. Strongly Connected Components - Kosaraju's Algorithm - YouTube](https://youtu.be/R6uoSjZ2imo)

```cpp
void dfs(int node, vector<int> &vis, vector<vector<int>>& al, stack<int> &st){
    vis[node]=1;
    for(int x:al[node]) if(!vis[x]) dfs(x,vis,al,st);
    st.push(node);
}

void dfs_(int node, vector<int> &vis, vector<vector<int>>& al){
    vis[node]=1;
    for(int x:al[node]) if(!vis[x]) dfs_(x,vis,al);
}    

public:
int kosaraju(int n, vector<vector<int>>& al){
    vector<int> vis(n,0);
    stack<int> st;
    for(int i=0;i<n;i++){
        if(!vis[i]) dfs(i,vis,al,st);
    }
    vector<vector<int>> alt(n);
    for(int i=0;i<n;i++){
        for(int x: al[i]){
            alt[x].push_back(i);
        }
    }
    
    vector<int> vis_(n,0);
    int ans=0;
    while(!st.empty()){
        int node=st.top();st.pop();
        if(!vis_[node]){
            ans++;
            dfs_(node,vis_,alt);
        }
    }
    
    return ans;
    
}
```
