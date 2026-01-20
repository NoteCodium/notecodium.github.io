
# two difference closest
[TheJobOverflow | The Chemist | Barclays](https://www.thejoboverflow.com/problem/95/)

```cpp
void solve(){
    iinp(k);
    iinp(n);
    vinp(v,n);
    sort(it(v));
    ll chk=LLONG_MAX;
    ll ans=LLONG_MIN;
    ll l=0,h=1;
    while(h<n){
        ll diff=v[h]-v[l];
        ll sum=v[h]+v[l];
        if(diff==k){
            ans=max(ans,sum);
            l++;
            h++;
        }
        else if(diff<k){
            h++;
        }
        else{
            l++;
            if(l>=h){
                h++;
            }
        }

        if(chk>abs(diff-k)){
            ans=max(ans,sum);
            chk=abs(diff-k);
        }
    }
    cout<<ans<<endl;
}

```