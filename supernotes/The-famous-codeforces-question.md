![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/dda34418-e068-441d-8d64-2ae90a896c85--image.png)

# Brute force n^3


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d9dba7b4-9c8c-483b-88d9-4a2ead5bd68d--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/dc0a07e5-c625-472b-9e5e-a33291d92730--image.png)


![WhatsApp%20Image%202023-10-12%20at%2017.03.22_1f19156b.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/c85da15a-4c8f-479c-ab10-f5f6bb9a00a8--WhatsApp%2520Image%25202023-10-12%2520at%252017.03.22_1f19156b.jpg)

# If equality does not exist in i,j ,k
```cpp
  for(ll i=1;i<=n-2;i++){
      ans=max(ans,pre[i-1]+v[i]*q+post[i+1]);
  }
```


# Equality exist
[Problem - 855B - Codeforces](https://codeforces.com/problemset/problem/855/B)

```cpp
void solve() {  
    ll n,p,q,r;
    inp(n,p,q,r);
    vinp(v,n);
    ll ans=LLONG_MIN; 
    vl pre(n),post(n);
    pre[0]=p*v[0];
    post[n-1]=r*v[n-1];
    for(ll i=1;i<n;i++){
        pre[i]=max(pre[i-1],p*v[i]);
        post[n-i-1]=max(post[n-i],r*v[n-i-1]);
    }
    for(ll i=0;i<n;i++){
        ans=max(ans,pre[i]+v[i]*q+post[i]);
    }
    pri(ans);
    
}
```