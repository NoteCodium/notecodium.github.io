[Interleaving String - LeetCode](https://leetcode.com/problems/interleaving-string/description/)

```cpp
bool f(string &s1, string &s2, string &s, int i1,int i2, int j){
    if(j<0) return 1;
    bool x=0,y=0;
    if(i1>=0 and s1[i1]==s[j]) x=f(s1,s2,s,i1-1,i2,j-1);
    if(i2>=0 and s2[i2]==s[j]) y=f(s1,s2,s,i1,i2-1,j-1);
    return x or y;          
}

bool isInterleave(string s1, string s2, string s) { 
    int n1=s1.size(),n2=s2.size(),n=s.size();
    if(n1+n2!=n) return 0;
    return f(s1,s2,s,n1-1,n2-1,n-1);
}
```

