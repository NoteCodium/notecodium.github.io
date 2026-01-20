[Find all Missing Numbers (easy)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6393ada834689e585e94a1b9)

[Find All Numbers Disappeared in an Array - LeetCode](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/)

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
    if(v[i]!=i+1) ans.push_back(i+1);
}

return ans;
}
```
