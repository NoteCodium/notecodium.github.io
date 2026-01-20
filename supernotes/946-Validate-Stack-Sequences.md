[Just a moment...](https://leetcode.com/problems/validate-stack-sequences/description/)

[youtu.be](https://youtu.be/HEh7EtNSXtg?si=OlHh8ZcHxWuumzgR)
```cpp
bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
    int n=pushed.size();
    int i=0,j=0;
    stack<int> st;
    while(i<n and j<n){
        st.push(pushed[i]);
        while(!st.empty() and j<n and st.top()==popped[j]){
            st.pop();
            j++;
        }
        i++;
    }
    return st.empty();
}
```
