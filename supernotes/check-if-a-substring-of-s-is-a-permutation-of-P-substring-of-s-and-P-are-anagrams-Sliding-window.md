
```cpp
vector<int> findAnagrams(string b, string s) {
    int ws=s.size(),n=b.size();
    if(n<ws) return {};
    unordered_map<char, int> ms,md;  
    for(char c: s) ms[c]++;

    for(int i=0;i<=ws-2;i++){ 
        md[b[i]]++; 
    }

    vector<int> ans;
    for(int i=ws-1;i<n;i++){ 
        md[b[i]]++; 
        if(ms==md) ans.push_back(i-ws+1); 
        md[b[i-ws+1]]--; 
        if(md[b[i-ws+1]]==0){ 
            md.erase(b[i-ws+1]); 
        } 
    }
    return ans;                 
}
```
