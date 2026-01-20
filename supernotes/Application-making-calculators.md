# Universal with brackets
[](https://leetcode.com/problems/basic-calculator/description/)

```cpp
    int prec(string c){
        if(c=="^") return 3;
        if(c=="*" or c=="/") return 2;
        if(c=="+" or c=="-") return 1;
        return 0;
    }


    vector<string> i2p(string &s) {
    vector<string> ans;
    stack<string> st;
    int n = s.size();
    int i = 0;

    while (i < n) {
        char c = s[i];
        string tmp;

        if (isdigit(s[i])) {
            while (i < n && isdigit(s[i])) {
                tmp.push_back(s[i]);
                i++;
            }
            ans.push_back(tmp);
        } else if (c == '(') {
            st.push("(");
            i++;
        } else if (c == ')') {
            while (!st.empty() && st.top() != "(") {
                ans.push_back(st.top());
                st.pop();
            }
            if (!st.empty()) {
                st.pop();
            }
            i++;
        } else {
            string tmp(1, c);
            while (!st.empty() && prec(st.top()) >= prec(tmp)) {
                ans.push_back(st.top());
                st.pop();
            }
            st.push(tmp);
            i++;
        }
    }

    while (!st.empty()) {
        ans.push_back(st.top());
        st.pop();
    }
    
    return ans;
    
}

    void removeSpace(string &s){
        string ans;
        int n=s.size();
        for(int i=0;i<n;i++){
            if(s[i]!=' ') ans.push_back(s[i]);
        }
        s=ans;
    }

    void insertZero(string &s){
        string ans;
        int n=s.size();
        for(int i=0;i<n;i++){
            ans.push_back(s[i]);
            if(i+1<n and s[i+1]=='-' and !isdigit(s[i])) ans.push_back('0');
        }
        s=ans;
    }

int eval(vector<string>& vos) {
    stack<int> st;
    for(string s: vos){
        if(s=="+" or s=="-" or s=="/" or s=="*"){
            int op2=st.top();
            st.pop();
            int op1=st.top();
            st.pop();
            switch(s[0]){
                case '+':
                    st.push(op1+op2);
                    break;
                case '-':
                    st.push(op1-op2);
                    break;
                case '*':
                    st.push(op1*op2);
                    break;
                case '/':
                    st.push(op1/op2);
                    break;                    
            }
        }
        else{
            st.push(stoi(s));
        }
    }
    return st.top();
}


    int calculate(string s) {
        removeSpace(s);
        insertZero(s);
        vector<string> tmp= i2p(s);
        return eval(tmp);
    }
```
