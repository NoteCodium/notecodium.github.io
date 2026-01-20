[Longest Repeating Character Replacement - LeetCode](https://leetcode.com/problems/longest-repeating-character-replacement/description/)
ver1
Given a string with lowercase letters only, if you are allowed to **replace no more than ‘k’ letters** with any letter, find the **length of the longest substring having the same letters** after replacement.



```cpp
int f(auto &m){
    int maxx=INT_MIN;
    for(auto p: m){
        maxx=max(maxx,p.second);
    }
    return maxx;
}

int characterReplacement(string s, int k) {
//length of largest subarray having <=k different letters
    unordered_map<char,int> m;
    int l=0,h=0;
    int n=s.size();
    int ans=1;
    while(h<n){
        m[s[h]]++;
        while((h-l+1)-f(m)>k and l<=h){
            m[s[l]]--;
            if(m[s[l]]==0) m.erase(s[l]);
            l++;
        }
        if((h-l+1)-f(m)<=k and l<=h) ans=max(ans,h-l+1);
        h++;
    }
    return ans;
}
```
 ver2
```cpp
int f(unordered_map<char,int> &m){
    int maxx=INT_MIN;
    for(auto p: m){
        maxx=max(maxx,p.second);
    }
    return maxx;
}

int characterReplacement(string s, int k) {
//length of largest subarray having <=k different letters
    unordered_map<char,int> m;
    int l=0,h=0;
    int n=s.size();
    int ans=1;
    while(h<n){
        m[s[h]]++;
        while((h-l+1)-f(m)>k and l<=h){
            m[s[l]]--;
            if(m[s[l]]==0) m.erase(s[l]);
            l++;
        }
        if((h-l+1)-f(m)<=k and l<=h) ans=max(ans,h-l+1);
        h++;
    }
    return ans;

}
```



------------------------------------------------------
```cpp
void updateMaxCnt(int maxCnt, unordered_map<char,int> m){
    for(auto p: m) maxCnt=max(maxCnt,p.second);
}

int characterReplacement(string s, int k) {
    unordered_map<char,int> m;
    int ans=1;
    int n=s.size();
    int l=0,h=0;
    int maxCnt=0;
    while(h<n){
        m[s[h]]++;
        maxCnt=max(maxCnt,m[s[h]]);
        while((h-l+1)-maxCnt>k){
            m[s[l]]--;
            l++;
            updateMaxCnt(maxCnt,m);
        }
        ans=max(ans,h-l+1);
        h++;
    }
    return ans;
}
```


[Longest Repeating Character Replacement - Leetcode 424 - Python - YouTube](https://youtu.be/gqXU1UyA8pk?si=xHsnDmxdXzR5ozfe)

```cpp
int characterReplacement(string s, int k) {
    unordered_map<char,int> m;
    int ans=1;
    int n=s.size();
    int l=0,h=0;
    int maxCnt=0;
    while(h<n){
        m[s[h]]++;
        maxCnt=max(maxCnt,m[s[h]]);
        while((h-l+1)-maxCnt>k){
            m[s[l]]--;
            l++;
        }
        ans=max(ans,h-l+1);
        h++;
    }
    return ans;
}
```

