


[Page Not Found - LeetCode](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

**`std::string::find`** (Substring Search): You can use the `find` member function of the `std::string` class to search for a substring within a string. It returns the position of the first occurrence of the substring or `std::string::npos` if the substring is not found


```cpp
int found= s1.find(s2);
if(found==string::npos)
```



```cpp
int strStr(string s1, string s2) {
    int found= s1.find(s2);
    if(found==string::npos) return -1;
    return found;
}
```