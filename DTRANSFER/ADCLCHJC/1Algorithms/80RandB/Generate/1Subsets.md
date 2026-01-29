---
title: 1Subsets
---

{% raw %}
generate all unique subsets of 1 to n

```python
f(n); 
```

```python
void f(int elem){
	if(elem==0){
		ans.push_back(tmp);
		return;
	}
    
    //take
	tmp.push_back(elem);
	f(elem-1);
    //backtrack
	tmp.pop_back();

    //not take  
	f(elem-1);
}
```

generate all subsets of a array if it has no repetitions, and you can obviously not use the same element twice because this will create infinite subsets

```python
f(n-1); 
```

```python
void f(int idx){
	if(idx<0){
		ans.push_back(tmp);
		return;		
	}
	
    //take
	tmp.push_back(v[idx]);
	f(idx-1);
     //backtrack
	tmp.pb();

     //not take
	f(idx-1);
}
```

generate all subsets of size k

```python
f(n-1); 
```

```python
void f(int idx){
	if(cnt==0){
		ans.pb(tmp);
		return; 
	}
	if(idx<0){
		return;
	} 
	
    //take
	tmp.pb(v[idx]);
	f(idx-1,cnt-1);
    //backtrack
	tmp.pop_back();

    //not take
	f(idx-1,cnt);
}
```

Generate all unique subsets if the array have repetitions

https://leetcode.com/problems/subsets-ii/description/

now the problem is you dont want repeated subsets

but you dont want to delete the repetitions to as
1 3 3

is a new susbet

A bad
(2^n)*log(2^n) solution

unordered sets will not work here as unordered_set<vector> is not hashable

```python
//sol similar to 
//Contain repetitions, any number can be took only once    
    //not take, for generating unique subsets
    //while skipping an element, skip all the same elements

void f(vector<vector<int>> &ans, vector<int> &tmp, vector<int> &v, int idx){ 
    if(idx<0){ 
        ans.push_back(tmp); 
        return; 
    }

    tmp.push_back(v[idx]); 
    f(ans,tmp,v,idx-1); 
    tmp.pop_back(); 

    int curr=v[idx]; 
    while(idx>=0 and v[idx]==curr){
        idx--;  
    } 
    f(ans,tmp,v,idx); 
} 
vector<vector<int>> subsetsWithDup(vector<int>& v) { 
    int n=v.size(); 
    sort(v.begin(),v.end()); 
    vector<vector<int>> ans; 
    vector<int> tmp; 
    f(ans,tmp,v,n-1); 
    return ans; 
} 
```

Generate all subsets sum    
http://practice.geeksforgeeks.org/problems/subset-sums2234/1

```python
void findSum(vector<int> &ans, vector<int> &v, int idx, int &sum){
    if(idx==-1){
        ans.push_back(sum);
        return;
    }
    findSum(ans,v,idx-1,sum);
    sum+=v[idx];
    findSum(ans,v,idx-1,sum);
    sum-=v[idx];
}

vector<int> subsetSums(vector<int> v, int n){
    vector<int> ans;
    int sum=0;
    findSum(ans,v,n-1,sum);
    return ans;
}
```
{% endraw %}
