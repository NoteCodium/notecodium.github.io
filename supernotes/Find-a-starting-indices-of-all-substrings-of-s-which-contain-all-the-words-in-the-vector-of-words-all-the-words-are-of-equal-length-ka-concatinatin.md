![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/f02fde4a-3381-4b03-90df-327fc10d841a--image.png)


```cpp
vector<int> findSubstring(string b, vector<string>& vos) {
    int n=b.size();
    int l=vos[0].size();
    int N=vos.size();
    int ws=l*N;
    if(n<ws) return {};
    vector<int> ans;
    unordered_map<string, int> ms,md;
    for(string ss: vos) ms[ss]++;
    for(int i=0;i<=n-ws;i++){ 
        for(int j=i;j<i+ws;j+=l){ 
            md[b.substr(j,l)]++;   
        }
        if(ms==md) ans.push_back(i);
        md.clear();
    }
    return ans;
}
```




# Better solution
[easy ||fast || accurate ||c++||master - undefined - LeetCode](https://leetcode.com/problems/substring-with-concatenation-of-all-words/solutions/4221794/easy-fast-accurate-c-master/)

 # More better solution by rolling hashing
