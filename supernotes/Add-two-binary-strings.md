[Just a moment...](https://leetcode.com/problems/add-binary/description/)
# Java
```
class Solution {
    public String addBinary(String num1, String num2) {
        int carry=0;
        int size1=num1.length(),size2=num2.length();
        int maxLen=Math.max(size1,size2);
        StringBuilder ans=
            new StringBuilder(String.join("",Collections.nCopies(maxLen, "$")));
        for(int i=0;i<maxLen;i++){
            int bitA=i<size1?num1.charAt(size1-1-i)-'0':0;
            int bitB=i<size2?num2.charAt(size2-1-i)-'0':0;
            int total=bitA+bitB+carry;
            char res=(char)('0'+(total%2));
            carry=total/2;
            ans.setCharAt(maxLen-1-i,res);
        }
        if(carry!=0) ans.insert(0,'1');
        return ans.toString();

    }
}
```

```
class Solution {
    public String addBinary(String num1, String num2) {
        int carry=0;
        int size1=num1.length(),size2=num2.length();
        int maxLen=Math.max(size1,size2);
        StringBuilder ans=
            new StringBuilder();
        for(int i=0;i<maxLen;i++){
            int bitA=i<size1?num1.charAt(size1-1-i)-'0':0;
            int bitB=i<size2?num2.charAt(size2-1-i)-'0':0;
            int total=bitA+bitB+carry;
            char res=(char)('0'+(total%2));
            carry=total/2;
            ans.append(res);
        }
        if(carry!=0) ans.append('1');
        return ans.reverse().toString();

    }
}
```






# C++
```cpp
class Solution {
public:
    string addBinary(string num1, string num2) {
        int carry=0;
        int size1=num1.size(),size2=num2.size();
        int maxLen=max(size1,size2);
        string ans(maxLen,'0');
        for(int i=0;i<maxLen;i++){
            int bitA=i<size1?num1[size1-1-i]-'0':0;
            int bitB=i<size2?num2[size2-1-i]-'0':0;
            int total=bitA+bitB+carry;
            char res='0'+(total%2);
            carry=total/2;
            ans[maxLen-1-i]=res;
        }
        if(carry) ans.insert(0,1,'1');
        return ans;
    }
};

```