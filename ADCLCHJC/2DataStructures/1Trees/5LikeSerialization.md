# Serialization
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/  


```python
void utilitySerialize(TreeNode* node, string &res){
    if(!node){
        //to distinguish null from others
        res+="#,";
        return;
    }
    res+=(to_string(node->val)+",");
    utilitySerialize(node->left,res);
    utilitySerialize(node->right,res);
}

string serialize(TreeNode*  root) {
    string res;
    utilitySerialize(root, res);
    return res;
}
```

creating a vector instead


```python
void f(Node* node){
    if(!node){
      v.pb(-1);
      return;
    } 
    v.pb(node->val);
    f(node->left);
    f(node->right);
  }
```

# Deserialization  



## Proper


```python
// Decodes your encoded data to tree.
TreeNode* deserializeUtility(int &idx, vector<string> &vos){
    if(idx>=vos.size()) return nullptr;

    if(vos[idx]=="#"){
        idx++;
        return nullptr;
    }

    TreeNode* node= new TreeNode(stoi(vos[idx]));

    idx++;

    node->left=deserializeUtility(idx,vos);
    node->right=deserializeUtility(idx,vos);
    
    return node;
}



TreeNode* deserialize(string serializedString) {
    vector<string> vos;
    stringstream ss(serializedString);
    string tok;
    while(getline(ss,tok,',')){
            vos.push_back(tok);
        } 
    int idx=0;
    return deserializeUtility(idx,vos);
}
```

preorder traversal + isLeaf array  
https://www.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1


```python
struct Node *helper(int n, int pre[], char LN[], int &idx){
    if(idx>=n) return nullptr;
    if(LN[idx]=='L'){
        //this is the terminating case when the node is leaf
        Node* leaf=new Node(pre[idx]);
        idx++;
        return leaf;
    }
    Node* node= new Node(pre[idx]);
    idx++;
    node->left=helper(n,pre,LN,idx);
    node->right=helper(n,pre,LN,idx);
    
    return node;
}

struct Node *constructTree(int n, int pre[], char LN[]){
    int idx=0;
    return helper(n,pre,LN,idx);
}
```

preorder traversal + null nodes where null nodes are represented as -1   
 Find OA link  
 verify   
 


```python
Node* f(int idx){
    if(idx>=n) return nullptr;
    if(pre[idx]==-1){
      idx++;
      return nullptr;
    }
    Node* node= new Node(pre[idx]);
    idx++;
    node->left=f(idx);
    node->right=f(idx);
    return node;
}
```

# Hawa heen na lage





![image.png](5LikeSerialization_images/image.png)


we can write level order traversal but how?

