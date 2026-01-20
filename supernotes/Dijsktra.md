1. dont work with negative edges

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/723214f6-9517-4a68-8d63-f7d6ad766d15--image.png)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c4a2da36-32ff-4533-868a-91f5ffe69b9b--image.png)

# Dijkstra No Negative cycles
Shortest path from src to all the nodes
# Priority Queue
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/1de1730c-9b4f-4d23-b51a-b861253196a5--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/92310f98-7b57-4d4d-952c-abfd02f7e95d--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5756f3b6-d8c3-4bb8-8ae9-86ef0e17cc2b--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/fb5d92e8-c3b5-49ab-9e69-336baf5ef1e7--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b4c7c173-06b5-4a1b-90b8-e66fbead0ba7--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8cc9648e-f82d-4e8f-8f55-ba7a09066ecc--image.png)
## Initialy all were infinite
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/cede8282-9e89-4924-ac27-81399bf1973d--image.png)


[Implementing Dijkstra Algorithm | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/0)

distance, node


```cpp
vector <int> dijkstra(int n, vector<vector<int>> al[], int src){
    vector<int> dis(n,INT_MAX);
    priority_queue<vector<int>,vector<vector<int>>, greater<vector<int>>> pq;
    dis[src]=0;
    pq.push({0,src});
    while(!pq.empty()){
        int d=pq.top()[0];
        int node=pq.top()[1];
        pq.pop();
        for(auto v: al[node]){
            int ewei=v[1];
            int adjNode=v[0];
            if(d+ewei<dis[adjNode]){
                dis[adjNode]=d+ewei;
                pq.push({dis[adjNode],adjNode});
            }
        }
        
    }
    
    return dis;
}
```

# NEAT trick

```cpp
vector <int> dijkstra(int n, vector<vector<int>> al[], int src){
    vector<int> dis(n,INT_MAX);
    priority_queue<vector<int>> pq;
    dis[src]=0;
    pq.push({0,src});
    while(!pq.empty()){
        int d=-pq.top()[0];
        int node=pq.top()[1];
        pq.pop();
        for(auto v: al[node]){
            int ewei=v[1];
            int adjNode=v[0];
            if(d+ewei<dis[adjNode]){
                dis[adjNode]=d+ewei;
                pq.push({-dis[adjNode],adjNode});
            }
        }
        
    }
    
    return dis;
}
```
