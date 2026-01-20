[Solution: Problem Challenge 3: Find the First K Missing Positive Numbers](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63dd9609488110f74a922636)

```cpp
static vector<int> f(vector<int> &v) {
  int n=v.size();
  for(int i=0;i<n;i++){
      while(v[i]>0 and v[i]<=n and v[i]!=i+1 and v[v[i]-1]!=v[i]){
          int idx=v[i]-1;
          swap(v[i],v[idx]);
      }
  }
  return v;
}

static vector<int> findNumbers(vector<int> &v, int k) {
    v=f(v);
    vector<int> ans;
    int n=v.size();
    int cnt=0;
    vector<int> extra;
    for(int i=0;i<n;i++){
        if(i+1!=v[i]){
          ans.push_back(i+1);
          cnt++;
          if(cnt==k) break;
          extra.push_back(v[i]);
        }
    }
    int tmp=n;
    while(ans.size()<k){
        ++tmp;
        if(find(extra.begin(),extra.end(),tmp)==extra.end()) ans.push_back(tmp);       
    }

    return ans;
}
```
