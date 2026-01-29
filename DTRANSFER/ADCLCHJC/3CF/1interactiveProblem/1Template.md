---
title: 1Template
---

{% raw %}
endl ka concept

wrong answer when you exceed the attempts

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_1Template__att_0001.png)

https://codeforces.com/gym/101021

```python
string ask(ll m){
    cout<<m<<endl;
    string s;
    cin>>s;
    return s;
}

void tell(ll ans){
    cout<<"! "<<ans<<endl;
}

void solve(){
    ll l=1,h=1000000,ans=-1;
    while(l<=h){
        ll m=l +(h-l)/2;
        string result=ask(m);
        if(result==">="){
            ans=m;
            l=m+1;
        }
        // else if(result){
            
        // }
        else{
            h=m-1;
        }
    }
    tell(ans);
}
```
{% endraw %}
