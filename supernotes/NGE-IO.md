[](https://leetcode.com/problems/next-greater-element-i/description/)

```cpp
class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& q, vector<int>& v) {
        int n=v.size();
        vector<int> nge(n,-1);
        stack<int> st;
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.empty() and v[i]>v[st.top()]){
                nge[st.top()]=i;
                st.pop();
            }
            st.push(i);
        }
        
        unordered_map<int,int> ngeMap;
        for(int i=0;i<n;i++) ngeMap[v[i]]= nge[i]!=-1?v[nge[i]]:-1;
        vector<int> ans;
        for(int &x: q) ans.push_back(ngeMap[x]);
        return ans;
    }
};
```
