
[ - YouTube](https://www.youtube.com/watch?v=ZOoobzPotwI)

[leetcode.com](https://leetcode.com/problems/remove-duplicate-letters/description/)

![image.png](../images/b99e721c-90a0-4a8d-9035-fe9c1160d877--image.png)





![image.png](../images/bbd874f6-2bbe-4463-afa8-0faa24685fc4--image.png)

imp edge case
![image.png](../images/09763ab1-cdc3-4a38-9933-7887baced6ae--image.png)


![image.png](../images/69ae571c-7c45-4cdc-8469-3f0eec53c59a--image.png)

watch video

```cpp
string removeDuplicateLetters(string s) {
    unordered_map<char,int> freq;
    stack<char> st;
    for(char c: s) freq[c]++;
    unordered_map<char,bool> present;
    st.push(s[0]);
    freq[s[0]]--;
    present[s[0]]=1;
    int n=s.size();
    for(int i=1;i<n;i++){
        freq[s[i]]--;
        if(present[s[i]]) continue;
        while(!st.empty() and s[i]<st.top() and freq[st.top()]){
            present[st.top()]=0;
            st.pop();
        }
        st.push(s[i]);
        present[s[i]]=1;
    }
    string res;
    while(!st.empty()){
        res.push_back(st.top());
        st.pop();
    }
    reverse(res.begin(),res.end());
    return res;
}
```


