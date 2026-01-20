maximise the len of the subarray

```cpp
int longestSubarray(vector<int>& v) {
    int n=v.size();
    int maxx = *max_element(v.begin(),v.end());
    int len=0;
    int maxlen=0;
    
    for(int i=0;i<n;i++){
        if(v[i]==maxx) len++;
        else len=0;
        maxlen=max(maxlen,len);
    }
    return maxlen;
}
```