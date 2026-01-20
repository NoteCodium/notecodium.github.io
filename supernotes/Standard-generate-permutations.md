# all permuations

![2%40paste_220714_171715_136.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/a46b1150-7766-4b22-a9a5-8384c1e4b669--2%2540paste_220714_171715_136.jpg)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b1ddc45f-9d3c-4b97-817f-7e95dea4a04b--image.png)


n!

```cpp
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

# in lexigraphic order
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/6da727c7-de63-4852-8220-8cdd98af2ebc--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/517dc2f4-9ac5-47d7-9fa8-ca2a29b98b34--image.png)


n! *n

```cpp
void f(idx){
	if(idx==n-1){
		ans.pb(v);
		return;
	}
	for(int i=idx;i<n;i++){
		rr(v,1,idx,i);
		f(i+1);
		rr(v,(idx-i+1)-1,idx,i);
	}
}
```






# Now the vector contains repetitions, generate permuatations such that each time it is unique, return all the generated permutations

```cpp
void f(idx){
	if(idx==n-1){
		ans.pb(v);
		return;
	}
	unordered_set<int> se;
	for(int i=idx;i<n;i++){
		if(se.count(v[i])) continue;
		se.insert(v[i]);
		swap(v[idx],v[i]);
		f(i+1)
		swap(v[idx],v[i]);
	}
}
```




