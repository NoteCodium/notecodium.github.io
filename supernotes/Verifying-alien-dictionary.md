[leetcode.com](https://leetcode.com/problems/verifying-an-alien-dictionary/submissions/1115530971/)

```cpp
bool isAlienSorted(vector<string>& words, string order) {
    unordered_map<char,int> m;
    for(int i=0;i<order.size();i++) m[order[i]]=i;
    int n=words.size();
    for(int i=0;i<=n-2;i++){
        string w1=words[i],w2=words[i+1];
        int minLen=min(w1.size(),w2.size());
        int p;
        for(p=0;p<minLen;p++){
            if(w1[p]==w2[p]) continue;
            else if(m[w1[p]]<m[w2[p]]) break;
            else return 0;
        }
        if(p==minLen and w1.size()>w2.size()) return 0;
    }
    return 1;
}
```