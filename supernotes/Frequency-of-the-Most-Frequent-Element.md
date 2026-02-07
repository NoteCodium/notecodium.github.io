[Just a moment...](https://leetcode.com/problems/frequency-of-the-most-frequent-element/)


![image.png](../images/82830e20-55b8-4c5e-91af-20bafeb08438--image.png)



![image.png](../images/31227545-9cef-4c37-b385-618a4eb6df6f--image.png)





```cpp
int maxFrequency(vector<int>& v, int k) {
    sort(v.begin(),v.end());
    int n=v.size();
    int l=0,h=0;
    long long sum=0;
    int ans=1;
    while(h<n){
        sum+=v[h];
        while(((long long)(h-l+1)*v[h])>sum+k){
            sum-=v[l];
            l++;
        }
        ans=max(ans,h-l+1);
        h++;
    }
    return ans;
}
```
