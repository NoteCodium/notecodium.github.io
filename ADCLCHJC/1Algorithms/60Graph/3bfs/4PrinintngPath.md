![image.png](4PrinintngPath_images/image.png)


https://cses.fi/problemset/task/1193


```python
void bfs(ll ix, ll iy, ll fx, ll fy, vector<vector<char>> &ma, ll rr, ll cc){
    {% raw %}
    vector<pair<vector<ll>, char>> dir= {{{1,0},'D'},{{-1,0},'U'},{{0,1},'R'},{{0,-1},'L'}};
    {% endraw %}
    queue<vector<ll>> q;
    q.push({ix,iy});
    ma[ix][iy]='#';
    bool flag=0;
    while(!flag and q.size()){
        auto v=q.front();
        q.pop();
        for(auto p:dir){
            ll tr=v[0]+p.first[0],tc=v[1]+p.first[1];
            if(!isValid(tr,tc,rr,cc) or (ma[tr][tc]!='.' or ma[tr][tc]=='B')){
                continue;      
            } 
            ma[tr][tc]=p.second;
            if(tr==fx and tc==fy){
                flag=1;
                break;
            }
            q.push({tr,tc});
        }
    }
    if(!flag){
        pri("NO");
        return;
    }
    pri("YES");
    string ans;
    ll x=fx,y=fy;
    while(!((x==ix) and (y==iy))){
        ans.push_back(ma[x][y]);
        switch (ma[x][y]) {
            case 'U':
            x++;
            break;
            case 'D':
            x--;
            break;
            case 'R':
            y--;
            break;
            case 'L':
            y++;
            break;
        }
    }  
    reverse(it(ans));
    pri(ans.size());
    pri(ans);
 
}

    void solve() {
        ll rr,cc;
        inp(rr,cc);     
        vector<vector<char>> ma(rr,vector<char> (cc));
        ll ix,iy,fx,fy;
        for(int r=0;r<rr;r++){
            for(int c=0;c<cc;c++){
                cin>>ma[r][c];
                if(ma[r][c]=='A'){
                    ix=r;
                    iy=c;
                }
                if(ma[r][c]=='B'){
                    ma[r][c]='.';
                    fx=r;
                    fy=c;
                }
            }
        }
        bfs(ix,iy,fx,fy,ma,rr,cc);
    }
```
