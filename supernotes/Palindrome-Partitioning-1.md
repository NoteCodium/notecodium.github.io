[Palindrome Partitioning - LeetCode](https://leetcode.com/problems/palindrome-partitioning/description/)


1.Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.



```
bool isPal(string &s, int i, int j){
    while(i<j){
      if(s[i++]!=s[j--]) return 0;             
    }
    return 1;
}

void f(int idx, vector<vector<string>> &ans, vector<string> &tmp, string &s){
    if(idx==s.size()){
        ans.push_back(tmp);
        return ;    
    }
    for(int i=idx;i<s.size();i++){
        if(!isPal(s,idx,i)) continue;
        tmp.push_back(s.substr(idx,i-idx+1));
        f(i+1,ans,tmp,s);
        tmp.pop_back();
    }
}

vector<vector<string>> partition(string s) {
    vector<vector<string>> ans;
    vector<string> tmp;
    f(0,ans,tmp,s);
    return ans;
}
```
