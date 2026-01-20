
[Sorting Elements of an Array by Frequency | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0)
```cpp
int n;
cin>>n;
vector<int> v(n);
for(int i=0;i<n;i++){
    cin>>v[i];
} 
map<int,int,greater<int>> mFreq;
for(ll i=0;i<n;i++){
    mFreq[v[i]]++;
}   
vector<vector<int>> tmp;
for(auto p: mFreq){
    tmp.push_back({p.second,p.first});
}
sort(tmp.begin(),tmp.end(),cmp);
for(ll i=0;i<tmp.size();i++){
    int cnt=tmp[i][0];
    for(ll j=0;j<cnt;j++){
        cout<<tmp[i][1]<<" ";
    }            
}
cout<<'\n';
```