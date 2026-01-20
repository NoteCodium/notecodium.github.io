[Word Break II - LeetCode](https://leetcode.com/problems/word-break-ii/description/)

![image.png]()


```cpp
#include <bits/stdc++.h> 

bool isValid(string s, unordered_set<string> &m){
    return m.count(s);
}    

void f(int idx, string &s, unordered_set<string> &m, vector<string> &tmp, vector<string> &ans){
    if(idx>=s.size()){
        string sss;
        for(string ss: tmp){
            sss=sss+ss+' ';
        }
        sss.pop_back();
        ans.push_back(sss);
        return;    
    }
    for(int i=idx;i<s.size();i++){
        if(isValid(s.substr(idx,i-idx+1),m)){
            tmp.push_back(s.substr(idx,i-idx+1));
            f(i+1,s,m,tmp,ans);
            tmp.pop_back();
        }
    }
}

vector<string> wordBreak(string &s, vector<string> &vos){
    unordered_set<string> m(vos.begin(),vos.end());
    vector<string> ans,tmp;
    f(0,s,m,tmp,ans);
    return ans;
}
```