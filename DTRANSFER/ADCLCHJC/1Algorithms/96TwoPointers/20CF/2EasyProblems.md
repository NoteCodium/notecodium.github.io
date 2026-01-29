---
title: 2EasyProblems
---

{% raw %}
Count subarrays with <=k different integers

```python
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

Count subarrays with <=k odd elements

```python
int f(vector<int>& v, int k){
    int n=v.size();
    int l=0,h=0,cnt=0,ans=0;
    while(h<n){
        //sum+=v[h]; 
        //change the property
            if(v[h]%2) cnt++;
            while(cnt>k and l<h){
            //this is not the condition of answer
            if(v[l]%2) cnt--;
            l++;
        }
        if(cnt<=k) ans+=(h-l+1); 
        h++;  
    }
    return ans;
}
```

Given a string with lowercase letters only, if you are allowed to **replace no more than ‘k’ letters** with any letter, find the **length of the longest substring having the same letters** after replacement.    

https://leetcode.com/problems/longest-repeating-character-replacement/description/

```python
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

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_20CF_2EasyProblems__att_0001.png)

```python
int numberOfSubstrings(string s) {
    int n=s.size();
    int l=0,h=0;
    vector<int> m(3,0);
    int ans=0;
    while(h<n){ 
        m[s[h]-'a']++;
        while(m[0] > 0 && m[1] > 0 && m[2] > 0 and l<=h){
            ans+=n-h;
            m[s[l]-'a']--;
            l++;
        }
        h++;
    }
    return ans;
}
```
{% endraw %}
