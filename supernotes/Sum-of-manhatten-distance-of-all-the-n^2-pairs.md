[Master Data Structures, Algorithms & System Design: Become 100% Coding Interview Ready](https://dashboard.programmingpathshala.com/renaissance/practice/question?questionId=135&sectionId=1&moduleId=2&topicId=7&subtopicId=90&assignmentId=20)


![image.png](../images/c65955d3-fb69-490b-8604-120451ac2a58--image.png)


![image.png](../images/eb67f9bc-7b9d-4b74-a517-9b672284399b--image.png)

X and Y can be independent

1. How will these modulus open

![image.png](../images/80b3d01c-630f-4362-8b72-3eef09b215ca--image.png)


![image.png](../images/cfdc5c22-ff34-468a-833d-d76962abc9ee--image.png)

![image.png](../images/e6ffb24a-bd8a-4d0a-a88b-99d71df5d827--image.png)


![image.png](../images/e49ad1e6-1626-420f-b81a-0b790917c997--image.png)

for p0

![image.png](../images/b1216c26-efcc-4937-8dd2-8b0e288279a5--image.png)

for p1

![image.png](../images/7f0bf9fb-da6c-4074-ac1e-035468faec5b--image.png)

![image.png](../images/3269e95b-14a4-4386-95a6-0edfdc178ebb--image.png)

![image.png](../images/ea1c96c0-81a1-4703-bb98-3d88554f00f8--image.png)

```cpp
int f(vector<int> &v){
    sort(v.begin(),v.end());
    int n=v.size();
    vector<int> ss(n);
    ss[n-1]=v[n-1];
    for(int i=n-2;i>=0;i--) ss[i]=ss[i+1]+v[i];
    int ans=0;
    for(int i=0;i<=n-2;i++) ans=moda(ans,moda(ss[i+1],-(n-i-1)*v[i]));
    return ans;
}

void solve(){
    int n;
    cin>>n;
    vector<int> x(n),y(n);
    for(int i=0;i<n;i++){
        cin>>x[i]>>y[i];  
    } 
    int ans=moda(f(x),f(y));
    cout<<ans<<'\n';
}

```
# without the suffix sum array

```cpp
int f(vector<int> &v){
    sort(v.begin(),v.end());
    int n=v.size();
    int sum=accumulate(v.begin(),v.end(),0);

    int ans=0;
    for(int i=0;i<=n-2;i++){
        sum-=v[i];
        ans=moda(ans,moda(sum,-(n-i-1)*v[i]));
    } 
    return ans;
}

void solve(){
    int n;
    cin>>n;
    vector<int> x(n),y(n);
    for(int i=0;i<n;i++){
        cin>>x[i]>>y[i];  
    } 
    int ans=moda(f(x),f(y));
    cout<<ans<<'\n';
}
```




# Full code
```cpp
#include <bits/stdc++.h>
using namespace std;
#define ll int
#define mod 1000000007  
ll moda(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a + b) % cm) + cm) % cm;}


int f(vector<int> &v){
    sort(v.begin(),v.end());
    int n=v.size();
    vector<int> ss(n);
    ss[n-1]=v[n-1];
    for(int i=n-2;i>=0;i--) ss[i]=ss[i+1]+v[i];
    int ans=0;
    for(int i=0;i<=n-2;i++) ans=moda(ans,moda(ss[i+1],-(n-i-1)*v[i]));
    return ans;
}

void solve(){
    int n;
    cin>>n;
    vector<int> x(n),y(n);
    for(int i=0;i<n;i++){
        cin>>x[i]>>y[i];  
    } 
    int ans=moda(f(x),f(y));
    cout<<ans<<'\n';
}


int main() {
    int ttt;
    ttt=1;
    // cin>>ttt;
    while(ttt--) solve();
    return 0;
}
```
