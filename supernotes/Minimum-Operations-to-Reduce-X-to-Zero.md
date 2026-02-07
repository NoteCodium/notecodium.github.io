[Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)

![image.png](../images/e784b1b4-9953-48b4-8a4f-8ff0fe35a87a--image.png)


![image.png](../images/c3215b41-41f6-4f5a-8775-f4b30d0ab745--image.png)


```cpp
int f(vector<int> &v, int k) {
    int n=v.size();
    int l = 0, h = 0;
    long long sum = 0;
    int ans=0;

    while (h < n) {
        sum += v[h];
        if (sum == k) ans=max(ans,h-l+1);
        while (sum > k && l < h) {
            sum -= v[l];
            l++;
            if (sum == k) ans=max(ans,h-l+1);              
        }
        h++;
    }
    return ans;
}

int minOperations(vector<int>& v, int x) {
    int n=v.size();
    int sum=accumulate(v.begin(),v.end(),0);
    if(sum==x) return n;
    int res=f(v,sum-x);
    return res==0?-1:n-res;
}
```
