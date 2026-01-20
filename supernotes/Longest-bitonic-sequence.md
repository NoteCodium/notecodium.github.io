[Longest Bitonic subsequence | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1)

```cpp
int LongestBitonicSequence(vector<int>v)
{
    int n=v.size();
    vector<int> dpi(n,1),dpd(n,1);
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(v[j]<v[i] and dpi[j]+1>dpi[i]) dpi[i]=dpi[j]+1;
        }
    }
    
    for(int i=n-2;i>=0;i--){
        for(int j=n-1;j>i;j--){
            if(v[j]<v[i] and dpd[j]+1>dpd[i]) dpd[i]=dpd[j]+1;
        }
    }    
    
    
    int ans=1;
    for(int i=0;i<n;i++) ans=max(ans,dpi[i]+dpd[i]-1);
    return ans;
}
```
