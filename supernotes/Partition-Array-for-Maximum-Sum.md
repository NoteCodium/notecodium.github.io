[leetcode.com](https://leetcode.com/problems/partition-array-for-maximum-sum/description/)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5c0a5bee-5e1a-4f16-a5b4-3f0b4e5a1fa6--image.png)

```CPP
int f(int idx, vector<int>& v, int k, int n){
    if(idx==n) return 0;
    int len=0;
    int currmax=INT_MIN;
    int ans=INT_MIN;
    for(int i=idx;i<min(n,idx+k);i++){
        len++;
        currmax=max(currmax,v[i]);
        int sum=len*currmax + f(i+1,v,k,n);
        ans=max(ans,sum);
    }
    return ans;
}


int maxSumAfterPartitioning(vector<int>& v, int k) {
    int n=v.size();
    return f(0,v,k,n);
}
```