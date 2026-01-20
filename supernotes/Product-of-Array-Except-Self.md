[Product of Array Except Self - LeetCode](https://leetcode.com/problems/product-of-array-except-self/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/01d14e8d-7c6c-4428-86aa-fd191c241335--image.png)



```cpp
vector<int> productExceptSelf(vector<int>& v) {
    int product=1,cnt=0;
    for(int x: v){
        if(x) product*=x;
        else cnt++;
    }
    int n=v.size();
    vector<int> ans(n,0);
    if(cnt>=2) return ans;
    for(int i=0;i<n;i++){
        if(v[i]){
            if(cnt==1) ans[i]=0;
            else ans[i]=product/v[i];
        }
        else{
            ans[i]=product;
        }
    }
    return ans;
}
```

# Without using the division operator as mentioned in the question

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a68e1eac-c4ac-4a25-a2f1-8414be49b03c--image.png)

```cpp
vector<int> productExceptSelf(vector<int>& v) {
    int n=v.size();
    vector<int> ans(n),pre(n),post(n);
    pre[0]=v[0];
    post[n-1]=v[n-1];
    for(int i=1;i<n;i++){
        pre[i]=pre[i-1]*v[i];
        post[n-1-i]=post[n-1-i+1]*v[n-1-i];
    }
    ans[0]=post[1];
    ans[n-1]=pre[n-2];
    for(int i=1;i<=n-2;i++){
        ans[i]=pre[i-1]*post[i+1];
    }

    return ans;
}
```

[Product of Array Except Self - Leetcode 238 - Python - YouTube](https://youtu.be/bNvIQI2wAjk?si=FyNvoXW0POYdY9Hd)

# Doing the above in constant space

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d2a0be71-5bac-44c8-86ca-60539584555a--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3430c106-3b16-4f36-812e-2eb5c4837e28--image.png)

```cpp
vector<int> productExceptSelf(vector<int>& v) {
    int n=v.size();
    vector<int> ans(n);
    ans[0]=ans[n-1]=1;
    int pre=1,post=1;
    for(int i=0;i<=n-2;i++){
        pre*=v[i];
        ans[i+1]=pre;
    } 
    for(int i=n-1;i>=1;i--){
        post*=v[i];
        ans[i-1]*=post;
    }

    return ans;
}
```


