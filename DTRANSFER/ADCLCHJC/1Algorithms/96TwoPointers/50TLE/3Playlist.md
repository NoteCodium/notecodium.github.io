---
title: 3Playlist
---

{% raw %}
https://codeforces.com/edu/course/2/lesson/9/3/practice/contest/307094/problem/A

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_96TwoPointers_50TLE_3Playlist.IPYNB__att_0001.png)

```python
#include<bits/stdc++.h>
using namespace std;
 
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define int long long
#define ld long double
#define pb push_back
#define ff first
#define ss second
#define lb lower_bound
#define ub upper_bound
#define cout(v) for(auto i:v){cout<<i<<" ";}cout<<endl;
#define gcd(a,b) __gcd(a,b);
#define cin(v) for(auto &i:v){cin>>i;}
#define all(a) a.begin(),a.end()
#define rall(a) a.rbegin(),a.rend()
const int N=2*1e5+3;
const int mod=1e9+7;
const int mod1=998244353;
long double eps=1e-5;
// function starts here------------------------------------------------------------------------------------ 

void solve()
{
    int n, p;
    cin >> n >> p;
    vector<int> a(n);
    int total_sum = 0;
    for (auto &i : a)
    {
        cin >> i;
        total_sum += i;
    }

    int full_loops = p / total_sum;
    int remaining = p % total_sum;
    if (remaining == 0)
    {
        cout << 1 << " " << full_loops * n << endl;
        return;
    }

    int start = -1, cnt = INT_MAX;
    for (int i = 0; i < n; i++)
    {
        int sum = 0;
        int j = i;
        int taken = 0;
        while (sum < remaining)
        {
            sum += a[j];
            taken++;
            j = (j + 1) % n;
        }
        if (taken < cnt)
        {
            cnt = taken;
            start = i;
        }
    }
    cout << start + 1 << " " << full_loops * n + cnt;
}

signed main(){
    fast
    // int tc;cin>>tc;
    // while(tc--){
        solve();
    // }
return 0;
}
```
{% endraw %}
