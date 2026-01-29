---
title: 9CFLevel
---

{% raw %}
https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/description/

The queries are independent, so the tree returns to its initial state after each query.

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0002.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0003.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0004.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0005.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0006.png)

```python
class Solution {
public:
    vector<int> levels, height, levelMaxHeight, levelSecondMaxHeight,noOfTimesMaxHeightOccurs; 

    int t(TreeNode* node, int l){
        if(!node) return 0;
        levels[node->val]=l;
        height[node->val]=1+max(t(node->left,l+1),t(node->right,l+1));
        if(levelMaxHeight[l]==height[node->val]){
            noOfTimesMaxHeightOccurs[l]++;
        }
        else if(levelMaxHeight[l]<height[node->val]){
            noOfTimesMaxHeightOccurs[l]=1;
            levelSecondMaxHeight[l]=levelMaxHeight[l];
            levelMaxHeight[l]=height[node->val];
        }
        else if(levelSecondMaxHeight[l]<height[node->val]){
            levelSecondMaxHeight[l]=height[node->val];
        }

        return height[node->val];
    }


    vector<int> treeQueries(TreeNode* root, vector<int>& queries) {
        const int NO_OF_NODES=100000;
        levels.resize(NO_OF_NODES+1);
        height.resize(NO_OF_NODES+1);
        levelMaxHeight.resize(NO_OF_NODES+1);
        levelSecondMaxHeight.resize(NO_OF_NODES+1);
        noOfTimesMaxHeightOccurs.resize(NO_OF_NODES+1,0);

        t(root, 0);
        vector<int> ans;
        for(int q: queries){
            int l=levels[q];
            int result=l;
            if(levelMaxHeight[l]==height[q] and noOfTimesMaxHeightOccurs[l]<=1){
            // if(levelMaxHeight[l]==height[q]){ THIS IS WRONG
                result+=levelSecondMaxHeight[l];
            }
            else{
                result+=levelMaxHeight[l];
            }
            ans.push_back(result-1);
        }
;
        return ans;
    }
};
```

https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_9CFLevel__att_0007.png)
{% endraw %}
