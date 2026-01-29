---
title: -1recursionTree
---

{% raw %}
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_-1recursionTree__att_0001.png)

recursion allows us to move back without actually the back link as happen in graph

NRI: Need Repetitions

https://leetcode.com/problems/distribute-coins-in-binary-tree/description/
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_-1recursionTree__att_0002.png)

https://youtu.be/FmHxY2104hc?si=4x2mQb1IH73fa8KL

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_2DataStructures_1Trees_-1recursionTree__att_0003.png)

```python
class Solution {
public:
    int returnExtraCoins(TreeNode* node, int &moves){
        if(!node){
            return 0;
        }

        int l=returnExtraCoins(node->left,moves);
        int r=returnExtraCoins(node->right,moves);

        moves+=(abs(l)+abs(r));
        return (node->val+l+r-1);
    }

    int distributeCoins(TreeNode* root) {
        int moves=0;
        returnExtraCoins(root, moves);
        return moves;   
    }
};
```
{% endraw %}
