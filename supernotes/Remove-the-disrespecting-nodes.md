[Problem - 1143C - Codeforces](https://codeforces.com/problemset/problem/1143/C)

[youtu.be](https://youtu.be/rE6w_PoGK4I?si=s8BM3sevBrthzE_4)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/bd65965e-37ed-4552-894c-485c09153d9c--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f7637402-6707-422b-9716-a937b84a8253--image.png)



![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/40a1797f-173d-4f76-9533-fb4d4f50b31c--image.png)

```cpp
void dfs(ll node, vvl &al, vl &final, ll par, vector<bool> &res){
    bool ans=res[node];
    for(ll nei: al[node]){
        if(nei==par) continue;
        ans=ans and res[nei];
        dfs(nei,al,final,node,res);
    }
    final[node]=ans; 
}
 
void solve(){
    iinp(n);
    vvl al(n,vl());
    vector<bool> res(n,0);
    ll root;
    for(ll i=0;i<n;i++){
        iinp(u);
        u--;
        iinp(re);
        res[i]=re;
        if(u==-2){
            root=i;
            continue;
        }
        al[u].push_back(i);
        al[i].push_back(u);
    }
 
    // _pri(al);
    // _pri(res);
    vl final(n);
    final[0]=0;
    dfs(root,al,final,-1,res);
    bool flag=0;
    for(ll i=0;i<n;i++){
        if(final[i]){
            flag=1;
            cout<<i+1<<" ";
        } 
    }
    if(!flag) cout<<-1;
    cout<<endl;
}
```
