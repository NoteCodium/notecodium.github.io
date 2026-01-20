prefix: polish
postfix reverse polish (easy)

https://leetcode.com/problems/evaluate-reverse-polish-notation/

```
int evalRPN(vector<string> &vos){
  stack<int> st;
  for(string s: vos){
    if(s=="+" or s=="-" or s=="/" or s=="*"){
      int op2=st.top();
      st.pop();
      int op1=st.top();
      st.pop();
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
    else{
      st.push(stoi(s));
    }
  }
   return st.top();
}

```

