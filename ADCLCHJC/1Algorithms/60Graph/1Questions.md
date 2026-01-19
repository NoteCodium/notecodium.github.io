# Clone graph


Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.


```python
class Node {
    public int val;
    public List<Node> neighbors;
}
```

```python
class Node {
    public:
        int val;
        vector<Node*> neighbors;
        Node() {
            val = 0;
            neighbors = vector<Node*>();
        }
        Node(int _val) {
            val = _val;
            neighbors = vector<Node*>();
        }
        Node(int _val, vector<Node*> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };
```

For simplicity, each node’s value is the same as the node’s index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so o

The given node will always be the first node with val = 1


![image.png](1Questions_images/image.png)


```python
class Solution {
    public:
        Node* cloneGraph(Node* node) {
            
        }
    };
```

```python
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
    public:
        Node* cloneGraph(Node* node) {
            if(!node){
                return nullptr;
            } 
            unordered_map<Node*,Node*> m;
            Node* copy=new Node(1,{});
            m[node]=copy;
            queue<Node*> q;
            q.push(node);
            while(!q.empty()){
                Node* n=q.front();
                q.pop();
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
    };
    
```
