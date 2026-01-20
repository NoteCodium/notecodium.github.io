[Serialize and Deserialize Binary Tree - LeetCode](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/)

1. serialize
```cpp
void us(TreeNode* node, string &res){
    if(!node){
        res+="#,";
        return;
    }
    res+=(to_string(node->val)+",");
    us(node->left,res);
    us(node->right,res);
}

string serialize(TreeNode* root) {
    string res;
    us(root, res);
    return res;
}
```
2. deserialize
```cpp
// Decodes your encoded data to tree.
TreeNode* du(int &idx, vector<string> &vos){
    if(idx>=vos.size()) return nullptr;
    if(vos[idx]=="#"){
        idx++;
        return nullptr;
    }
    TreeNode* n= new TreeNode(stoi(vos[idx]));
    idx++;
    n->left=du(idx,vos);
    n->right=du(idx,vos);
    return n;
}



TreeNode* deserialize(string s) {
    vector<string> vos;
    stringstream ss(s);
    string tok;
    while(getline(ss,tok,',')){
            vos.push_back(tok);
        } 
    int idx=0;
    return du(idx,vos);
}
```
