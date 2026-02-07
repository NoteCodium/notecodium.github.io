[maang.in](https://maang.in/problems/Count-Distinct-Char-in-Substrings-62?resourceUrl=cs99-cp512-pl3478-rs62)

![image.png](../images/a072a5e3-3cf7-4fb6-861f-8400d073da07--image.png)

# Idea 1
![image.png](../images/72d43b0a-7c8d-45e3-b1aa-5979abe93e8e--image.png)

# Idea 2
![image.png](../images/2b49268f-d6e2-46d3-987a-ac727b440f57--image.png)
![image.png](../images/f5170954-fa13-4437-a8a1-ae65ee637c13--image.png)
![image.png](../images/a7655a19-8423-44e4-b409-5ca9d09c7139--image.png)
![image.png](../images/49a52872-1c1d-4f1a-a38b-72fbef9615a2--image.png)
![image.png](../images/4c15777a-ccfa-46e0-aa21-9a4ffb983312--image.png)

```cpp
void solve(){
    iinp(n);
    sinp(s);
    vl prev(26,-1);
    ll ans=13*n*(n+1);
    for(ll i=0;i<n;i++){
        char c=s[i];
        ll rods=i-prev[c-'a'];
        ans-=(rods*(rods-1))/2;
        prev[c-'a']=i;        
    }
    for(ll i=0;i<26;i++){
        ll rods=n-prev[i];
        ans-=(rods*(rods-1))/2;
    }
    cout<<ans<<endl;
}
```
