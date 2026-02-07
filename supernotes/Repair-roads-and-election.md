[Problem - 369C - Codeforces](https://codeforces.com/problemset/problem/369/C)

[Valera and Elections | Viraj - YouTube](https://www.youtube.com/watch?v=HLLaON3mx6M)

![image.png](../images/4d7ce4b3-5e4b-46f0-90c7-e83eae419590--image.png)


![image.png](../images/32ec2f1a-138a-44fa-bf57-a4063732becf--image.png)






![image.png](../images/60d47fe0-783c-4037-927b-b020ecb96fcc--image.png)
![image.png](../images/78cb94e3-677f-4080-801c-ee2f3e639c82--image.png)


![image.png](../images/181b24c0-0d5a-4057-9b0e-136fc70860aa--image.png)



![image.png](../images/f0f2e1a2-a036-4338-8363-793c88f87502--image.png)

![image.png](../images/efcb6a86-5855-42bc-a196-73416f9870f8--image.png)

# Final solution
![image.png](../images/7058ba4e-1277-4d12-bd6a-5219dfb5b81c--image.png)


# Solution
the subtree rooted at that idx contains how many damaged node

![image.png](../images/d84978c4-6a59-438c-b747-135a7df99934--image.png)


![image.png](../images/a4526512-c1ff-4d56-a888-1c14781daf9e--image.png)

```cpp
ll dfs(ll node, ll par, vvl &al, vl &repair, vl&subtree){
    if(repair[node]) subtree[node]++;
    for(ll nei: al[node]){
        if(nei==par) continue;
        subtree[node]+=dfs(nei,node,al,repair,subtree);
    }
    return subtree[node];
}

void solve(){
    iinp(n);
    vvl al(n,vl());
    vl repair(n,0);
    for(ll i=1;i<n;i++){
        ll u,v;
        inp(u,v);
        u--,v--;
        al[u].push_back(v);
        al[v].push_back(u);
        iinp(re);
        if(re==2){
            repair[v]=repair[u]=1;
        }
    }
    vl subtree(n,0);
    dfs(0,-1,al,repair,subtree);
    vl ans;
    for(ll i=0;i<n;i++){
        if(subtree[i]==1){
            ans.push_back(i+1);
        }
    }
    pri(ans.size());
    priv(ans);
    
}
```
