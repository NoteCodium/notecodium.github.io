# MAANG   
see its explanation in PPA


generate all subsets in lexigraphic order


```python
void f(int idx){
	ans.push_back(tmp);
	if(idx>=n){
        return;
    } 
	for(int i=idx;i<n;i++){
		tmp.push_back(v[i]);
		f(i+1);
		tmp.pop_back();
	} 
}
```

vs generating permutations


```python
void f(idx){
	if(idx==n-1){
		ans.pb(v);
		return;
	}
	for(int i=idx;i<n;i++){
		swap(s[idx],s[i]);
		f(i+1);
		swap(s[idx],s[i]);
	}
}
```

Generate permutations of a given array with distinct elements in lexicographic order

