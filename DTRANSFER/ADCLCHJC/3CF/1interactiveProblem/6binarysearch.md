---
title: 6binarysearch
---

{% raw %}
https://codeforces.com/contest/1486/problem/C2

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0001.png)

```python
ll ask(ll l, ll r){
    if(l >= r){
        return -1;;
    } 
    cout<<"? "<<l<<" "<<r<<endl;
    ll idx;
    cin>>idx;
    return idx;
}

void tell(ll ans){
    cout<<"! "<<ans<<endl;
    return;
}

void bs2(ll l, ll h, ll secondMaxIdx, ll &ans){
    while(l<=h){
        ll m=l +(h-l)/2;
        if(ask(secondMaxIdx,m)==secondMaxIdx){
            ans=m;
            h=m-1;
        }
        else{
            l=m+1;
        }
    }
}


void bs1(ll l, ll h, ll secondMaxIdx, ll &ans){
    while(l<=h){
        ll m=l +(h-l)/2;
        if(ask(m,secondMaxIdx)==secondMaxIdx){
            ans=m;
            l=m+1;
        }
        else{
            h=m-1;
        }
    }
}

void solve(){
    iinp(n);
    ll secondMaxIdx=ask(1,n);
    //according to problem n starts from 2
    if(n==2){
      if(secondMaxIdx==1){
        tell(2);
      }
      else{
        tell(1);              
      }              
    }

    ll tmp=ask(1,secondMaxIdx);
    ll l,h,ans=-1;
    if(tmp==1){
        l=2,h=n;
        bs2(l,h,secondMaxIdx,ans);
    }
    else if(tmp==secondMaxIdx){
        //answer lies bw 1 and secondMaxIdx-1
        l=1,h=secondMaxIdx-1;
        bs1(l,h,secondMaxIdx,ans);
    }
    else{
        l=secondMaxIdx+1,h=n;
        bs2(l,h,secondMaxIdx,ans);
    }
    tell(ans);
}
```

https://codeforces.com/problemset/problem/1698/D

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0002.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0003.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0004.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0005.png)

BS

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0006.png)

```python
vl ask(ll l, ll r){
    cout<<"? "<<l<<" "<<r<<endl;
    ll n=r-l+1;
    vinp(v,n);
    return v;
}

// use only endl
void tell(ll ans){
    cout<<"! "<<ans<<endl;
}


void solve(){
    iinp(n);
    ll l=1,h=n,ans=-1;
    while(l<=h){
        ll m=l +(h-l)/2;
        vl v=ask(l,m);
        ll result=0;
        for(auto & x:v){
          if(x>=l and x<=m){
            result++;
          }
        }
        if(result%2){
            ans=m;
            h=m-1;
        }
        else{
            l=m+1;
        }
    }
    tell(ans);
    
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_3CF_1interactiveProblem_6binarysearch__att_0007.png)
{% endraw %}
