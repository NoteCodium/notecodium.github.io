[Counting Bits - LeetCode](https://leetcode.com/problems/counting-bits/description/)

# Brute force n* logn
better then it

[Counting Bits - Dynamic Programming - Leetcode 338 - Python - YouTube](https://youtu.be/RyBM56RIWrM?si=y8EoXS4SOMyLoIz8)
![image.png](../images/176be227-cc0b-4c2b-a59e-9de1cfd75653--image.png)
![image.png](../images/c2fadd91-bf09-44a9-beff-be236914a90e--image.png)
![image.png](../images/f31d4ebd-d8b4-4516-ba5a-3e854b52211e--image.png)


```cpp
  vector<int> countBits(int n) {
      vector<int> ans(n+1);
      ans[0]=0;
      int offset=1;
      for(int i=1;i<=n;i++){
          if(offset*2==i) offset=i;
          ans[i]=1+ans[i-offset];
      }

      return ans;
  }
```


