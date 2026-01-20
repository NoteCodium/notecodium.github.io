# generate all unique subsets of 1 to n

1. Simple take not take starting from n

```cpp
void f(i){
	if(i==0){
		ans.push_back(tmp);
		return;
	}
    //take
	tmp.push_back(i);
	f(i-1);
    //backtrack
	tmp.pop_back();

    //not take  
	f(i-1);
}

f(n); 
```
# generate all subsets of a array if it has no repetitions
```cpp
 void f(){
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
No of nodes in last level 2^(n)
Total node 2^(n+1)  -  1


# generate all subsets of size k
```cpp
void f(){
	if(cnt==0){
		ans.pb(tmp);
		return; 
	}
	if(idx<0) return;
    //take
	tmp.pb(v[idx]);
	f(idx-1,cnt-1);
    //backtrack
	tmp.pop_back();

    //not take
	f(idx-1,cnt);
}
```

# Generate all unique subsets if the array have repetitions
[Subsets II - LeetCode](https://leetcode.com/problems/subsets-ii/description/)

now the problem is you dont want repeated subsets
  

but you dont want to delete the repetitions to as
1 3 3
  

is a new susbet
  

  

A bad
(2^n)*log(2^n) solution
  

unordered sets will not work here as unordered_set<vector<int>> is not hashable

# Algorithm
1.  If we leave an element in once choice, actually we leave all its occurences


```cpp
void f(vector<vector<int>> &ans, vector<int> &temp, vector<int> &v, int i){ 
    if(i==-1){ 
        ans.push_back(temp); 
        return; 
    } 
    temp.push_back(v[i]); 
    f(ans,temp,v,i-1); 
    temp.pop_back(); 
    int curr=v[i]; 
    while(i>=0 and v[i]==curr) i--;  
    f(ans,temp,v,i); 
} 
vector<vector<int>> subsetsWithDup(vector<int>& v) { 
    int n=v.size(); 
    sort(v.begin(),v.end()); 
    vector<vector<int>> ans; 
    vector<int> temp; 
    f(ans,temp,v,n-1); 
    return ans; 
} 
```
