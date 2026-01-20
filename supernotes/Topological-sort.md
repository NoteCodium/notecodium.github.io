1. directed
2. acyclic

(DA)

```cpp
vector<int> topo(vector<int> al[], int n){   
    vector<int> ans;
    //finding the indegegree of all the nodes
    vector<int> ind(n,0);
    for(int i=0;i<n;i++){
        for(int j=0;j<al[i].size();j++){
            ind[al[i][j]]++;
        }
    }

    queue<int> q;
    // doing the first insertion in the queue
    for(int i=0;i<n;i++){
        if(ind[i]==0) q.push(i);
    }

    while(!q.empty()){
        int x=q.front();q.pop();
        ans.push_back(x);
        for(int i=0;i<al[x].size();i++){
            ind[al[x][i]]--;
            if(ind[al[x][i]]==0) q.push(al[x][i]);
        }
    }  
    return ans;
}
```
# Cycle detection with topological sort
1. If we run topological sort on a cyclic graph, Then the number of vertices that we will receive in answer vector will be less then the number of total vertices


# Eventual safe state
[Find Eventual Safe States - LeetCode](https://leetcode.com/problems/find-eventual-safe-states/description/)


--------------------------------------------------------------------------------------------------------------------

```
// terminal node if there are no outgoing edges
//safe node if every possible path starting from that node leads to a terminal node or another safe node
//return safe nodes

//all terminal nodes will be safe node
```

=> The question is, how do we efficiently traverse from terminal nodes to nodes that only have outgoing edges to terminal nodes? We can reverse the edges of the graph to create a new graph with reversed edges. After we have visited all of the terminal nodes, we can use this new graph to go to the nodes that have edges to the terminal nodes in the original graph by using the reverse edges that we added.

=>  by reversing the edges, a node only having incoming nodes (terminal nodes) will become a node with only outgoing edge (this is the starting point of topological sort)

1. reverse the edges
2. run topological sort


