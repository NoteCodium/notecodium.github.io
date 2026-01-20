operator operand operand

1. prefix to infix
https://practice.geeksforgeeks.org/problems/prefix-to-infix-conversion/1

```cpp
string preToInfix(string s) {
    stack<string> st;
    int n=s.size();
    for(int i=n-1;i>=0;i--){
        char c=s[i];
        if(c=='+' or c=='-' or c=='/' or c=='*'){
            string op1=st.top();
            st.pop();
            string op2=st.top();
            st.pop();
            st.push('('+op1+c+op2+')');                   
        }
        else{
            string myString(1, c);
            st.push(myString);
        }
    }
    return st.top();
}
```


