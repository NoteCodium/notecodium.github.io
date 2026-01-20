[Mirror Tree | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/mirror-tree/1)

```cpp
    void mirror(Node* node) {
        if(!node) return;
        swap(node->left,node->right);
        mirror(node->left);
        mirror(node->right);
    }
```
