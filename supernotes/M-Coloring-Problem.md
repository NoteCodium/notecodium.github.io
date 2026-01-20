[M-Coloring Problem | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#)

1. Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color.

# Due to adjacenecy matrix our solving changes


```cpp
bool isPossible(int idx, int col, bool graph[101][101], int n, vector<int> &colors){
    for(int i=0;i<n;i++){
        if(graph[idx][i]){
            if(col==colors[i]) return 0;
        }
    }
    return 1;
}


bool dfs(int idx, bool graph[101][101], int noOfColor, int n, vector<int> &colors){
    if(idx>=n) return 1;
    for(int col=1;col<=noOfColor;col++){
        if(isPossible(idx,col,graph,n,colors)){
            colors[idx]=col;
            if(dfs(idx+1,graph,noOfColor,n,colors)) return 1;
            else colors[idx]=0;
        }
    }
    return 0;
}


bool graphColoring(bool graph[101][101], int noOfColor, int n) {
    if(noOfColor>=n) return 1;
    vector<int> colors(n,0);
    if(dfs(0,graph,noOfColor,n,colors)==1) return 1;
    return 0;
}
```