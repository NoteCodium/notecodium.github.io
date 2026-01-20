[Rat in a Maze Problem - I | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/82e80555-6bbb-4dcb-914f-1351e9e88529--image.png)


{% raw %}
```cpp
void f(int r, int c, vector<string> &ans, string &tmp, vector<vector<int>> &ma, int &n, vector<pair<vector<int>,char>> &direc){
    if(r==n-1 and c==n-1){
        ans.push_back(tmp);
        return;
    }
    for(int i=0;i<direc.size();i++){
        int nextx=r+direc[i].first[0],nexty=c+direc[i].first[1];
        if(nextx>=n or nextx<0 or nexty>=n or nexty<0) continue;
        if(!ma[nextx][nexty]) continue;
        //move forward
        ma[nextx][nexty]=0;
        tmp.push_back(direc[i].second);

        //make next function call
        f(nextx,nexty,ans,tmp,ma,n,direc);

        //backtrack
        tmp.pop_back();
        ma[nextx][nexty]=1;
    }
}


vector<string> findPath(vector<vector<int>> &ma, int n) {
    vector<string> ans;
    string tmp;
    vector<pair<vector<int>,char>> direc={{{1,0},'D'},{{-1,0},'U'},{{0,1},'R'},{{0,-1},'L'}};
    if(ma[0][0]){
        ma[0][0]=0;
        f(0,0,ans,tmp,ma,n,direc);
    }   
    return ans;
}
```
{% endraw %}








