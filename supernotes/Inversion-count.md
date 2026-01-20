# Coordinate compression
```cpp
map<int,int> m;
for(int x: v){
    m[x];
}
int cnt=1;
for(auto &p: m){
    p.second=cnt++;
}
for(int &x: v){
    x=m[x];
}
```




Wont work due to 2n factor
```cpp
#include <bits/stdc++.h>
using namespace std;
#define ll int
class Fen{
    public:
        vector<ll> bit;
        ll n;
        Fen(vector<ll> &v){
            n=v.size();
            bit.resize(n+1);
            for(ll i=0;i<n;i++){
                updateA(i+1,v[i]);
            }
        }

        ll sum(ll idx){
            ll ans=0;
            while(idx>=1){
                ans+=bit[idx];
                idx -= idx & (-idx);
                // idx = idx&(idx-1);
            }
            return ans;
        }


        //this update by default add
        //instead of changing the value
        void updateA(ll idx, ll val){
            while(idx<=n){
                bit[idx]+=val;
                idx += idx & (-idx);
            }            
        }

        void updateR(ll idx, ll val, ll &old){
            updateA(idx,val-old);
            old=val;            
        }
};


class Solution {
public:

    //generate a fenwick tree
    int reversePairs(vector<int>& v) {
        vector<int> tmp(1e5+1,0);
        Fen f(tmp);
        int ans=0;
        int n=v.size();
        for(int i=0;i<n;i++){
            ans+=f.sum(1e5)-f.sum(v[i]*2);
            f.updateA(v[i],1);
        }
        return ans;
    }
};
```


# 10^9 as well as negative numbers

# Coordinate compresssion?
this will not work on


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8d2ddd03-5b15-4be6-8118-16114a099498--image.png)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/86ed0036-50ce-4d79-a8ab-5fd46632740e--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c8d634f4-620d-492c-bb95-b84bdcddf091--image.png)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ebf7c074-c965-4a35-9235-03bdb6dd2ac3--image.png)



![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/026d1750-0849-4fc8-9217-28877576e15f--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/51351349-5341-4415-acfa-118c46924dcf--image.png)

