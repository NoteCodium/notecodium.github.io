---
title: 3Matrix
---

{% raw %}
Matrix is row wise and column wise sorted   
FInd an element    
not the right question but atleast the matrix is row wise and column wise sorted

kind of bs skeleton is used

we start with this coordinate

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_60BinarySearch_3Matrix__att_0001.png)

```python
int i=0,j=n-1;
while(i<rr and j>=0){
  if(ma[i][j]==k) return 1;
  else if(ma[i][j]>k) j--;
  else i++;
}
return 0;
```

https://leetcode.com/problems/search-a-2d-matrix/description/   
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.

```python
class Solution {
    public:
        bool searchMatrix(vector<vector<int>>& ma, int k) {
            int rr=ma.size(),cc=ma[0].size();
            int l=0,h=rr*cc-1;
            while(l<=h){
                int m=(l+h)/2;
                int curr=ma[m/cc][m%cc];
                if(curr==k) return 1;
                else if (curr<k) l=m+1;
                else h=m-1;
            }
            return 0;
        }
    };
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_60BinarySearch_3Matrix__att_0002.png)
{% endraw %}
