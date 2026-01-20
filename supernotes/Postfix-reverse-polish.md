operand operand operator

convert infix to postfix
mug up algorithm
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cb6d37c6-db46-466e-a3dc-a1472797678b--image.png)


[Infix to Postfix | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1)

```cpp
int prec(char c){
    if(c=='^') return 3;
    if(c=='*' or c=='/') return 2;
    if(c=='+' or c=='-') return 1;
    return 0;
}


string infixToPostfix(string s) {
    string ans;
    stack<char> st;
    for(char c: s){
        if(isalpha(c) or isdigit(c)) ans.push_back(c);
        else if(c=='(') st.push(c);
        else if(c==')'){
            while(!st.empty() and st.top()!='('){
                ans.push_back(st.top());st.pop();
            }
            if(!st.empty()){
                st.pop();
            } 
        }
        else{
            while(!st.empty() and prec(st.top())>=prec(c)){
                ans.push_back(st.top());
                st.pop();
            }
            st.push(c);
        }
    }
    
    while(!st.empty()){
        ans.push_back(st.top());st.pop();
    }
    return ans;
}
```


