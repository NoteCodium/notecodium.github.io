[leetcode.com](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/)

[youtu.be](https://youtu.be/beOCN7G4h-M?si=3ceV7luuPkQDPG7B)

```cpp
class dsu{
public: 
    unordered_map<int,int> par;
    int count;
    dsu(vector<vector<int>>& ma)
    {
        for(int i=0;i<ma.size();i++)
        {
            int r=ma[i][0],c=ma[i][1]; 
            par[r+1]=r+1;
            par[-(c+1)]=-(c+1);
        }
        count=par.size();
    }
    
    int find(int i)
    {
      return par[i] == i ? i : (par[i] = find(par[i]));
    }
    
    void union_(int i, int j)
    {
        par[find(i)]=find(j);
        count--;
    }
    

};

int f(vector<vector<int>>& ma)
{
    int n=ma.size();
    dsu d(ma);
    for(int i=0;i<n;i++) d.union_((ma[i][0]+1),-(ma[i][1]+1));
    return d.count;
}

int removeStones(vector<vector<int>>& stones) {
    return stones.size()-f(stones);
}
```
