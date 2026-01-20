```cpp
int f(string &s1, string &s2, int i, int j){
    if(i==-1 or j==-1) return 0;
    return s1[i]==s2[j]?1+f(s1,s2,i-1,j-1): max(f(s1,s2,i,j-1),f(s1,s2,i-1,j));
}


int longestCommonSubsequence(string s1, string s2) {
    int n1=s1.size(),n2=s2.size();
    return f(s1,s2,n1-1,n2-1);
}
```
