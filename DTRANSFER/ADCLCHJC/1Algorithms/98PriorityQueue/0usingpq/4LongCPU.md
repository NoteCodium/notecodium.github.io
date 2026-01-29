---
title: 4LongCPU
---

{% raw %}
1834. Single-Threaded CPU   
https://leetcode.com/problems/single-threaded-cpu/description/   
https://www.youtube.com/watch?v=RR1n-d4oYqE  
https://www.youtube.com/watch?v=9zRXNLbl0FI

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_98PriorityQueue_0usingpq_4LongCPU__att_0001.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_98PriorityQueue_0usingpq_4LongCPU__att_0002.png)

```python
vector<int> getOrder(vector<vector<int>>& origMat) {
    int n=origMat.size();
    vector<vector<int>> ma;
    for(int i=0;i<n;i++){
        ma.push_back({origMat[i][0],origMat[i][1],i});
    }
    sort(ma.begin(),ma.end());
    //{enqueue_time,processing_time,index}
    vector<int> ans;
    priority_queue< vector<int>, vector<vector<int>>,greater<vector<int>> > pq;
    //processing_time,index}
    int idx=0;
    long long curr_time=1;
    int no=n;
    while(no--){
        while(idx<n and ma[idx][0]<=curr_time){
            pq.push({ma[idx][1],ma[idx][2]});
            idx++;
        }
        if(pq.empty() and ma[idx][0]>curr_time and idx<n){
            curr_time=ma[idx][0];
            pq.push({ma[idx][1],ma[idx][2]});
            idx++;
        } 
        //If none of the task is available at the current time, 
        //we need to increment the current time until a task is available.

        auto vv=pq.top();
        pq.pop();
        curr_time+=vv[0];
        ans.push_back(vv[1]);
    }

    return ans;
}
```
{% endraw %}
