All merge sort questions
1. priyansh
![image.png](../images/461d8c27-9652-4dad-861e-a7fb72578b49--image.png)

0 is striclty not allowed, if 0 anywhere do coordinate compression


# Version 1
```cpp
class Fen{
    public:
        vector<ll> bit;
        ll n;
        Fen(ll n){
            bit.resize(n+1,0);
            this->n=n;
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
```




# Version 2 

```cpp
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
```
