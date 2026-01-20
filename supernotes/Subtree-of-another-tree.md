[Subtree of Another Tree - LeetCode](https://leetcode.com/problems/subtree-of-another-tree/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7e5809c7-7911-4496-bc3e-13ca66aeb9d9--image.png)

1. serialise the subtee
2. DO like the previous question

# Brute force
1. Checking for equal trees at each node O(n^2


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5abf6678-1214-4053-8c52-e79705091bf5--image.png)

# Another serialzation
```cpp
void us(TreeNode* node, string &res){
    if(!node){
        res+="#,";
        return;
    }
    res+=("^"+to_string(node->val)+",");
    us(node->left,res);
    us(node->right,res);
}
```
```cpp
void us(TreeNode* node, string &res){
if(!node){
    res+="#,";
    return;
}
res+=("^"+to_string(node->val)+",");
us(node->left,res);
us(node->right,res);
}

bool isSubtree(TreeNode* root, TreeNode* subRoot) {
    string subS,s;
    us(subRoot, subS);
    us(root,s);
    int found= s.find(subS);
    if(found==string::npos) return 0;
    return 1;
}
```