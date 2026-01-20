[Problem - A - Codeforces](https://codeforces.com/contest/81/problem/A)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/405a3d2e-cdea-49c9-bcca-20e4fe345d50--image.png)

# this will pass
```cpp
void solve() {  
    sinp(s);
    stack<char> st;
    for(char c: s){
        if(st.empty()) st.push(c);
        else{
            if(st.top()==c) st.pop();
            else st.push(c);
        } 
    }
```

```cpp
    string ans;
    while(!st.empty()){
        ans.push_back(st.top());
        st.pop();
    }
    reverse(it(ans));
    pri(ans);
}
```



this will fail
```cpp
void solve() {  
    sinp(s);
    ll n=s.size();
    string ans;
    for(ll i=0;i<n;){
        char c=s[i];
        ll cnt=0;
        while(i<n and s[i]==c){
            cnt++;
            i++;
        }
        if(cnt==1){
          ans.push_back(c);
        }
    }
    pri(ans);

}
```


This will fail
```cpp
void solve() {  
    sinp(s);
    stack<char> st;
    for(char c: s){
        if(!st.empty() and c==st.top()) continue;
        else st.push(c);
    }
    string ans;
    while(!st.empty()){
        ans.push_back(st.top());
        st.pop();
    }
    reverse(it(ans));
    pri(ans);
}
```


