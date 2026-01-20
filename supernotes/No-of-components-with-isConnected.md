
[Number of Provinces - LeetCode](https://leetcode.com/problems/number-of-provinces/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/43f561d8-cd8b-4f9c-96b6-3a75617f0daa--image.png)

```cpp
void dfs(int node, vector<int> al[], vector<int> &visited){
    visited[node]=1;
    for(int i=0;i<al[node].size();i++){
        if(visited[al[node][i]]) continue;
        dfs(al[node][i],al,visited);
    }
}


int findCircleNum(vector<vector<int>>& ma) {
    int n= ma.size();
    vector<int> al[n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(ma[i][j]==1 and i!=j){
                al[i].push_back(j);
                al[j].push_back(i);
            }
        }
    }

    vector<int> vis(n,0);
    int ans=0;
    for(int i=0;i<n;i++){
        if(vis[i]) continue;
        ans++;
        dfs(i,al,vis);
    }
    return ans; 
}
```
