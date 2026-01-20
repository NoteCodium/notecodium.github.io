```cpp
int f(int i, int j){
	if(i==j) return 0;
	int ans=INT_MAX;
	for(int k=i;k<j;k++) ans=min(ans,f(i,k)+f(k+1,j)+v[i-1]*v[k]*v[j]);
	return ans;
}
```
