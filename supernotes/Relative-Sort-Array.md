https://leetcode.com/problems/relative-sort-array/

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/45189f7c-aa8a-4d36-8664-8bfb633c4f33--image.png)

# Brute force n1*n2

# Thodi se knowledge
```cpp
vector<int> relativeSortArray(vector<int>& v1, vector<int>& v2) {
    map<int,int> m;
    for(int x: v1) m[x]++;
    vector<int> ans;
    for(int x: v2){
        int cnt=m[x];
        while(cnt--){
            m[x]--;
            if(m[x]==0) m.erase(x);
            ans.push_back(x);
        }
    }
    for(auto p:m){
        int cnt=p.second;
        while(cnt--) ans.push_back(p.first);
    } 
    return ans;
}
```


[Custom Sort String - LeetCode](https://leetcode.com/problems/custom-sort-string/description/)

```cpp
unordered_map<char,int> m;
class Solution {
public:
    static bool cmp(char &a, char &b){
        return m[a]<m[b];
    }

    string customSortString(string o, string s) {
        int no=o.size();
        m.clear();
        for(int i=0;i<no;i++) m[o[i]]=i;
        sort(s.begin(),s.end(),cmp);
        return s;
    }
};
```