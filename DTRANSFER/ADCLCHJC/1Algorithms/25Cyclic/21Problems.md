---
title: 21Problems
---

{% raw %}
https://www.geeksforgeeks.org/problems/minimum-swaps/1

distinct elements

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_25Cyclic_21Problems__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_25Cyclic_21Problems__att_0002.png)

no. of swaps is cycle len -1

in each operation we will put one element in its correct position, in the end we will have one element left which will be in its correct position so no swaps required for that

```python
class Solution {
    public:
      // Function to find the minimum number of swaps required to sort the array.
      int minSwaps(vector<int>& v1) {
          int n=v1.size();
          vector<vector<int>> v2(n);
          for(int i=0;i<n;i++){
              v2[i]={v1[i],i};
          }
          sort(v2.begin(),v2.end());
          int ans=0;
          for(int i=0;i<n;i++){
              int cycleLength=1;
              v2[i][0]*=-1;
              while(v2[v2[i][1]][0]>0 and i!=v2[i][1]){
                  v2[v2[i][1]][0]*=-1;
                  swap(v2[i], v2[v2[i][1]]);
                  cycleLength++;
              }
              ans+=cycleLength-1;
          }
          return ans;
      }
  };
```

solved in better SC by mike in bits playlist
{% endraw %}
