[leetcode.com](https://leetcode.com/problems/maximum-number-of-removable-characters/description/)

```cpp
int maximumRemovals(string s, string p, vector<int>& v) {
    int n=v.size();
    int l=0,h=n,ans;
    while(l<=h){
        int m=(l+h)/2;
        if(isPal(s,p,v,m)) ans=m,l=m+1;
        else h=m-1;
    }
    return ans;
}
```

```cpp
bool  isPal(string s, string &p,vector<int>& v,int m){
    for(int i=0;i<m;i++) s[v[i]]='#';
    int ns=s.size(),np=p.size();
    int fast=0,slow=0;
    while(fast<ns){
        if(s[fast]==p[slow]) slow++;
        fast++;
    }
    return slow==np;
}
```