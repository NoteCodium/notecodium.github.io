[Flood Fill - LeetCode](https://leetcode.com/problems/flood-fill/description/)


{% raw %}
```cpp
bool isValid(ll r, ll c , ll rr, ll cc){
    return r>=0 and r<rr and c>=0 and c<cc;	
}

void dfs(int r, int c, vector<vector<int>>& ma, int rr, int cc, vector<vector<int>> &dir, int color, int initColor){
    if(ma[r][c]!=initColor) return;
    ma[r][c]=color;
    for(auto v: dir){
        int tr=r+v[0],tc=c+v[1];
        if(!isValid(tr,tc,rr,cc)) continue;
        dfs(tr,tc,ma,rr,cc,dir,color, initColor);
    }
}


vector<vector<int>> floodFill(vector<vector<int>>& ma, int ix, int iy, int color) {
    vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
    int rr=ma.size(),cc=ma[0].size();
    int initColor=ma[ix][iy];
    if(color!=initColor) dfs(ix,iy,ma,rr,cc,dir,color, initColor);
    return ma;
}   
```
{% endraw %}