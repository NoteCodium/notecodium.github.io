[Problem - 981C - Codeforces](https://codeforces.com/problemset/problem/981/C)

[Useful Decomposition | Viraj - YouTube](https://youtu.be/PnMB-o9B0eM?si=jMwUgE11XnXJGxcM)


![image.png](../images/b96213ca-09e9-4320-9e2d-d39dab35b169--image.png)

![image.png](../images/3b48c833-bb83-49d6-a1a0-c412eae1e509--image.png)





-----
![image.png](../images/bb9a9750-e249-42fe-8d82-e5aa784b8dd8--image.png)

![image.png](../images/42299238-84e4-4498-9e3a-4f7a621ccf74--image.png)

![image.png](../images/743143f3-bfc6-4fa9-b9ae-40c62c924acf--image.png)

![image.png](../images/7a72c09a-253a-4006-9e36-7d452b6bac0b--image.png)







----------

![image.png](../images/fba98f69-45b9-40f8-8fd5-f7129902e9d2--image.png)


![image.png](../images/b448c12a-a23f-46b1-bb5d-923dc20b99e5--image.png)

```cpp
void solve(){   
    iinp(n);
    vvl al(n,vl());
    for(ll i=1;i<n;i++){
        ll u,v;
        inp(u,v);
        u--,v--;
        al[u].push_back(v);
        al[v].push_back(u);
    }
    vl non(n);
    for(ll i=0;i<n;i++){
        non[i]=al[i].size();
    }
    ll root=-1,cnt=0;
    vl leaves;
    for(ll i=0;i<n;i++){
        if(non[i]>2){
            root=i;
            cnt++;
        }
        if(non[i]==1) leaves.push_back(i); 
    }
    if(cnt>1){
        pri("No");
        return;
    }
    pri("Yes");
    if(cnt==0){
      pri(1);
      pri(leaves.front()+1,leaves.back()+1);
      return ;
    }

    pri(leaves.size());
    for(ll i=0;i<leaves.size();i++){
        pri(root+1,leaves[i]+1);
    }
    pri();

}
```

