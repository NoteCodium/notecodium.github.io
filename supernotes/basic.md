[Unique Paths - LeetCode](https://leetcode.com/problems/unique-paths/)


```cpp
int countPaths(int i, int j){
    if(i<0 or j<0) return 0;
    if(i==0 or j==0) return 1;
    return countPaths(i-1,j)+countPaths(i,j-1);
}

int uniquePaths(int m, int n) {
   return countPaths(m-1,n-1); 
}
```
it will never get negetave

```cpp
int countPaths(int i, int j){ 
    if(i==0 or j==0) return 1; 
    return countPaths(i-1,j)+countPaths(i,j-1); 
} 
int uniquePaths(int m, int n) { 
    return countPaths(m-1,n-1); 
} 
```

