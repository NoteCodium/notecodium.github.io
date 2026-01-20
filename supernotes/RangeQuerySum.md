[Range Sum Query - Mutable - LeetCode](https://leetcode.com/problems/range-sum-query-mutable/description/)

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




class NumArray {
public:
    Fen f;
    vector<int> v;
    NumArray(vector<int>& v):f(v),v(v){

    }
    
    void update(int idx, int val) {
        f.updateR(idx+1,val,v[idx]);
    }
    
    int sumRange(int l, int r) {
        l++,r++;
        return f.sum(r)-f.sum(l-1);
    }
};
```
