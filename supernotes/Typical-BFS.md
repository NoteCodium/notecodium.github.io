[leetcode.com](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
![image.png](https://supernotes-resources.s3.amazonaws.com/profile-photos/b5c36484-4d78-4fb4-bbf9-7577c3cde8de--image.png)



{% raw %}
```cpp
bool isValid(ll r, ll c , ll rr, ll cc){
        return r>=0 and r<rr and c>=0 and c<cc;	
    }
    void bfs(vector<vector<int>>& grid, int &ans){
        int n=grid.size();
        int rr=n,cc=n;
        grid[0][0]=1;
        queue<vector<int>> q;
        q.push({0,0,1});
        vector<vector<int>> king={{1,0},{-1,0},{0,1},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1}};
        while(!q.empty()){
            auto v=q.front();q.pop();
            int r=v[0],c=v[1],d=v[2];
            if(r==n-1 and c==n-1){
                ans=v[2];
                break;
            }
            for(auto vv: king){
                int tr=r+vv[0],tc=c+vv[1];
                if(!isValid(tr,tc,rr,cc) or grid[tr][tc]) continue;
                grid[tr][tc]=1;
                q.push({tr,tc,d+1});
            }
        }   
    }   

    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if(grid[0][0]) return -1;
        int ans=-1;
        bfs(grid,ans);
        return ans;
    }
    
```
{% endraw %}


