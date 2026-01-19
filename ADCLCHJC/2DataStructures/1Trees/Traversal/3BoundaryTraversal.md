https://leetcode.com/problems/boundary-of-binary-tree/description/    
premium    
tough


https://www.naukri.com/code360/problems/boundary-traversal-of-binary-tree_790725


![image.png](3BoundaryTraversal_images/image.png)


![image.png](3BoundaryTraversal_images/image.png)


left boundary 


```python
class Solution {
    public:
        bool isLeaf(TreeNode* node){
            return (!node->left and !node->right);
        }
    
        void getLeftBoundary(TreeNode* node, vector<int> &ans){
            if(!node or (isLeaf(node))){
                return;
            }
      
            ans.push_back(node->val);
            
            if(node->left){
                getLeftBoundary(node->left,ans);
            }
            else if(node->right){
                getLeftBoundary(node->right,ans);
            }
        }
    
    
        void getLeafView(TreeNode* node, vector<int> &ans, TreeNode* root){
            if(!node){
                return;
            }
            if(isLeaf(node) and node!=root){
                ans.push_back(node->val);
            }
            getLeafView(node->left,ans,root);
            getLeafView(node->right,ans,root);
        }
    
        void rightBoundary(TreeNode* node, vector<int> &tmp){
            if(!node or (isLeaf(node))){
                return;
            }
    
            tmp.push_back(node->val);
            
            if(node->right){
                rightBoundary(node->right,tmp);
            }
            else if(node->left){
                rightBoundary(node->left,tmp);
            }
        }
    
        void getRightBoundary(TreeNode* node, vector<int> &ans){
            vector<int> tmp;
            rightBoundary(node,tmp);
            reverse(tmp.begin(),tmp.end());
            for(int x: tmp){
                ans.push_back(x);
            }
        }
    
        vector<int> boundaryOfBinaryTree(TreeNode* root) {
            vector<int> ans;
            ans.push_back(root->val);
            if(root->left){
                getLeftBoundary(root->left,ans);
            }
            getLeafView(root,ans,root);
            if(root->right){
                getRightBoundary(root->right,ans);
            }
    
            return ans;	
        }
    };
```
