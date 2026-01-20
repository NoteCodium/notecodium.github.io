```cpp
int n;
cin>>n;
vector<int> v(n);
for(int i=0;i<n;i++){
    cin>>v[i];
} 
map<int,int,greater<int>> mFreq;
unordered_map<int,int> mInd;
for(ll i=0;i<n;i++){
    mFreq[v[i]]++;
    if(!mInd.count(v[i])) mInd[v[i]]=i;
}   
vector<vector<int>> tmp;
for(auto p: mFreq){
    tmp.push_back({p.second,mInd[p.first],p.first});
}
sort(tmp.begin(),tmp.end(),cmp);
for(ll i=0;i<tmp.size();i++){
    int cnt=tmp[i][0];
    for(ll j=0;j<cnt;j++){
        cout<<tmp[i][2]<<" ";
    }            
}
cout<<'\n';
```