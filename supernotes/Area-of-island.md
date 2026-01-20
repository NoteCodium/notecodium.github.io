1. Max area island 
=> Tip: if any island area exceed m*n//2, this is your answer
[Max Area of Island - LeetCode](https://leetcode.com/problems/max-area-of-island/description/)

{% raw %}
```cpp
bool isValid(int r, int c, int rr, int cc){
    return r>=0 and r<rr and c>=0 and c<cc;
}


void getArea(int r, int c, vector<vector<int>>& ma, int &ans,int rr, int cc, vector<pair<int,int>> &directions){
    if(!ma[r][c]) return;
    ma[r][c]=0;
    ans++;
    for(int i=0;i<directions.size();i++){
        int tr=r+directions[i].first,tc=c+directions[i].second;
        if(!isValid(tr,tc,rr,cc)) continue;
        getArea(tr,tc,ma,ans,rr,cc,directions);
    }
}

int maxAreaOfIsland(vector<vector<int>>& ma) {
    vector<pair<int,int>> directions={{0,-1},{0,1},{-1,0},{1,0}};
    int maxx=0;
    int rr=ma.size(),cc=ma[0].size();
    for(int i=0;i<rr;i++){
        for(int j=0;j<cc;j++) if(ma[i][j]==1){
            int ans=0;
            getArea(i,j,ma,ans,rr,cc,directions);
            if(ans>=(rr*cc)/2) return ans;
            maxx=max(maxx,ans);
        } 
    }
    return maxx;


}
```
{% endraw %}
