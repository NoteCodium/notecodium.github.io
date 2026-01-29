---
title: 3yasheshdoubt
---

{% raw %}
Shortest Subarray with Sum at Least K: When negatives allowed

https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/

https://www.youtube.com/watch?si=T8lpapqDu7VdQg5D&v=Jm-ZTGd6TOQ&feature=youtu.be

https://www.youtube.com/watch?v=Z4tH40wH6JA

```python
a counter example of why it cant be done by the old two pointers approach
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_2MontonicQueue_3yasheshdoubt__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_2MontonicQueue_3yasheshdoubt__att_0002.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_2MontonicQueue_3yasheshdoubt__att_0003.png)

```python
class Solution {
    public:
        int shortestSubarray(vector<int>& v, int k) {
            int result=INT_MAX;
            int n=v.size();
            deque<int> d;
            vector<long> cumSum(n);
            int i=0;
            while(i<n){
                if(i==0){
                    cumSum[0]=v[0];
                }
                else{
                    cumSum[i]=cumSum[i-1]+v[i];
                }
    
                if(cumSum[i]>=k){
                    result=min(result,i+1);
                }
    
                while(d.size() and (cumSum[i]-cumSum[d.front()])>=k){
                    result=min(result,i-d.front());
                    d.pop_front();
                }
    
                while(d.size() and cumSum[d.back()]>=cumSum[i]){
                    d.pop_back();
                }
                d.push_back(i);
                i++;
            }   
            return result == INT_MAX ? -1 : result;
        }
    };
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_2MontonicQueue_3yasheshdoubt__att_0004.png)

explanation of removal    
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_90FixedSlidingWindows_2MontonicQueue_3yasheshdoubt__att_0005.png)
{% endraw %}
