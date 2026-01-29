---
title: 22FirstProblem
---

{% raw %}
https://leetcode.com/problems/find-the-duplicate-number/description/

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_25Cyclic_22FirstProblem__att_0001.png)

```python
class Solution {
    public:
        int findDuplicate(vector<int>& v) {
            int n=v.size();
            for(int i=0;i<n;i++){
                while(v[i]!=i+1){
                    int idx=v[i]-1;
                    if(v[idx]==v[i]){
                        return v[i];
                    }
                    swap(v[i],v[idx]);
                }
            }
            return -1;
        }
    };
```

```python
//archieved
class Solution {
public:
    void sort(vector<int> &v) {
        int np1=v.size();
        for(int i=0;i<np1;i++){
            while(v[i]!=i+1 and v[v[i]-1]!=v[i] and v[i]!=np1+1){
                int idx=v[i]-1;
                swap(v[i],v[idx]);
            }
        }
    }

    int findDuplicate(vector<int>& v) {
        sort(v);
        int np1=v.size();
        return v[np1-1];
    }
};
```
{% endraw %}
