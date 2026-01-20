[Sum of the products of all possible Subsets - GeeksforGeeks](https://www.geeksforgeeks.org/sum-products-possible-subsets/)

OA avaialble in ppa only
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/83a62be9-3b83-4bb9-98b1-fe2766091904--image.png)

No edge case

```cpp
void solve(){
    int n;
    cin>>n;
    vector<int> v(n);
    for(int i=0;i<n;i++) cin>>v[i];
    ll ans=1;
    for(ll x: v){
        ans=modm(ans,x+1);
    }
    cout<<ans-1<<'\n';
}
```
