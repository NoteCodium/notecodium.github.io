An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

https://leetcode.com/problems/number-of-distinct-islands/description/
(premium problem)    

https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1   

https://www.youtube.com/watch?v=7zmgQSJghpo


```python
bool isValid(ll r, ll c , ll rr, ll cc){
    return r>=0 and r<rr and c>=0 and c<cc;	
}


void dfs(int i, int j, vector<vector<int>>& ma, vector<vector<int>> &dir, set<vector<pair<int,int>>> &se,
int ix, int iy, vector<pair<int,int>> &tmp,int rr, int cc){
  ma[i][j]=0;
  tmp.push_back({i-ix,j-iy});
  for(auto v: dir){
      int tr=i+v[0],tc=j+v[1];
      if(!isValid(tr,tc,rr,cc) or !ma[tr][tc]) continue;
      dfs(tr,tc,ma,dir,se,ix,iy,tmp,rr,cc);
  }
}


int countDistinctIslands(vector<vector<int>>& ma) {
    {% raw %}
    vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
    {% endraw %}
    set<vector<pair<int,int>>> se;
    int rr=ma.size(),cc=ma[0].size();
    for(int i=0;i<rr;i++){
        for(int j=0;j<cc;j++){
            if(ma[i][j]){
                vector<pair<int,int>> tmp;
                dfs(i,j,ma,dir,se,i,j,tmp,rr,cc); 
                se.insert(tmp);
            } 
        }
    }
    return se.size();
}
```

why it works    

![image.png](4NoOfIslandComplex_images/image.png)


# FAANG


https://leetcode.com/problems/number-of-distinct-islands-ii/description/   
Premium problem    

An island is considered to be the same as another if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).


![image.png](4NoOfIslandComplex_images/image.png)

