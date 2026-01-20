[Wildcard Matching - LeetCode](https://leetcode.com/problems/wildcard-matching/)
s
p => ? single char * any sequence of char

```cpp
bool f(string &s, string &p, int i, int j, int lastIdx){
    if(i<0) return j<=lastIdx;
    if(j<0) return 0;
    if(p[j]=='?') return f(s,p,i-1,j-1,lastIdx);
    else if(p[j]=='*') return f(s,p,i-1,j,lastIdx) or f(s,p,i,j-1,lastIdx);
    else{
        if(p[j]==s[i]) return f(s,p,i-1,j-1,lastIdx);
        else return 0;
    }
}

bool isMatch(string s, string p) {
    //? single character 
    //* any number of characters
    // s is the string
    // p is pattern
    int ns=s.size(),np=p.size();
    if(ns==0 and np==0) return 1;
    if(np==0) return 0;
    //scan p for continous *
    int lastIdx=-1;
    while(lastIdx<=np-2 and p[lastIdx+1]=='*'){
        lastIdx++;
    }
    if(lastIdx==np-1) return 1;
    if(ns==0) return 0;
    return f(s,p,ns-1,np-1,lastIdx);
}
```

```cpp
bool f(string &s, string &p, int i, int j, int lastIdx, vector<vector<int>> &mem){
    if(i<0) return j<=lastIdx;
    if(j<0) return 0;
    if(mem[i][j]!=-1) return mem[i][j];
    int ans;
    if(p[j]=='?') ans=f(s,p,i-1,j-1,lastIdx,mem);
    else if(p[j]=='*') ans=f(s,p,i-1,j,lastIdx,mem) or f(s,p,i,j-1,lastIdx,mem);
    else{
        if(p[j]==s[i]) ans=f(s,p,i-1,j-1,lastIdx,mem);
        else ans=0;
    }
    return mem[i][j]=ans;
}

bool isMatch(string s, string p) {
    //? single character 
    //* any number of characters
    // s is the string
    // p is pattern
    int ns=s.size(),np=p.size();
    vector<vector<int>> mem(ns,vector<int>(np,-1));
    if(ns==0 and np==0) return 1;
    if(np==0) return 0;
    //scan p for continous *
    int lastIdx=-1;
    while(lastIdx<=np-2 and p[lastIdx+1]=='*'){
        lastIdx++;
    }
    if(lastIdx==np-1) return 1;
    if(ns==0) return 0;
    return f(s,p,ns-1,np-1,lastIdx,mem);
}
```
