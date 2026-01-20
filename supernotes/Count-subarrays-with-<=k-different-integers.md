
```cpp
int f(vector<int>& v, int k){
    int n=v.size();
    int l=0,h=0,ans=0;
    unordered_map<int,int> m;
    while(h<n){
            //sum+=v[h]; 
            //change the property
            m[v[h]]++;
            while(m.size()>k and l<h){
            //this is not the condition of answer
            m[v[l]]--;
            if(m[v[l]]==0) m.erase(v[l]);
            l++;
        }
        if(m.size()<=k) ans+=(h-l+1); 
        h++;  
    }
    return ans;
}
```
