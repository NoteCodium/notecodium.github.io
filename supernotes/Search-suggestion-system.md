# Example of real world application of binary search and two pointers




[leetcode.com](https://leetcode.com/problems/search-suggestions-system/description/)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2fb4e390-611c-432b-b45f-5db47f2fcd39--image.png)

[Search Suggestions System | Leetcode 1268 | Trie | Binary Seach - YouTube](https://youtu.be/lbfi2OZL0Ls?si=vB6T5fykD9R_ouqX)


1. Sort it
```cpp
int n=vos.size();
sort(vos.begin(),vos.end());
vector<vector<string>> ans;
int l=0,r=n-1;
for(int i=0;i<k.size();i++){
    char c=k[i];
    while(l<n){
        if(i<vos[l].size() and vos[l][i]==c) break;
        else l++;
    } 
    while(r>=0){
        if(i<vos[r].size() and vos[r][i]==c) break;
        else r--;
    } 
    vector<string> tmp;
    int rmin=r-l+1;
    for(int j=0;j<min(3,rmin);j++) tmp.push_back(vos[l+j]);
    ans.push_back(tmp);             
}
```
This is a highly scalable solution, where you can easily maintain how many products to be searched for

# With Bs : Binary search does prefix match under the hood, for equality use size concept
low scalable solution
```cpp
#define it(v) v.begin(), v.end()
class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string>& vos, string key) {
        int n=vos.size();
        sort(vos.begin(),vos.end());
        vector<vector<string>> ans;
        string prefix;
        for(char c: key){
            prefix.push_back(c);
            int l=lower_bound(it(vos),prefix)-vos.begin();
            vector<string> tmp;
            for(int i=l;i<min(l+3,n) and vos[i].substr(0,prefix.size())==prefix);i++){
                tmp.push_back(vos[i]);
            }
            ans.push_back(tmp);             
        }
        return ans;
    }
};
```

# With trie
[Search Suggestions System | Leetcode 1268 | Trie | Binary Seach - YouTube](https://youtu.be/lbfi2OZL0Ls?si=qVjM4A1Ld5Bqiei6)




