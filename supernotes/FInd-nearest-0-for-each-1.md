[leetcode.com](https://leetcode.com/problems/01-matrix/)
1. Replace 1 with its nearest distance to 0
2. Do. BFS from each 0, even some 0 are blocked it will not effect
{% raw %}
```cpp
class Solution { 
public: 
    bool isValid(int r, int c , int rr, int cc)
    {
        return r>=0 and r<rr and c>=0 and c<cc;	
    }

    void bfs(vector<vector<int>>& ma)
    {
        int rr=ma.size(),cc=ma[0].size();
        queue<vector<int>> q;
        for(int r=0;r<rr;r++)
        { 
            for(int c=0;c<cc;c++)
            { 
                if(ma[r][c]==0) q.push({r,c,0});    
                else ma[r][c]=-1;
            } 
        } 
        vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
            while(!q.empty())
            {
                auto v=q.front();q.pop();
                int r=v[0],c=v[1],d=v[2];
                for(auto vv:dir)
                {
                    int tr=r+vv[0],tc=c+vv[1];
                    if(!isValid(tr,tc,rr,cc)) continue;
                    if(ma[tr][tc]>=0) continue; 
                    ma[tr][tc]=1+d;
                    q.push({tr,tc,1+d});
                }        
            }   
        } 

        vector<vector<int>> updateMatrix(vector<vector<int>>& ma) 
        { 
            bfs(ma);  
            return ma; 
        } 
};
```
{% endraw %}



    