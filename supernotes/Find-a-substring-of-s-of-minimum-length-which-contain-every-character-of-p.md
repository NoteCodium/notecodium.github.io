



# A little less expensive

```cpp
string minWindow(string s2, string s1) {
    int big=s2.size(),small=s1.size();
    unordered_map<char,int> fsmall, fbig;
    for(char c: s1){
        fsmall[c]++;
    }
    int disChar=fsmall.size();
    int count=0,l=0,h;
    //finding first substring in s2 which have all the char of s1
    for(int i=0;i<big;i++){
        fbig[s2[i]]++;
        if(fsmall[s2[i]]==fbig[s2[i]]) count++;
        if(count==disChar){
            h=i;
            break;
        }
    }
    if(count<disChar) return "";
    int lans=l,hans=h,minn=h-l+1;
    //starting trimming
    while(h<big){
        while(fbig[s2[l]]>fsmall[s2[l]]){
            fbig[s2[l]]--;
            l++;
        }
        if(h-l+1<minn){
            minn=h-l+1;
                lans=l;
                hans=h; 
            }
        h++;
        if(h<big) fbig[s2[h]]++;
    }
    return s2.substr(lans,minn);
}
```
