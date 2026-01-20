[codeforces.com](https://codeforces.com/problemset/problem/1428/C)
```cpp
for(char c: s){
	if(c=='b' and st.size()>=1){
		st.pop();
         continue;
	}
	st.push(c);
}
return st.size()
```
