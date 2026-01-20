[Clone Graph - LeetCode](https://leetcode.com/problems/clone-graph/description/)

Each node in the graph contains a value (`int`) and a list (`List[Node]`) of its neighbors.

```
class Node {
    public int val;
    public List<Node> neighbors;
}
```

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with `val == 1`, the second node with `val == 2`, and so o

The given node will always be the first node with `val = 1`

1. obiously connected graph
2. undirected

--------------------------------------------------------------------------------------------------------------------


```cpp
Node* cloneGraph(Node* node) {
    if(!node) return nullptr;
    unordered_map<Node*,Node*> m;
    Node* copy=new Node(1,{});
    m[node]=copy;
    queue<Node*> q;
    q.push(node);
    while(!q.empty()){
        Node* n=q.front();q.pop();
        for(auto nei: n->neighbors){
            if(!m.count(nei)){
                m[nei]=new Node(nei->val,{});
                q.push(nei);
            }
            m[n]->neighbors.push_back(m[nei]);
        }
    }
    return copy;    
}
```
