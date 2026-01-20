[Maximum Number That Sum of the Prices Is Less Than or Equal to K - LeetCode](https://leetcode.com/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/)

```CPP
long long sum(long long m, int x){
    long long ans=0;
    long long tot=m+1;
    for(int i=x;i<53;i+=x){
        long long full=tot/(1ll<<(i));
        long long left=tot%(1ll<<(i));
        long long extra=max(left-(1ll<<(i-1)),0ll);
        ans+=full*(1ll<<(i-1))+extra;
    }
    return ans;
}

long long findMaximumNumber(long long k, int x) {
    long long l=0, h=1e15,ans=-1;
    while(l<=h){
        long long m=(l+h)/2;
        if(sum(m,x)<=k){
            ans=m;
            l=m+1;
        }
        else h=m-1;
    }
    return ans;
}
```
