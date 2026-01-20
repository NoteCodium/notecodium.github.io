[SPOJ.com - Problem STPAR](https://www.spoj.com/problems/STPAR/)
[Problem - C - Codeforces](https://codeforces.com/contest/797/problem/C)
[Problem - D - Codeforces](https://codeforces.com/contest/548/problem/D)



For every element, we get an element idx to the right which is greater then it

2. The stack will be decreasing from top to bottm, because an time an element which came is greater them the elements in the stack, it is their nge

3. NGE right ke lie n

```cpp
stack<int> st;
st.push(0);
vector<int> nge(n,n);
for(int i=1;i<n;i++){
  while(!st.empty() and v[i]>v[st.top()]){
//the current element which came is greater then the top element, as long as it is greater then the top element of stack, it will be nge of that element
    nge[st.top()]=i;
    st.pop();
  }
  st.push(i);
}
```
4. NGE left ke lie n
-1 se intialize
```cpp
st.push(n-1);
for(int i=n-2;i>=0;i--)
```
?
Why it is working?
[Next Greater Element II - LeetCode](https://leetcode.com/problems/next-greater-element-ii/)
5. Circular
```cpp
for(int i=1;i<2*n;i++)
//use i%n everywhere
```

