```cpp
stringstream ss(s);
string tok;
while(getline(ss,tok,','))
```
[151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

```cpp
while(ss>>tok) vos.push_back(tok);
```

```cpp
string reverseWords(string s) {
    stringstream ss(s);
    vector<string> vos;
    string tok;
    // while(getline(ss,tok,'')) vos.push_back(tok);
    // for(string q:vos) cout<<q<<" ";
    while(ss>>tok) vos.push_back(tok);

    reverse(vos.begin(),vos.end());
    string ans=vos[0];
    for(int i=1;i<vos.size();i++) ans=ans+" "+vos[i];
    return ans;
}
```


[Reverse Words in a String - LeetCode](https://leetcode.com/problems/reverse-words-in-a-string/editorial/)

--------------------------------------------------------------------
1. Trim the whitespaces, reverse the
whole string and then reverse each word.

2. 