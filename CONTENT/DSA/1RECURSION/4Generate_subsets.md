1. Generate all subsets, if the set is 1 to n

```cpp
void f(int num){
  if(num==0){
    ans.push_back(tmp);
    return;
  }

//take
tmp.push_back(num);
f(num-1);
tmp.pop_back()

//not take
f(num-1);

}

int main(){
vector<vector<int>> ans;
vector<int> tmp;
f(n);
}

```

https://leetcode.com/problems/subsets/description/
1. Generate all subsets, of an array, the array has no repetitions


```cpp
void f(int idx, vector<vector<int>> &ans, vector<int> &tmp, vector<int> &v){
  if(idx<0){
    ans.push_back(tmp);
    return;
  }

//take
tmp.push_back(v[idx]);
f(idx-1.ans,tmp,v);
tmp.pop_back()

//not take
f(idx-1.ans,tmp,v);

}

int main(){
vector<vector<int>> ans;
vector<int> tmp;
f(n-1,ans,tmp,v);
```

1. Of size K

```cpp
void f(int idx, vector<vector<int>> &ans, vector<int> &tmp, vector<int> &v){
  if(cnt==0){
    ans.push_back(tmp);
    return;
  }
  if(idx<0){
    return;
  }

//take
tmp.push_back(v[idx]);
f(cnt-1,idx-1.ans,tmp,v);
tmp.pop_back()

//not take
f(cnt-1,idx-1.ans,tmp,v);

}

int main(){
vector<vector<int>> ans;
vector<int> tmp;
f(k-1,n-1,ans,tmp,v);


```

