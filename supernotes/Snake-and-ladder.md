[Snake and Ladder Problem | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1?page=1&category%5B%5D=BFS&query=page1category%5B%5DBFS)

```cpp
int minThrow(int n, int v[]){
    vector<int> conn(31,-1);
    for(int i=0;i<2*n;i+=2) conn[v[i]]=v[i+1];
    vector<int> vis(31,0);
    queue<vector<int>> q;
    q.push({1,0});
    vis[1]=1;
    while(!q.empty()){
        auto x=q.front();q.pop();
        int curr=x[0],steps=x[1];
        if(curr==30) return steps;
        for(int i=curr+1;i<=curr+6;i++){
            if(i>30) break;
            if(vis[i]) continue;
            vis[i]=1;
            if(conn[i]==-1) q.push({i,steps+1});
            else q.push({conn[i],steps+1});
        }
    }
    return -1;
}
```
