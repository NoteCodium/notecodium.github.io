A generic tree is a binary tree iff   
1 root node   
every child have one parent   
every parent have two child   


# Graph theory


https://leetcode.com/problems/validate-binary-tree-nodes/


1. every child have one parent        
    1. Each node has at most one parent → indegree[i] <= 1
2. Only one root → one node with indegree == 0
3. No cycles → if visited[node] is true, cycle exists
4. All nodes are reachable from the root → visited.size() == n 
  (there are no disconnected components)


![image.png](995Transition2Graph_images/image.png)


![image.png](995Transition2Graph_images/image.png)


![image.png](995Transition2Graph_images/image.png)


![image.png](995Transition2Graph_images/image.png)


![image.png](995Transition2Graph_images/image.png)


![image.png](995Transition2Graph_images/image.png)


when we know the root, we can do bfs or dfs to check if all nodes are reachable



```python
class Solution {
    public:
    
        bool validateBinaryTreeNodes(int n, vector<int>& l, vector<int>& r) {
            unordered_map<int,vector<int>> parent2ChildAl;
            //kind of parent_to_child
            unordered_map<int,int> child2Parent;
    
            for(int i=0;i<n;i++){
                int lC=l[i],rC=r[i];
                if(lC!=-1){
                    parent2ChildAl[i].push_back(lC);
                    if(child2Parent.count(lC)){
                        return 0;
                    }
                    child2Parent[lC]=i;
                }
    
                if(rC!=-1){
                    parent2ChildAl[i].push_back(rC);
                    if(child2Parent.count(rC)){
                        return 0;
                    }
                    child2Parent[rC]=i;
                }            
            }
    
            int root=-1;
            for(int i=0;i<n;i++){
                if(!child2Parent.count(i)){
                    if(root!=-1){
                        return 0;
                    }
                    root=i;
                }
            }
    
            if(root==-1){
                return 0;
            }
    
            //dfs or bfs to make sure that there is only one componenet
            //and there is no cycle?
            int cnt=0;
            queue<int> q;
            vector<int> visited(n,0);
            q.push(root);
            cnt=1;
            visited[root]=1;
            while(q.size()){
                int node=q.front();
                q.pop();
                for(int x: parent2ChildAl[node]){
                    if(visited[x]){
                        return 0;
                    }
                    visited[x]=1;
                    cnt++;
                    q.push(x);
                }
            }
            return cnt==n;
        }
    };
```

# Can be solved with union find


https://leetcode.com/problems/create-binary-tree-from-descriptions/description/


![image.png](995Transition2Graph_images/image.png)


after graph


https://youtu.be/Rt2prDOV2hU?si=IZxyuxXz45BJobX3


https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/description/


![image.png](995Transition2Graph_images/image.png)


https://www.youtube.com/watch?v=vrbJ7aDuK-A&list=PLpIkg8OmuX-K23LhcamOcDlTBisiNJy5E&index=48

