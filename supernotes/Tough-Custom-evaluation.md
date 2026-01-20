[Just a moment...](https://leetcode.com/problems/score-of-parentheses/description/)

[Leetcode 856. Score of Parentheses - YouTube](https://youtu.be/2ww4nIvw2no?si=4Yycwy6HUV_TIayl)


```cpp 
    int f(int s, int e, vector<int> &pair){
        if(s+1==e){
            return 1;
        }
        int ans=0;
        for(int i=s+1;i<e;){
            ans+=f(i,pair[i],pair);
            i=pair[i]+1;
        }
        return ans*2;
    }

    int scoreOfParentheses(string s) {
        s="("+s+")";
        int n=s.size();
        vector<int> v, pair(n);
        for(int i=0;i<n;i++){
            if(s[i]=='('){
                v.push_back(i);
            }
            else{
                pair[i]=v.back();
                pair[v.back()]=i;
                v.pop_back();
            }
        }
        return f(0,n-1,pair)/2;   
    }
```






```cpp
int scoreOfParentheses(string s) {
    stack<int> st;
    for(char c: s){
        if(c=='(') st.push(-1);
        else{
            if(st.top()==-1){
                st.pop();
                st.push(1);
            }
            else{
                int val=0;
                while(st.top()!=-1){
                    val+=st.top();st.pop();
                }
                st.pop();
                st.push(2*val); 
            }
        }
    }

    int ans=0;
    while(!st.empty()){
        ans+=st.top();st.pop();
    }

    return ans;


}
```
