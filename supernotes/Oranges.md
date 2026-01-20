[Rotting Oranges - LeetCode](https://leetcode.com/problems/rotting-oranges/description/)

2=> rotten
0=> empty
1=> fresh

1. Every minute fresh orange next to rotten orange got rotten
2. Maintai cnt of fresh oranges and finally the became 0 or not

{% raw %}
```cpp
bool isValid(ll r, ll c , ll rr, ll cc){
	return r>=0 and r<rr and c>=0 and c<cc;	
}

int orangesRotting(vector<vector<int>>& ma) {
    vector<vector<int>> directions={{0,-1},{0,1},{-1,0},{1,0}};
    queue <vector<int>> q;
    int cnt=0;
    //maintaining cnt of fresh oranges
    int rr=ma.size(),cc=ma[0].size();
    for(int r=0;r<rr;r++){
        for(int c=0;c<cc;c++){
            if(ma[r][c]==2) q.push({r,c,0});
            if(ma[r][c]==1) cnt++;
        }
    }
    if(cnt==0) return 0;
    int ans=-1;
    while(!q.empty()){
            auto v=q.front();q.pop();
            int r=v[0],c=v[1],t=v[2];
            ans=max(ans,t);
            for(auto dir: directions){
                int tr=r+dir[0],tc=c+dir[1];
                if(!isValid(tr,tc,rr,cc)) continue;
                if(ma[tr][tc]==0) continue;
                if(ma[tr][tc]==1){
                    ma[tr][tc]=2;
                    q.push({tr,tc,t+1});
                    cnt--;
                }
            }
        
        }
    return cnt==0?ans:-1;
}
```
{% endraw %}
