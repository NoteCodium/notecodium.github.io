[Problem 4: Longest Palindrome(easy)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/64fd83859592e24ab8b03ab7)

```cpp
int longestPalindrome(string s) {        
    int ans = 0;
    unordered_map<char,int> m;
    bool flag=0;
    for(char c: s) m[c]++;
    for(auto p: m){
        if(p.second%2==0) ans+=p.second;
        else{
            if(!flag){
                ans+=p.second;
                flag=1;
            } 
            else ans+=p.second-1;
        }
    }

    return ans;
}
```