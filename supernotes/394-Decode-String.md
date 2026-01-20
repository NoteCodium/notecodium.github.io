[Just a moment...](https://leetcode.com/problems/decode-string/description/)








```cpp
string decodeString(string s) {
    stack<char> st;
    int n=s.size();
    for(int i=0;i<n;i++){
        char c=s[i];
        if(c!=']') st.push(c);
        else{
            string tmp;
            while(st.top()!='['){
                tmp=st.top()+tmp;
                st.pop();
            }
            st.pop();
            string tmpNum;
            while(!st.empty() and isdigit(st.top())){
                char di=st.top();st.pop();
                tmpNum.push_back(di);
            }
            reverse(tmpNum.begin(),tmpNum.end());
            int dig=stoi(tmpNum);
            string decoded;
            while(dig--){
                decoded+=tmp;
            }
            int tn=decoded.size();
            for(int i=0;i<tn;i++) st.push(decoded[i]);
        }
    }

    string ans;
    while(!st.empty()){
        ans = st.top() + ans;
        st.pop();
    }
    return ans;
}
```
