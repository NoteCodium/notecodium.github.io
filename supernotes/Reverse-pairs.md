[leetcode.com](https://leetcode.com/problems/reverse-pairs/description/)

```cpp
void merge(vector<int> &v, int l, int m, int r, int &ans){
    int p1=l,p2=m+1;
    while(p2<=r){
        while(p1<=m and v[p1]*0.5<=v[p2]*1.0) p1++;
        ans+=(m-p1+1);
        p2++;
    }
    p1=l,p2=m+1;
    vector<int> tmp;
    while(p1<=m and p2<=r){
        if(v[p1]<=v[p2]) tmp.push_back(v[p1++]);
        else tmp.push_back(v[p2++]);
    }
    while(p1<=m) tmp.push_back(v[p1++]);
    while(p2<=r) tmp.push_back(v[p2++]);
    for(int i=l;i<=r;i++) v[i]=tmp[i-l];
}


void mergeSort(vector<int> &v, int &ans, int l, int r){
    if(l==r) return;
    int m=(l+r)/2;
    mergeSort(v,ans,l,m);
    mergeSort(v,ans,m+1,r);
    merge(v,l,m,r,ans);
}


int reversePairs(vector<int>& v) {
    int ans=0,n=v.size();
    mergeSort(v,ans,0,n-1);
    return ans;
}
```
