# PPA


Longest substring without repetitions of any char


```python
unordered_map<char,int> m;
int l=0,h=0,ans=1;
m[h[0]]++;
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

Find a substring of s of minimum length which contain every character of p   
https://leetcode.com/problems/minimum-window-substring/


```python
class Solution {
    public:
        string minWindow(string s, string t) {
            unordered_map<char,int> mapStatic,mapDynamic;
            for(char c: t){
                mapStatic[c]++;
            }
            int disChar=mapStatic.size();
            //finding first substring in s which have all the char
            //in the right amount
            int cnt=0;
            int l=0,h=0;
            while(h<s.size()){
                mapDynamic[s[h]]++;
                if(mapDynamic[s[h]]==mapStatic[s[h]]){
                    cnt++;
                }
                if(cnt==disChar){
                    break;
                }
                h++;
            }
            if(cnt<disChar){
                return "";
            }
            int lans=l,minLen=h-l+1;
            //Starting the trimming operation for getting the min most length
        
            while(h<s.size()){
                while(mapDynamic[s[l]]>mapStatic[s[l]]){
                    mapDynamic[s[l]]--;
                    l++;
                }
                if(h-l+1<minLen){
                    minLen=h-l+1;
                        lans=l;
                    }
                h++;
                if(h<s.size()){
                    mapDynamic[s[h]]++;
                }
            }
            return s.substr(lans,minLen);
        }
};
    
```



