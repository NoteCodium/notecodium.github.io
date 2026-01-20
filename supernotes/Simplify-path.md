[](https://leetcode.com/problems/simplify-path/description/)

1. convert absolute path to canonical path
2.  Absolute path and canonical path start with /
2.  Canonical path does not end with /
3.  // of absolute path is converted to just / in canonical
4.  . is current directory and .. is up a level in absolute path ⇒ these are solved in canonical path

```cpp
int n=s.size();
stack<string> st;
for(int i=0;i<n;i++){
	if(s[i]=='/') continue;
	string tmp;
	while(i<n and s[i]!='/') tmp.push_back(s[i++]);
	if(tmp==".") continue;
	if(tmp==".." and !st.empty()){
		st.pop();
		continue;
	}
	st.push(tmp);
}
```

```cpp
if(st.empty()) return "/";
string ans;
while(!st.empty()){
	ans="/"+st.top()+ans;
	st.pop();
}
return ans;
```
