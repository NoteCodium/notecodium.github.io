[Number Of Islands | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands)

[G-51. Number of Islands - II - Online Queries - DSU - YouTube](https://youtu.be/Rn6B-Q4SNyA?si=u-RLs3BncibV72uD)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/442ae63c-0b39-40d8-9344-79a8b6da0387--image.png)

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

    vector<int> numOfIslands(int rr, int cc, vector<vector<int>> &queries) {
        dsu d(rr*cc);
        vector<vector<bool>> vis(rr,vector<bool>(cc,0));
        int cnt=0;
        vector<int> ans;
        vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(auto q: queries){
            int r=q[0],c=q[1];
            if(vis[r][c]){
                ans.push_back(cnt);
                continue;
            }
            vis[r][c]=1;
            cnt++;
            for(auto v:dir){
                int tr=r+v[0],tc=c+v[1];
                if(!isValid(tr,tc,rr,cc) or !vis[tr][tc]) continue;
                int node =r*cc+c,adNode=tr*cc+tc;
                if(d.find(node)!=d.find(adNode)){
                    cnt--;
                    d.union_(node,adNode);
                }
            }
            ans.push_back(cnt);            
        }
        return ans;
    }
};
```
{% endraw %}
