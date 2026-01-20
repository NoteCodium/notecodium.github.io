[leetcode.com](https://leetcode.com/problems/minimum-interval-to-include-each-query/description/)


[Leetcode Contest 239: Minimum Interval to Include Each Query - YouTube](https://youtu.be/ZivzDvve6l0?si=7jZ9Jajod9pOL09Y)

```cpp
int f(int x, vector<vector<int>>& ma, priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> &pq, int &idx){
    int n=ma.size();
    for(;idx<n;idx++){
        if(ma[idx][0]>x) break;
        pq.push({ma[idx][1]-ma[idx][0]+1,ma[idx][1]});
    }

    while(!pq.empty()){
        auto top=pq.top();
        if(top[1]<x){
            pq.pop();
            continue;
        } 
        return top[0];
    }
    return -1;
}

vector<int> minInterval(vector<vector<int>>& ma, vector<int>& qq) {
    int nq=qq.size();
    vector<int> ans(nq);
    vector<vector<int>> q;
    for(int i=0;i<nq;i++){
        q.push_back({qq[i],i});
    }
    sort(q.begin(),q.end());
    sort(ma.begin(),ma.end());
    priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> pq;
    int idx=0;
    for(auto qv:q){
        ans[qv[1]]=f(qv[0],ma,pq,idx);
    }
    return ans;
}
```