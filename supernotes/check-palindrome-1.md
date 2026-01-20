[Palindrome Number - LeetCode](https://leetcode.com/problems/palindrome-number/description/?source=submission-ac)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/917f2af4-5890-4b1f-ad25-9ecb5bed21a4--image.png)

not very elegant

```cpp
bool isPalindrome(int x) {
    if(x<0 or (x%10==0 and x!=0)) return 0;
    int rev=0;
    while(x>rev){
        rev=rev*10+ x%10;
        x/=10;
    }
    return x==rev or x==rev/10;
}
```

