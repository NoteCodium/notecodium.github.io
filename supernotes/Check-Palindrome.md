[Palindrome Number - LeetCode](https://leetcode.com/problems/palindrome-number/)

doubt need better explanation else just an is

```cpp
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + (x % 10);
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;

    }
}
```