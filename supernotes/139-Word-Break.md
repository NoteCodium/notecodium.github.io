[Just a moment...](https://leetcode.com/problems/word-break/description/)

![image.png]()

dp array tell us weather the word is breakable at that index or not

[Word Break (LeetCode 139) | Full Solution using memoization and dynamic programming - YouTube](https://www.youtube.com/watch?v=hK6Git1o42c)



```cpp
bool wordBreak(string s, vector<string>& v){
    int n=s.size();
    unordered_set<string> se(v.begin(),v.end());
    se.insert("");
    vector<int> dp(n+1,0);
    dp[0]=1;


    for(int i=1;i<=n;i++){
        for(int j=0;j<=i;j++){
            if(dp[j] and se.count(s.substr(j+1-1,(i-1)-(j+1-1)+1))){
                dp[i]=1;
                break;
            }
        }
    } 

    return dp[n];
}
```

![image.png]()