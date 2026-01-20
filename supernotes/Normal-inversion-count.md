[Global and Local Inversions - LeetCode](https://leetcode.com/problems/global-and-local-inversions/description/)


```cpp
#include <bits/stdc++.h>
using namespace std;
#define ll long long
class Fen{
    public:
        vector<ll> bit;
        ll n;
        Fen(ll n){
            this->n=n;
            bit.resize(n+1,0);
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
        //coordinate compression
        map<int,int> m;
        int n=v.size();
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
        Fen f(100000);
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=f.sum(100000)-f.sum(v[i]);
            f.updateA(v[i],1);
        }
        return ans;
    }

    bool isIdealPermutation(vector<int>& v) {
        int cnt=0;
        int n=v.size();
        for(int i=1;i<n;i++){
            if(v[i-1]>v[i]){
                cnt++;
            }
        }
        return cnt==reversePairs(v);    
    }

};

```