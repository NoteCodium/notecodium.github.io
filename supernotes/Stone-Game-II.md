[leetcode.com](https://leetcode.com/problems/stone-game-ii/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/57d11ecf-3b51-4897-9007-1a0d7a38f1fd--image.png)



```cpp
int f(int idx, int m, vector<int> &v){
    if(idx>=v.size()) return 0;
    int tot=0;
    int ans=INT_MIN;
    for(int i=0;i<2*m;i++){
        if(idx+i<v.size()) tot+=v[idx+i];
        ans=max(ans,tot-f(idx+i+1,max(m,i+1),v));
    }
    return ans;
}

int stoneGameII(vector<int>& v) {
    int sum=accumulate(v.begin(),v.end(),0);
    int diff=f(0,1,v);
    return (sum+diff)/2;
}
```

```cpp
int f(int idx, int m, vector<int> &v, vector<vector<int>> &mem){
    if(idx>=v.size()) return 0;
    if(mem[idx][m]!=-1) return mem[idx][m];
    int tot=0;
    int ans=INT_MIN;
    for(int i=0;i<2*m;i++){
        if(idx+i<v.size()) tot+=v[idx+i];
        ans=max(ans,tot-f(idx+i+1,max(m,i+1),v,mem));
    }
    return mem[idx][m]=ans;
}

int stoneGameII(vector<int>& v) {
    int sum=accumulate(v.begin(),v.end(),0);
    int n=v.size();
    vector<vector<int>> mem(n,vector<int>(n+1,-1));
    int diff=f(0,1,v,mem);
    return (sum+diff)/2;
}
```
