[leetcode.com](https://leetcode.com/problems/word-search/description/)

![image.png](../images/074f297e-8eae-440a-abaa-ddf9394da1c7--image.png)


```cpp
bool dfs(vector<vector<char>>& ma, string &word, int idx, int r, int c, int rr, int cc){
    if(idx==word.size()) return 1;
    if((r<0 or r>=rr or c<0 or c>=cc)) return 0;
    if(ma[r][c]!=word[idx]) return 0;
    char tmp=ma[r][c];
    ma[r][c]='#';
    if(dfs(ma,word,idx+1,r+1,c,rr,cc) or dfs(ma,word,idx+1,r-1,c,rr,cc) or dfs(ma,word,idx+1,r,c+1,rr,cc) or dfs(ma,word,idx+1,r,c-1,rr,cc)) return 1;
    ma[r][c]=tmp;
    return 0;
}


bool exist(vector<vector<char>>& ma, string word) {
    int rr=ma.size(),cc=ma[0].size();
    for(int i=0;i<rr;i++) for(int j=0;j<cc;j++) if(ma[i][j]==word[0]) if(dfs(ma,word,0,i,j,rr,cc)) return 1;
    return 0;
}
```



# This is slow
{% raw %}
```cpp
bool dfs(vector<vector<char>>& ma, string &word, int idx, int r, int c, int rr, int cc, vector<vector<int>> &dir){
    if(idx==word.size()) return 1;
    if((r<0 or r>=rr or c<0 or c>=cc)) return 0;
    if(ma[r][c]!=word[idx]) return 0;
    char tmp=ma[r][c];
    ma[r][c]='#';
    bool ans=0;
    for(auto v: dir) ans|=dfs(ma,word,idx+1,r+v[0],c+v[1],rr,cc,dir);
    if(ans) return 1;
    ma[r][c]=tmp;
    return 0;
}


bool exist(vector<vector<char>>& ma, string word) {
    int rr=ma.size(),cc=ma[0].size();
    vector<vector<int>> dir={{1,0},{-1,0},{0,1},{0,-1}};
    for(int i=0;i<rr;i++) for(int j=0;j<cc;j++) if(ma[i][j]==word[0]) if(dfs(ma,word,0,i,j,rr,cc,dir)) return 1;
    return 0;
}
```
{% endraw %}

# hence right like this

```cpp
class Solution {
public:

    bool dfs(vector<vector<char>>& ma, string &word, int idx, int r, int c, int rr, int cc){
        if(idx==word.size()) return 1;
        if((r<0 or r>=rr or c<0 or c>=cc)) return 0;
        if(ma[r][c]!=word[idx]) return 0;
        char tmp=ma[r][c];
        ma[r][c]='#';
        if(dfs(ma,word,idx+1,r+1,c,rr,cc) or dfs(ma,word,idx+1,r-1,c,rr,cc) or dfs(ma,word,idx+1,r,c+1,rr,cc) or dfs(ma,word,idx+1,r,c-1,rr,cc)) return 1;
        ma[r][c]=tmp;
        return 0;
    }


    bool exist(vector<vector<char>>& ma, string word) {
        int rr=ma.size(),cc=ma[0].size();
        for(int i=0;i<rr;i++) for(int j=0;j<cc;j++) if(ma[i][j]==word[0]) if(dfs(ma,word,0,i,j,rr,cc)) return 1;
        return 0;
    }
};
```