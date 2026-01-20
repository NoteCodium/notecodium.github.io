


# Approach
1. we will be generating subsets in each function call



```cpp
//sort
void f(int idx, vector<int> &tmp){
	ans.push_back(tmp);
	if(idx==n) return;
	for(int i=idx;i<n;i++){
		tmp.pb(v[i]);
		f(i+1);
		tmp.pb();
	} 
}