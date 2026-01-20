[leetcode.com](https://leetcode.com/problems/stone-game-iii/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/22b2e2d0-9ecc-493e-9b58-8c6277785ce7--image.png)

```cpp
int f(vector<int> &v, int idx){
    if(idx>=v.size()) return 0;
    int ans=v[idx]-f(v,idx+1);
    if(idx+1<n) ans=max(ans,v[idx]+v[idx+1]-f(v,idx+2));
    if(idx+2<n) ans=max(ans,v[idx]+v[idx+1]+v[idx+2]-f(v,idx+3));
    return ans;
}

string stoneGameIII(vector<int>& v) {
    int diff=f(v,0);
    if(diff>0) return "Alice";
    else if(diff==0) return "Tie";
    else return "Bob";
}
```
