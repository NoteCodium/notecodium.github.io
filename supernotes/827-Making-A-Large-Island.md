[Making A Large Island - LeetCode](https://leetcode.com/problems/making-a-large-island/description/)

1. Not necessarly we connect two separate components, we can just +1 a component
[G-52. Making a Large Island - DSU - YouTube](https://youtu.be/lgiz0Oup6gM?si=kCm6EZ3DhDOhcopn)

1. Edge case when all matrix is 1

{% raw %}
```cpp
#define ll int
class Solution {
public:
    class dsu{
    public: 
        vector<int> par,size;
        int components;
        dsu(int n){
            for(int i=0;i<n;i++){
                par.push_back(i);
                size.push_back(1);
            }
            components=par.size();
        }
        
        int find(int node){
            if(par[node]==node) return node;
            return par[node]=find(par[node]);
        }

        void union_(int i, int j){
            if(find(i)==find(j)) return;
            int rooti=find(i),rootj=find(j);
            int sizei=size[rooti],sizej=size[rootj];
            if(size[rooti]<size[rootj]) swap(rooti,rootj);
            par[rootj]=rooti;
            size[rooti]+=size[rootj];
            components--;
        }
    };

    bool isValid(ll r, ll c , ll rr, ll cc){
        return r>=0 and r<rr and c>=0 and c<cc;	
    }

    int largestIsland(vector<vector<int>>& ma) {
        int rr=ma.size();
        dsu d(rr*rr);
        int cnt=0;
        vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};  
        for(int r=0;r<rr;r++){
            for(int c=0;c<rr;c++){
                if(ma[r][c]==1) cnt++;
                if(!ma[r][c]) continue;
                for(auto v: dir){
                    int tr=r+v[0],tc=c+v[1];
                    if(!isValid(tr,tc,rr,rr) or !ma[tr][tc]) continue;
                    int node=r*rr+c;
                    int adNode=tr*rr+tc;
                    if(d.find(node)==d.find(adNode)) continue;
                    d.union_(node,adNode); 
                }
            }
        }  
        if(cnt==rr*rr) return rr*rr;  
        
        int maxx=0;
        for(int r=0;r<rr;r++){
            for(int c=0;c<rr;c++){
                if(ma[r][c]==1) continue;
                unordered_set<int> se;
                for(auto v: dir){
                    int tr=r+v[0],tc=c+v[1];
                    if(!isValid(tr,tc,rr,rr) or !ma[tr][tc]) continue;
                    int node=r*rr+c;
                    int adNode=tr*rr+tc;
                    se.insert(d.find(adNode));
                }
                int sizeTotal=1;
                for(auto x: se){
                    sizeTotal+=d.size[x];
                }
                maxx=max(maxx,sizeTotal);                
            }
        } 
        return maxx;
    }
};
```
{% endraw %}
