---
title: 5StronglyConnectedComponents
---

{% raw %}
https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?track=placement


![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_5StronglyConnectedComponents__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_5StronglyConnectedComponents__att_0002.png)    
when you reverse it

we have to somehow do dfs from side of s1

for directed graphs only
subgraph in which there is a directed path from every vertex to every other vertex.

In simpler terms, a strongly connected component is a set of vertices within a directed graph where there is a directed path from any vertex in the set to any other vertex in the set

sol.

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_5StronglyConnectedComponents__att_0003.png)

finishing time    
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_5StronglyConnectedComponents__att_0004.png)

```python
void dfs(int node, vector<int> &vis, vector<vector<int>>& al, stack<int> &st){
    vis[node]=1;
    for(int x:al[node]){
        if(!vis[x]){
            dfs(x,vis,al,st);
        }
    }  
    st.push(node);
}

void dfs_(int node, vector<int> &vis, vector<vector<int>>& al){
    vis[node]=1;
    cout<<node<<"<-";
    for(int x:al[node]) if(!vis[x]) dfs_(x,vis,al);
}    

public:
int kosaraju(int n, vector<vector<int>>& al){
    vector<int> vis(n,0);
    stack<int> st;
    for(int i=0;i<n;i++){
        if(!vis[i]){
            dfs(i,vis,al,st);
        } 
    }

    //reversing the graph
    vector<vector<int>> alReverse(n);
    for(int i=0;i<n;i++){
        for(int x: al[i]){
            alReverse[x].push_back(i);
        }
    }
    
    vector<int> vis_(n,0);
    int ans=0;
    while(!st.empty()){
        int node=st.top();
        st.pop();
        if(!vis_[node]){
            ans++;
            dfs_(node,vis_,alReverse);
        }
        cout<<"\n";
    }
    
    return ans;
    
}
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_5StronglyConnectedComponents__att_0005.png)
{% endraw %}
