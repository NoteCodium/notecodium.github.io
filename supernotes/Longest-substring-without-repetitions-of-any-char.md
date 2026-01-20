[Longest Substring Without Repeating Characters - LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)


1. increase h as long as we are getting new characters
2. Once characters starts repeating by increasing h, we start trimming and again check on next iteration whether increasing h will help us or not

```cpp
unordered_map<char,int> m;
int l=0,h=0,ans=1;
m[s[0]]++;
while(h<=n-2){
  if(m[s[h+1]]==0){
    h++;
    ans=max(ans,h-l+1);
    m[s[h]]++;
  }
  else{
    m[s[l]]--;
    l++;
  }
}
```

