---
title: 3PPA
---

{% raw %}
check if a substring of s is a permutation of P     
(substring of s and P are anagrams)    
https://leetcode.com/problems/permutation-in-string/

```python
class Solution {
public:
    bool checkInclusion(string s, string b) {
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
        return ans.size();                 
    }
};
```

https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/    
Find a starting indices of all substrings of s which contain all the words   in the vector of words (all the words are of equal length) ka concatinatin   
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_3PPA__att_0001.png)

```python
class Solution {
    public:
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
            //choosing the starting index    
                for(int j=i;j<i+ws;j+=l){ 
                    md[b.substr(j,l)]++;   
                }
                if(ms==md) ans.push_back(i);
                md.clear();
            }
            return ans;
        }
    };
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_1SlidingWindow_3PPA__att_0002.png)   
https://leetcode.com/problems/substring-with-concatenation-of-all-words/solutions/4221794/easy-fast-accurate-c-master/
{% endraw %}
