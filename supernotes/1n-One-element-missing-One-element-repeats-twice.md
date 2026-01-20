1. xor with 1 to n
2. result= x^y   

Check ths


# Sorting method
Once we are done with the cyclic sort, we will iterate through the array to find the number that is not at the correct index. Since only one number got corrupted, the number at the wrong index is the duplicated number and the index itself represents the missing number.


```cpp
vector<int> sort(vector<int> &v) {
  int n=v.size();
  for(int i=0;i<n;i++){
    while(v[i]!=i+1 and v[v[i]-1]!=v[i]){
      int idx=v[i]-1;
      swap(v[i],v[idx]);
    }
  }
  return v;
}


vector<int> findNumbers(vector<int> &v) {
  v=sort(v);
  int n=v.size();
  vector<int> ans;
  for(int i=0;i<n;i++){
    if(v[i]!=i+1) return {v[i],i+1};
  }
  return {};
}
```

