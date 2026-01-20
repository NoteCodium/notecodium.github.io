[leetcode.com](https://leetcode.com/problems/island-perimeter/description/)


{% raw %}
```cpp

    bool isValid(int r, int c, int rr, int cc){
        return r>=0 and r<rr and c>=0 and c<cc;
    }

    void dfs(int r, int c, vector<vector<int>>& ma, int &ans){
        int rr=ma.size(),cc=ma[0].size();
        vector<pair<int,int>> directions={{0,-1},{0,1},{-1,0},{1,0}};
        ma[r][c]=-1;
        for(int i=0;i<directions.size();i++){
            int tr=r+directions[i].first,tc=c+directions[i].second;
            if(!isValid(tr,tc,rr,cc) or ma[tr][tc]==0){
                ans++;
                continue;
            } 
            if(ma[tr][tc]==-1) continue;
            dfs(tr,tc,ma,ans);
        }
    }

    int islandPerimeter(vector<vector<int>>& ma) {
        int ans=0;
        for(int i=0;i<ma.size();i++){
            for(int j=0;j<ma[0].size();j++) if(ma[i][j]==1) dfs(i,j,ma,ans);
        }
        return ans;
    }
```
{% endraw %}
