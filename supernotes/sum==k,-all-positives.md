# No. of subarray

[CSES - Subarray Sums I](https://cses.fi/problemset/task/1660)

Ekdam similar to basic

```cpp
void solve(){
    ll n,k;
    inp(n,k);
    vinp(v,n);

    ll l = 0, h = 0;
    ll sum = 0,ans=0;
 
    while(h < n) {
        sum += v[h];
        while (sum > k && l < h) {
            sum -= v[l];
            l++;              
        }
        if (sum == k) ans++;
        h++;
    }
    pri(ans);
}
```









##  All elements are positive 
f(k) - f(k-1)

f(k) => no. of elements with sum<=k



# Longest subarray
[Coding Ninjas Studio](https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems)

```cpp
int longestSubarrayWithSumK(vector<int> v, long long k) {
    int n=v.size();
    int l = 0, h = 0;
    long long sum = 0;
    int ans=0;

    while (h < n) {
        sum += v[h];
        while (sum > k && l < h) {
            sum -= v[l];
            l++;
        }
        if (sum == k) ans=max(ans,h-l+1);              
        h++;
    }
    return ans;
}
```



# Return idx of any of such subarray
[Find Indexes of a subarray with given sum | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1)



```cpp
vector<int> subarraySum(vector<int>& v, int n, int k) {
    int l = 0, h = 0;
    long long sum = 0;
    while (h < n) {
        sum += v[h];
        while (sum > k && l < h) {
            sum -= v[l];
            l++;
        }
        if (sum == k) return {l + 1, h + 1};
        h++;
    }

    return {-1};
}
```

