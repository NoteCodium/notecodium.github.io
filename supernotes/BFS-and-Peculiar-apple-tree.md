[Problem - 930A - Codeforces](https://codeforces.com/problemset/problem/930/A)


[Peculiar apple-tree | Viraj - YouTube](https://youtu.be/tVmnA0KWqP8?si=oMmcQEIcajvrpoVi)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/943f2f3c-401d-43e6-9dfc-276c7e80f003--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7ac9dc09-5205-429a-a61f-c2ccba34be8c--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0ecea2d7-3b9c-4a5a-bb42-0481e03850ba--image.png)

-----------------------------------------------------------------------------------------------




------------------------------------------------------------------------------------------------------
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0fd67943-22ca-465f-88d7-29080ba98a41--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1e5fbd22-2650-4eea-8285-cfb51a841321--image.png)

Count no of nodes in each level
```cpp
void solve(){
    iinp(n);
    vvl al(n,vl());
    for(ll i=1;i<n;i++){
        iinp(u);
        u--;
        al[u].push_back(i);
        al[i].push_back(u);
    }
    // _pri(al);
    ll ans=0;
    ll prevLevel=0;
    queue<vl> q;
    q.push({0,0});
    ll cnt=0;
    vl vis(n,0);
    vis[0]=1;
    while(!q.empty()){
        ll top=q.front()[0],currLevel=q.front()[1];q.pop();
        vis[top]=1;
        if(currLevel>prevLevel){
            prevLevel=currLevel;
            ans+=cnt%2;
            cnt=0;
        }
        cnt++;
        for(ll nei: al[top]){
            if(vis[nei]) continue;
            q.push({nei,currLevel+1});
        }
    }
    ans+=cnt%2;
    pri(ans);
}
```
