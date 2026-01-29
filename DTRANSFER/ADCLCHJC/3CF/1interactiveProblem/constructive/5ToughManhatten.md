---
title: 5ToughManhatten
---

{% raw %}
https://codeforces.com/contest/1934/problem/C

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0001.png)

# Manhatten distance

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0002.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0003.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0004.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0005.png)

from the property if triangle

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0006.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0007.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0008.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0009.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0010.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0011.png)

# Implementation

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_3CF_1interactiveProblem_constructive_5ToughManhatten__att_0012.png)

```python
#include <bits/stdc++.h>

using namespace std;

int ask(int x, int y) {
    cout<<"? "<<x<<" "<<y<<endl;

    int ans;
    cin>>ans;

    return ans;
}

void tell(int x, int y) {
    cout<<"! "<<x<<" "<<y<<endl;
}

int main() {
    int t;
    cin>>t;

    while(t--) {
        int n, m;
        cin>>n>>m;

        int a = ask(1, 1); 
        //! atleast one of the mines lie on the diagonal given by the equation x + y = a + 2

        //* now finding the two endpoints of the diagonal
        //* perform casework on pen-paper to understand why this works

        int xd1 = max(1, a + 2 - m), yd1 = a + 2 - xd1;
        int yd2 = max(1, a + 2 - n), xd2 = a + 2 - yd2;

        //* query from both the endpoints
        int ad1 = ask(xd1, yd1);
        int ad2 = ask(xd2, yd2);


        //* check if either of them is equal to 0, in which case that point is a mine
        if(ad1 == 0) {
            tell(xd1, yd1);
            continue;
        }

        if(ad2 == 0) {
            tell(xd2, yd2);
            continue;
        }

        //* calculate the coordinates of the points based on their distance from the given endpoints of diagonal

        int xp1 = xd1 + (ad1 / 2), yp1 = yd1 - (ad1 / 2);
        int xp2 = xd2 - (ad2 / 2), yp2 = yd2 + (ad2 / 2);

        //* atleast one of them should return 0 distance when queried
        if(ask(xp1, yp1) == 0) {
            tell(xp1, yp1);
        }
        else {
            tell(xp2, yp2);
        }
    }

    return 0;
}
```

```python
using namespace std;
#include<bits/stdc++.h>
#define ll long long
#define inf 9*1e18
#define it(v) v.begin(),v.end() 
#define nl '\n'
#define vl vector<ll>
#define vd vector<long double>
#define vvl vector<vector<ll>>
#define vvd vector<vector<long double>>
#define iinp(x) ll x; cin>>x; cin.ignore(); 
#define vinp(name,size) vector<ll>name (size); for(int i=0;i<size;i++) {cin>>name[i];cin.ignore();}
#define sinp(x) string x; getline(cin,x);
void priv(vector<ll> &v){for(int i=0;i<v.size();i++){cout<<v[i]<<" ";}cout<<'\n';}
template<typename... T> void pri(T&&... args){((cout << args <<" "), ...);cout<<'\n';}
template<typename... T> void inp(T&... args){((cin >> args && cin.ignore()), ...);}
#define lld long double
#define ull unsigned long long  
void _pri(int t) {cerr << t<<'\n';}
void _pri(ll t) {cerr << t<<'\n';}
void _pri(string t) {cerr << t<<'\n';}
void _pri(char t) {cerr << t<<'\n';}
void _pri(lld t) {cerr << t<<'\n';}
void _pri(double t) {cerr << t<<'\n';}
void _pri(ull t) {cerr << t<<'\n';}  
template <class T, class V> void _pri(pair <T, V> p);
template <class T> void _pri(vector <T> v);
template <class T> void _pri(set <T> v);
template <class T, class V> void _pri(map <T, V> v);
template <class T> void _pri(multiset <T> v);
template <class T, class V> void _pri(pair <T, V> p) {_pri(p.first); cerr << " "; _pri(p.second); cerr << '\n';}
template <class T> void _pri(vector <T> v) {for (T i : v){_pri(i);}cerr <<'\n';}    
template <class T> void _pri(set <T> v) {for (T i : v) {_pri(i); } cerr << '\n';}
template <class T> void _pri(multiset <T> v) {for (T i : v) {_pri(i);} cerr << '\n';}
template <class T, class V> void _pri(map <T, V> v) {for (auto i : v) {_pri(i);} cerr <<'\n';}
#define mod 1000000007
ll moda(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a + b) % cm) + cm) % cm;}
ll modm(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a * b) % cm) + cm) % cm;}
ll mods(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (((a - b) % cm) + cm) % cm;}
int mpow(int base, int exp, long long cmod=mod){base %= cmod;long long result = 1;while (exp > 0) {if (exp & 1) result = ((long long)result * base) % cmod;base = ((long long)base * base) % cmod;exp >>= 1;}return result;}    
ll inv(ll a, ll m) {return mpow(a, m - 2, m);}
ll modd(ll a, ll b, ll cm=mod) {a = a % cm; b = b % cm; return (modm(a, inv(b, cm), cm) + cm) % cm;}
bool isValid(ll r, ll c , ll rr, ll cc){return r>=0 and r<rr and c>=0 and c<cc;	}
// #define int ll
// #define ll int
// cout << fixed << setprecision(6) << ans << "\n";

/*


*/
int ask(int x, int y) {
    cout<<"? "<<x<<" "<<y<<endl;

    int ans;
    cin>>ans;

    return ans;
}

void tell(int x, int y) {
    cout<<"! "<<x<<" "<<y<<endl;
}

void solve(){
    
}

void testcases(){
    int ttt;
    ttt=1;
    cin>>ttt;cin.ignore();
    //precomputaion



    //precomputaion
    for(ll i=1;i<=ttt;i++){
        solve();        
    }

    cerr<<(float)clock()/CLOCKS_PER_SEC<<" secs"<<endl;
}

void initiate(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    #ifndef ONLINE_JUDGE
    freopen("/Users/tarunmali/yTM/code/cpp/2/2025/presentWorkingDirectory/input.txt", "r", stdin);
    freopen("/Users/tarunmali/yTM/code/cpp/2/2025/presentWorkingDirectory/output.txt", "w", stdout);
    freopen("//Users/tarunmali/yTM/code/cpp/2/2025/presentWorkingDirectory/error.txt", "w", stderr);
    #endif
}
int32_t main(){
    initiate();
    testcases();
}
```
{% endraw %}
