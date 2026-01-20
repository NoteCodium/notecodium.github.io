[Just a moment...](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/)

```cpp
int minAddToMakeValid(string s) {
    int ans = 0, bal = 0;
    for(char c: s) {
        bal += c == '(' ? 1 : -1;
        if (bal == -1) {
            ans++;
            bal=0;
        }
    }

    return ans + bal;
}
```