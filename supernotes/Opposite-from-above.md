[As Far from Land as Possible - LeetCode](https://leetcode.com/problems/as-far-from-land-as-possible/)

# Incomplete
{% raw %}
```cpp
class Solution {
public:

bool isValid(int r, int c , int rr, int cc){
    return r>=0 and r<rr and c>=0 and c<cc;	
}

void bfs(vector<vector<int>>& ma)
{

    int cnt1=0,cnt2=0;
    int rr=ma.size(),cc=ma[0].size();
    queue<vector<int>> q;
    for(int r=0;r<rr;r++){ 
        for(int c=0;c<cc;c++){ 
            if(ma[r][c]==1){
                q.push({r,c,0});
                cnt1++;    
            } 
            else{
                ma[r][c]=-1;
                cnt2++;
            }    
        } 
    } 
    if(cnt1==rr*cc or cnt2==rr*cc) return -1;
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

    int maxDistance(vector<vector<int>>& ma) {
//water cell such that its distance to the nearest land cell is maximized    
//maximum value of min distance between 0 and 1 
        ma=updateMatrix(ma);
        int rr=ma.size(),cc=ma[0].size();
        int ans=-1,cnt1=0,cnt2=0;
        for(int r=0;r<rr;r++){
            for(int c=0;c<cc;c++){
                ans=max(ans,ma[r][c]);
                if(ma[r][c]==1) cnt1++;
                if(ma[r][c]==0) cnt2++;
            }
        }
        return ans;
    }
};
```
{% endraw %}