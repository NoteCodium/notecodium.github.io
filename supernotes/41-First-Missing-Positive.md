[Just a moment...](https://leetcode.com/problems/first-missing-positive/description/)

```cpp
vector<int> sort(vector<int> &v) {
int n=v.size();
for(int i=0;i<n;i++){
    while(v[i]>0 and v[i]<=n and v[i]!=i+1 and v[v[i]-1]!=v[i]){
        int idx=v[i]-1;
        swap(v[i],v[idx]);
    }
}
return v;
}

int firstMissingPositive(vector<int>& v) {
    v=sort(v);
    int n=v.size();
    for(int i=0;i<n;i++){
        if(i+1!=v[i]) return i+1;
    }
    return n+1;
}
```
