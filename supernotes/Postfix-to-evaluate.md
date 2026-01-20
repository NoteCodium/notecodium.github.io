


# Evaluate postfix
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/aff20fb5-be12-4c34-8ccf-50ab48885344--image.png)

[Evaluate Reverse Polish Notation - LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

```cpp
int evalRPN(vector<string>& vos) {
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
```