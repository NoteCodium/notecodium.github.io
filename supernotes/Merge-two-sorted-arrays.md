
```cpp
vector<int> merge(vector<int>& v1, vector<int>& v2){
    int n1=v1.size();
    int n2=v2.size();
    vector<int> tmp;
    int i=0,j=0;
    while(i<n1 and j<n2){
        if(v1[i]<v2[j]) tmp.push_back(v1[i++]);
        else tmp.push_back(v2[j++]);
    }
    while(i<n1) tmp.push_back(v1[i++]);
    while(j<n2) tmp.push_back(v2[j++]);
    return tmp;
}
```

# In constant space, typcial interview
