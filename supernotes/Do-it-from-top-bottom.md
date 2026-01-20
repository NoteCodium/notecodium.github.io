```cpp
int f(string &s, int i, int j){
    if(i>j) return 0;
    if(i==j) return 1;
    return s[i]==s[j]?2+f(s,i+1,j-1):max(f(s,i+1,j),f(s,i,j-1));
}


int longestPalindromeSubseq(string s) {
    int n=s.size();
    int i=0,j=n-1;
    return f(s,i,j);
}
```
