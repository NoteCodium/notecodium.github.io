[CSES - Money Sums](https://cses.fi/problemset/task/1745)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5b316370-15a2-46c5-94b2-e4faa7eb236a--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/477a58ee-08cc-44c0-a343-d7438a6ec6ea--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/289ad0ba-b1eb-42db-8f8e-7e3fe80c6f41--image.png)

```cpp
void solve() {  
    iinp(n);
    vinp(v,n);
    vl dp(100001,0);
    dp[0]=1;
    for(ll x: v){
        for(ll i=100000;i>=0;i--){
            if(dp[i] and i+x<=100000){
                dp[i+x]=1;
            }
        }
    }
    vl ans;
    for(ll i=1;i<=100000;i++){
        if(dp[i]){
            ans.push_back(i);
        }
    }
    pri(ans.size());
    priv(ans);

}
```
