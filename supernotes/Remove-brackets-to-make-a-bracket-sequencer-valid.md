[Just a moment...](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/)

[Minimum Remove to Make Valid Parentheses | 3 Detailed Approaches | Leetcode 1249 | codestorywithMIK - YouTube](https://youtu.be/NNxaYz0nrk0?si=u-Yo2o9c66Y8cOeQ)


# A1
```cpp
string minRemoveToMakeValid(string s) {
    stack<int> st;
    unordered_set<int> se;
    int n=s.size();
    for(int i=0;i<n;i++){
        char c=s[i];
        if(c=='(') st.push(i);
        else if(c==')'){
            if(st.empty()) se.insert(i);
            else st.pop();
        }
    }
    while(!st.empty()){
        se.insert(st.top());
        st.pop();
    }

    string ans;
    for(int i=0;i<n;i++){
        if(se.count(i)) continue;
        ans.push_back(s[i]);
    }

    return ans;

}
```

# a2
```cpp
string minRemoveToMakeValid(string s) {
    //eliminate extra )
    int n=s.size();
    string ans1;
    int op=0;
    for(char c: s){
        if(c=='('){
            op++;
            ans1.push_back(c);
        }
        else if(c==')'){
            if(op>0){
                op--;
                ans1.push_back(c);
            }
        }
        else ans1.push_back(c);
    }

    string ans2;
    // eliminate extra (
    int cl=0;
    n=ans1.size();
    for(int i=n-1;i>=0;i--){
        char c=ans1[i];
        if(c==')'){
            cl++;
            ans2.push_back(c);
        }
        else if(c=='('){
            if(cl>0){
                cl--;
                ans2.push_back(c);
            }
        }
        else ans2.push_back(c);
    }

    reverse(ans2.begin(),ans2.end());
    return ans2;
}
```

# A3


 ## Better clean
 ![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b005abbe-4645-4b12-a452-c777e4d3b039--image.png)
 
