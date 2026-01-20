[Unique Paths III - LeetCode](https://leetcode.com/problems/unique-paths-iii/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/69643564-812c-48fa-9408-25c1ad638ccb--image.png)



{% raw %}
```cpp
void f(vector<vector<int>>& ma, int &ans, int i, int j,int rr, int cc, vector<vector<ll>> &dir, int cnt){
    if(i<0 or i>=rr or j<0 or j>=cc or ma[i][j]==-1) return;
    if(ma[i][j]==2 and cnt==0){
        ans++;
        return;
    }
    if(ma[i][j]==2 or cnt==0) return;
    //moving forward
    cnt--;
    int orig = ma[i][j];
    ma[i][j]=-1;

    //new function call
    for(auto v:dir) f(ma,ans,i+v[0],j+v[1],rr,cc,dir,cnt);

    //backtracking
    ma[i][j]=orig;
    cnt++;
}

int uniquePathsIII(vector<vector<int>>& ma) {
    int ans=0,rr=ma.size(),cc=ma[0].size();
    int ii,ij;
    int cnt=1;
    for(int i=0;i<rr;i++)
        for(int j=0;j<cc;j++)
            {
                if(ma[i][j]==1)
                {
                    ii=i;
                    ij=j;
                }

                if(ma[i][j]==0) cnt++;
            }

    vector<vector<ll>> dir={{1,0},{-1,0},{0,1},{0,-1}};
    f(ma,ans,ii,ij,rr,cc,dir,cnt);
    return ans;
}
```
{% endraw %}