```python
struct Node{
    int val;
    struct Node* left;
    struct Node* right;

    Node(int x){
        val = x;
        left = right = nullptr;
    }
};
```

```python
class TreeNode{
    public:
        int val;
        TreeNode *left; 
        TreeNode *right;
        
        TreeNode(int v){
            val=v;
            left=right=nullptr;
        }    
};
```

```python
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    //notice the constructors in the structure
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
```

: val(0), left(nullptr), right(nullptr)


this is the new stuff

