[Minimum Insertions to Balance a Parentheses String - LeetCode](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/)

```
int minInsertions(string s) {
    int ans = 0;  // Total insertions
    int open = 0; // Number of unmatched '('

    int i = 0;
    while (i < s.length()) {
        if (s[i] == '(') {
            open++;
            i++;
        } else {
            // Count how many ')' follow
            if (i + 1 < s.length() && s[i + 1] == ')') {
                // Found a complete '))'
                if (open > 0) open--;
                else ans++; // Need to insert a '('
                i += 2;
            } else {
                // Found a single ')'
                if (open > 0){
                    //()(
                    ans++;
                    open--;
                } 
                else{
                    //)(
                    ans+=2; // Need to insert a '('
                } 
                i++;
            }
        }
    }
    // Each unmatched '(' needs two ')'
    ans += open * 2;
    return ans;
}
```


```cpp
  int minInsertions(string s) {
      stack<char> st;
      int ans=0;
      int n=s.size();
      for(int i=0;i<n;i++){
          char c=s[i];
          if(c=='(') st.push(c);
          else{
              if(!st.empty()){
                  int cnt=1;
                  if(i+1<n and s[i+1]==')') cnt++;
                  if(cnt==1){
                      ans++;
                  }
                  else{
                      i++;
                  }
                  st.pop();
              }
              else{
                  int cnt=1;
                  if(i+1<n and s[i+1]==')') cnt++;
                  if(cnt==1){
                      ans+=2;
                  }
                  else{
                      ans++;
                      i++;
                  }
              }
          }
      }
      return ans+ st.size()*2;
  }
```