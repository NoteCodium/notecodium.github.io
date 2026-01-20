[Check If Word Is Valid After Substitutions - LeetCode](https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/description/)

```cpp
for(char c: s){
	if(c=='c' and st.size()>=2 and st.top()=='b'){
		st.pop();
		if(st.top()=='a'){
			st.pop();
			continue;
		}
		else st.push('b');
	}
	st.push(c);
}
```
''