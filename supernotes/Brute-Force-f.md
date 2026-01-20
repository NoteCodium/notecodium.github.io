```cpp
class dsu{
public:
    int cnt;  
    vector<int> par,size;
    dsu(int n)
    {
        cnt=n;
        for(int i=0;i<n;i++)
        {
            par.push_back(i);
            size.push_back(1);
        }
    }

int find(int node){
    if(par[node]==node) return node;
    return par[node]=find(par[node]);
}

bool sameRoot(int i, int j){
    return find(i)==find(j);
}

void union_(int i, int j){
    if(sameRoot(i,j)) return;
    cnt--;
    int rooti=find(i),rootj=find(j);
    int sizei=size[rooti],sizej=size[rootj];
    if(size[rooti]<size[rootj]) swap(rooti,rootj);
    par[rootj]=rooti;
    size[rooti]+=size[rootj];
}


};

int f(vector<vector<int>>& ma){
    int n=ma.size();
    dsu d(n);
    for(int i=0;i<n;i++) for(int j=i+1;j<n;j++)
    {
        if(ma[i][0]==ma[j][0] or ma[i][1]==ma[j][1]) d.union_(i,j);

    }
    return d.cnt;
}

```