[codeforces.com](https://codeforces.com/contest/1879/problem/C)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/4e2bffdb-b211-40b7-b4e9-66827b5a42ca--image.png)

[Codeforces Educational Round 155 | Video Solutions - A to D | by Ankit | TLE Eliminators - YouTube](https://youtu.be/_S3NpzQyqDE?si=h1HbAt2uQ6PU4W-B

```cpp
void solve() {  
    sinp(s);
    ll n=s.size();
    ll pcnt=1;
    ll len=1;
    ll ans=1;
    char c=s[0];
    for(ll i=1;i<n;i++){
        if(c!=s[i]){
            //end of patch
            ans=modm(ans,pcnt);
            pcnt=1;
            c=s[i];
            len++;
        }
        else{
            pcnt++;
        }
    }

    ans=modm(ans,pcnt);
    ans=modm(ans,fac(n-len));
    cout<<n-len<<" "<<ans;
    pri();
}
```