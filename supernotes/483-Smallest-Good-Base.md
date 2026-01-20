[Just a moment...](https://leetcode.com/problems/smallest-good-base/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4d48f679-9d7e-4e31-a1fe-7ba838e2ace0--image.png)

1. all 1 is always a good base
3. Another good base
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cb394ef0-b1cd-487d-adbc-50e128168da3--image.png

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5c09ac51-1eb7-4a0d-9461-3dc6f709ff7a--image.png)

# Knowing some properties of good base
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1adca5d5-933e-4c32-8b5a-7dc126dd3c89--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3086296d-a304-4c82-8c84-c32918fadf7f--image.png)

10^18  in  base 2 is almost  59.8 which means 60 digits
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b890548a-210f-4b76-91eb-c905aac6be81--image.png)

we will go from highest number of digits because that will give us the smallest base

```cpp
ll calculate(ll n, ll digits, ll m){
    ll sum=1;
    ll x=1;
    ll tmpDigit=digits-1;
    while(tmpDigit){
        if(x<n/m) x*=m;
        else break;
        if(sum+x<=n) sum+=x;
        else break;
        tmpDigit--;
    }
    if(tmpDigit==0 and sum==n) return 2;
    if(tmpDigit==0 and sum<n) return 1;
    if(tmpDigit!=0) return 0;
    return -1;
}

string smallestGoodBase(string s) {
    ll n = stoll(s);
    for (ll digits = 60; digits >= 2; digits--) {
        ll l = 2, h = n - 1;
        while (l <= h) {
            ll m = (l + h) / 2;
            ll res=calculate(n,digits,m);
            if(res==2) return to_string(m);
            if(res==1) l=m+1;
            else h=m-1;
        }
    }
    return to_string(n - 1);
}
```

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ecc4342e-e193-4ae7-9414-284169424923--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/900f1304-24fb-424e-bccd-acf4350c0cc5--image.png)
overflow
![image.png]()






