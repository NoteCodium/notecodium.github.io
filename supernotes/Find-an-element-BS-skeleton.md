[Search a 2D Matrix - LeetCode](https://leetcode.com/problems/search-a-2d-matrix/description/)

not the right question

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9c5ab46e-792e-420a-8a54-50daf035d6f2--image.png)

```cpp
while(i<rr and j>=0){
  if(ma[i][j]==k) return 1;
  else if(ma[i][j]>k) j--;
  else i++;
}
return 0;
```