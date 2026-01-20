[Course Schedule II - LeetCode](https://leetcode.com/problems/course-schedule-ii/description/)

```cpp
vector<int> topo(vector<int> al[], int n){   
    vector<int> ans;
    //finding the indegegree of all the nodes
    vector<int> ind(n,0);
    for(int i=0;i<n;i++){
        for(int j=0;j<al[i].size();j++){
            ind[al[i][j]]++;
        }
    }

    queue<int> q;
    // doing the first insertion in the queue
    for(int i=0;i<n;i++){
        if(ind[i]==0) q.push(i);
    }

    while(!q.empty()){
        int x=q.front();
        q.pop();
        ans.push_back(x);
        for(int i=0;i<al[x].size();i++){
            ind[al[x][i]]--;
            if(ind[al[x][i]]==0) q.push(al[x][i]);
        }
    }  
    return ans;
}

vector<int> findOrder(int n, vector<vector<int>>& pre) {
    if(n==1) return {0};
    //building the graph on which we will apply topo sort
    vector<int> al[n];
    int e=pre.size();
    for(int i=0;i<e;i++){
        al[pre[i][1]].push_back(pre[i][0]);
    }
    vector<int> ans=topo(al,n);
    if(ans.size()==n) return ans;
    else return {};
}
```
