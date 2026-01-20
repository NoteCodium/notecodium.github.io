[Problem - 580C - Codeforces](https://codeforces.com/problemset/problem/580/C)
The park is a rooted tree consisting of *n* vertices with the root at vertex 1. Vertex 1 also contains Kefa's house. Unfortunaely for our hero, the park also contains cats. Kefa has already found out what are the vertices with cats in them.

The leaf vertices of the park contain restaurants. Kefa wants to choose a restaurant where he will go, but unfortunately he is very afraid of cats, so there is no way he will go to the restaurant if the path from the restaurant to his house contains more than *m* consecutive vertices with cats.

Your task is to help Kefa count the number of restaurants where he can go.
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2cf34def-9fba-46df-86c3-92b0467956f0--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/147e52a0-5964-4b5f-96ac-def75840644a--image.png)



```cpp
void dfs(ll node, ll parent, ll maxCats, vl &cats, ll catsEncountered, vvl &al, ll &ans, vl &noOfNei ){
    if(catsEncountered>maxCats) return;
    if(noOfNei[node]==1 and parent !=-2){
        ans++;  
        return; 
    } 
    for(ll neighbour: al[node]) if(neighbour!=parent){
        if(cats[neighbour]) dfs(neighbour,node,maxCats,cats,catsEncountered+1,al,ans,noOfNei);
        else dfs(neighbour,node,maxCats,cats,0,al,ans,noOfNei);    
    } 
}
 
void solve(){   
    iinp(n);
    iinp(m);
    vinp(cats,n);
    vvl al(n,vl());
    for(ll i=1;i<n;i++){
        ll u,v;
        inp(u,v);
        u--,v--;
        al[u].push_back(v);
        al[v].push_back(u);
    }
 
    vl noOfNei(n);
    for(ll i=0;i<n;i++){
        noOfNei[i]=al[i].size();
    }
 
    // _pri(al);
    // _pri(noOfNei);
 
    ll ans=0;
    dfs(0,-2,m,cats,cats[0],al,ans, noOfNei);
    pri(ans);
    
}
```
