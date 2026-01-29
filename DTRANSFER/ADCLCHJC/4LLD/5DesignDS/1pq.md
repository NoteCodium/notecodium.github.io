---
title: 1pq
---

{% raw %}
Max frequency stack    
https://leetcode.com/problems/maximum-frequency-stack/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_4LLD_5DesignDS_1pq__att_0001.png)

```python
class FreqStack {
    private:
        priority_queue<vector<int>> pq;
        unordered_map<int,int> freq;
        int idx;
        //to implement If there is a tie for the most frequent element,
        // the element closest to the stack's top is removed and returned.
    public:
        FreqStack() {
            idx=-1;
        }
        void push(int val) {
            pq.push({++freq[val],++idx,val});
        }
        
        int pop() {
            auto v=pq.top();
            pq.pop();
            int x=v[2];
            freq[x]--;
            return x;
        }
    };
```
{% endraw %}
