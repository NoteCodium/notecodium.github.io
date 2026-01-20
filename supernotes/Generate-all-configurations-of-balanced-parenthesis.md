[Generate Parentheses - LeetCode](https://leetcode.com/problems/generate-parentheses/description/)


# Brute force
1. Generate all possibilities 
2. run valid parenthesis test on all

1. N pairs of valid brackets

```cpp
void f(int i,int l,int r, int n, string &tmp, vector<string> &ans){
    //understood
    if(i==2*n){
        ans.push_back(tmp);
        return;
    }
    //at any time l>=r 
    if(l==r){
    //if(l==n) wwould mean l==r so i==2*n would have terminated it
        tmp.push_back('(');
        f(i+1,l+1,r,n,tmp,ans);
        tmp.pop_back();
    }
    //l<r is not possible
    //so this else means l>r
    else{
        if(l==n){
            tmp.push_back(')');
            f(i+1,l,r+1,n,tmp,ans);
            tmp.pop_back();
        }
        else{
            tmp.push_back('(');
            f(i+1,l+1,r,n,tmp,ans);
            tmp.pop_back();
        
            tmp.push_back(')');
            f(i+1,l,r+1,n,tmp,ans);
            tmp.pop_back();
        
        }
    }
}
```