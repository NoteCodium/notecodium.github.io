---
title: 37HouseRobber
---

{% raw %}
https://leetcode.com/problems/house-robber/description/  
adjacent house have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

```python
class Solution {
public:
    int f(int idx,  vector<int> &v, vector<int> &mem){
        if(idx<0) return 0;
        if(idx==0) return v[0];
        if(mem[idx]!=-1) return mem[idx];
        return mem[idx]=max(f(idx-2,v,mem)+v[idx],f(idx-1,v,mem));
    }

    int rob(vector<int>& v){
        int n=v.size();
        vector<int> mem(n,-1);
        return f(n-1,v,mem);
    }
};
```

```python
class Solution {
    public:
        int rob(vector<int>& v){
            int n=v.size();
            vector<int> dp(n+1);
            dp[0]=0;
            dp[1]=v[0];
            for(int i=2;i<=n;i++){
                dp[i]=max(dp[i-2]+v[i-1],dp[i-1]);
            }
            return dp[n];
        }
    };
```

# Priyansh

```python
//priyansh
dp[0]=0
dp[1]=v[0]
dp[n]=Ans
dp[i]=max(dp[i-1],v[i-1]+dp[i-2])
```

```python
//priyansh
vector<int> dp(n+1);
dp[0]=0;
dp[1]=v[0];
for(int i=2;i<=n;i++) dp[i]=max(dp[i-1],v[i-1]+dp[i-2]);
return dp[n]
```

q. circular house robber  
https://leetcode.com/problems/house-robber-ii/description/

```python
int robHelp(vector<int>& v) { 
    int n=v.size(); 
    vector<int> dp(n+1); 
    dp[0]=0; 
    dp[1]=v[0];
    for(int i=2;i<=n;i++) dp[i]=max(dp[i-1],v[i-1]+dp[i-2]);
    return dp[n];
} 
int rob(vector<int>& v){
    int n=v.size();
    if(n==1) return v[0];
    int tmp=v[0];
    v[0]=0;
    int max1=robHelp(v);
    v[0]=tmp;
    v[n-1]=0;
    int max2=robHelp(v);
    return max(max1,max2);   
}
```

# Pizza With 3n Slices

https://leetcode.com/problems/pizza-with-3n-slices/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_1Basics_37HouseRobber__att_0001.png)

kind of house robber but the only constrained is that you can pick exactly n/3 elemenets

# CF

https://codeforces.com/problemset/problem/455/A

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_40DP_1Basics_37HouseRobber__att_0002.png)

```python
void solve() {  
    //delete x
    //point x
    iinp(n);
    vinp(v,n);
    ll maxx=*max_element(it(v));
    vl cnt(maxx+1,0);
    for(ll x: v){
        cnt[x]++;
    }
    vl dp(maxx+1,0);
    dp[0]=0;
    dp[1]=1*cnt[1];
    for(int i=2;i<=maxx;i++){
        dp[i]=max(dp[i-1],dp[i-2]+cnt[i]*i);
    }
    pri(dp[maxx]);

}
```
{% endraw %}
