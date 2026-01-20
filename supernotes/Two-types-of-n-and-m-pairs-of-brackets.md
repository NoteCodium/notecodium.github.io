[Programming Problems and Competitions :: HackerRank](https://www.hackerrank.com/contests/gl-bajaj-self-evaluation-evening-batch/challenges/bracket-challenge-1)


```cpp
#include <bits/stdc++.h>
using namespace std;


void rfs(int s1, int e1, int s2, int e2, string s, stack <char> &st, vector <string> &ans) {
    if(s1 + s2 + e1 + e2 == 0) {
        if(st.empty()) ans.push_back(s);
        return;
    }
    
    if(s1) {
        s.push_back('(');
        st.push('(');
        rfs(s1 - 1, e1, s2, e2, s, st, ans);
        // restore s and st
        s.pop_back();
        st.pop();
    }
    if(s2) {
        s.push_back('{');
        st.push('{');
        rfs(s1, e1, s2 - 1, e2, s, st, ans);
        // restore s and st
        s.pop_back();
        st.pop();
    }
    
    if(e1 and !st.empty() and st.top() == '(') {
        s.push_back(')');
        st.pop();
        rfs(s1, e1 - 1, s2, e2, s, st, ans);
        // restore s and st
        s.pop_back();
        st.push('(');
    }
    if(e2 and !st.empty() and st.top() == '{') {
        s.push_back('}');
        st.pop();
        rfs(s1, e1, s2, e2 - 1, s, st, ans);
        // restore s and st
        s.pop_back();
        st.push('{');
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);

    int n, m; cin >> n >> m;
    
    string s; stack <char> st; vector <string> ans;
    rfs(n, n, m, m, s, st, ans);
    
    for(auto &x : ans) cout << x << '\n';

    return 0;
}
```