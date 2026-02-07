[leetcode.com](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/)

![image.png](../images/0296671c-b185-4451-bbe8-999617a7460d--image.png)

[youtu.be](https://youtu.be/OwMNX8SPavM)


![image.png](../images/a39359e4-5e10-4b3f-94b4-437a91b3e8d2--image.png)

n- no of components

```cpp
class Solution {
public:

    int removeStones(vector<vector<int>>& stones) {
        return stones.size()-f(stones);
    }
};
```