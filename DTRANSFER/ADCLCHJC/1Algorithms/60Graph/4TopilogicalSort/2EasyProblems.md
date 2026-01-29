---
title: 2EasyProblems
---

{% raw %}
https://leetcode.com/problems/course-schedule-ii/description/    
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_2EasyProblems__att_0001.png)

```python
class Solution {
public:
    vector<int> topo(vector<int> al[], int n){   
        vector<int> ans;
        //finding the indegegree of all the nodes
        vector<int> ind(n,0);
        for(int i=0;i<n;i++){
            for(int x: al[i]){
                ind[x]++;
            }
        }

        queue<int> q;
        // doing the first insertion in the queue
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.push(i);
        }

        while(q.size()){
            int x=q.front();
            q.pop();
            ans.push_back(x);
            for(int y: al[x]){
                ind[y]--;
                if(ind[y]==0) q.push(y);
            }
        }  
        return ans;
    }

        vector<int> findOrder(int n, vector<vector<int>>& pre) {
            if(n==1) return {0};
            //building the graph on which we will apply topo sort
            vector<int> al[n];
            int e=pre.size();
            for(auto v: pre){
                al[v[1]].push_back(v[0]);
            }
            vector<int> ans=topo(al,n);
            if(ans.size()==n){
                return ans;
            } 
            else{
                return {};
            } 
        }
};
```
{% endraw %}
