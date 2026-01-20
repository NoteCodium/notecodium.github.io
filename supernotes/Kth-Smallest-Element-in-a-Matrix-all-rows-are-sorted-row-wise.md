```cpp
int f(int m,vector<vector<int>>& ma){ 
    int n=ma.size(); 
    int count=0; 
    for(int i=0;i<n;i++){ 
        vector<int> &v=ma[i]; 
        count+=(upper_bound(it(v),m)-v.begin());
    } 
    return count; 
}
```

```cpp
int kthSmallest(vector<vector<int>>& ma, int k) { 
    int n=ma.size(); 
    int m,l=colunmn_minmax(ma,0).first,h=colunmn_minmax(ma,n-1).second,ans; 
    while(l<=h){ 
        m=(l+h)/2; 
        if(f(m,ma)>=k){ 
            ans=m; 
            h=m-1; 
        } 
        else l=m+1; 
    } 
    return ans; 
    
} 
```

```cpp
pair<int,int> colunmn_minmax(vector<vector<int>>& ma, int c){ 
    int maxx=INT_MIN,minn=INT_MAX; 
    int rr=ma.size(),cc=ma[0].size(); 
    for(int r=0;r<rr;r++){ 
        maxx=max(maxx,ma[r][c]); 
        minn=min(minn,ma[r][c]); 
    } 
    return {minn,maxx}; 
} 
```

