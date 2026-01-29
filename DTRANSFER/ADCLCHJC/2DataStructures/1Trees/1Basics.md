---
title: 1Basics
---

{% raw %}
height of tree

```python
int maxDepth(TreeNode* node) {
    if(!node) return 0;
    return 1+ max(maxDepth(root->left), maxDepth(root->right));
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0001.png)

https://www.geeksforgeeks.org/problems/height-of-spiral-tree/1

```python
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0002.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0003.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0004.png)

min. height of a tree

```python
//original function with a base condition

int minDepth(TreeNode* root) {
    if(!root) return INT_MAX;
    if(!root->left and !root->right) return 1;
    return 1+min(minDepth(root->left),minDepth(root->right));
}
```

isBalanced

```python
int f(TreeNode* root, bool &ans){
    if(!root or !ans) return 0;
    int hl=f(root->left,ans),hr=f(root->right,ans);
    if(abs(hl-hr)>1) ans=0; 
    return 1+ max(hl,hr);
}

bool isBalanced(TreeNode* root) {
    bool ans=1;
    f(root,ans);
    return ans;
}
```

No. of nodes in a tree/ Size of a tree  
https://www.geeksforgeeks.org/problems/size-of-binary-tree/1

```python
//approach 1
int getSize(Node* node){
    if(!node) return 0;
    return 1+getSize(node->left)+getSize(node->right);
 }
```

```python
void f(Node* root, int &cnt){
    if(root==nullptr) return;
    cnt++;
    f(root->left,cnt);
    f(root->right,cnt);
}


int getSize(Node* node){
    int cnt=0; 
    f(node,cnt);
    return cnt;
}
```

No. of leaves of a tree  
https://www.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1

```python
int countLeaves(Node* root){
    if(!root) return 0;
    if(!root->left and !root->right) return 1;
    return countLeaves(root->left)+countLeaves(root->right);
}
```

 508. Most Frequent Subtree Sum    
 https://leetcode.com/problems/most-frequent-subtree-sum/description/

```python
class Solution {
    public:
        int findSum(TreeNode* node,unordered_map<int, int> &m,int &maxx){
            if(!node){
                return 0;
            }
            int lstSum=0, rstSum=0;
            if(node->left){
                lstSum= findSum(node->left,m,maxx);
                m[lstSum]++;
                maxx=max(maxx,m[lstSum]);
            }
            if(node->right){
                rstSum= findSum(node->right,m,maxx);
                m[rstSum]++;
                maxx=max(maxx,m[rstSum]);
            }        
            return node->val+lstSum+rstSum;
        }
    
        void populateAns(unordered_map<int, int> &m, vector<int> &ans, int maxx){
            for(auto p: m){
                if(p.second==maxx){
                    ans.push_back(p.first);
                }
            }
        }
    
        vector<int> findFrequentTreeSum(TreeNode* root) {
            unordered_map<int, int> m;
            int maxx=0;
            int totalSum=findSum(root,m,maxx);

            m[totalSum]++;

            maxx=max(maxx,m[totalSum]);
            
            vector<int> ans;
            populateAns(m,ans,maxx);
            return ans;
        }
    };
```

isSame         
https://leetcode.com/problems/same-tree/

```python
class Solution {
    public:
        bool isSameTree(TreeNode* p, TreeNode* q) {
            if(!p and !q) return 1;
            if(!p or !q) return 0;
            return p->val==q->val and isSameTree(p->left,q->left) and isSameTree(p->right,q->right);   
        }
    };
```

# isMirrorImage
https://leetcode.com/problems/symmetric-tree/description/   
![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0005.png)

```python
class Solution {
    public:
        bool areSymmetric(TreeNode* leftNode, TreeNode* rightNode){
            if(!leftNode and !rightNode) return 1;
            if(!leftNode or !rightNode) return 0; 
            return leftNode->val==rightNode->val and 
            areSymmetric(leftNode->left,rightNode->right) and 
            areSymmetric(leftNode->right,rightNode->left);       
        }
    
        bool isSymmetric(TreeNode* root) {
            if(!root) return 0;
            return areSymmetric(root->left,root->right);
        }
    };
```

https://www.geeksforgeeks.org/problems/mirror-tree/1  
construct mirror image

```python
void mirror(Node* node) {
    if(!node) return;
    swap(node->left,node->right);
    mirror(node->left);
    mirror(node->right);
}
```

https://leetcode.com/problems/flip-equivalent-binary-trees/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_1Basics__att_0006.png)

```python
class Solution {
    public:
        bool flipEquiv(TreeNode* r1, TreeNode* r2) {
            if(!r1 and !r2) return 1;
            if((r1 and !r2) or (!r1 and r2)) return 0;
            return r1->val==r2->val and 
            (
              (flipEquiv(r1->left,r2->left) and flipEquiv(r1->right,r2->right))
                or
              (flipEquiv(r1->left,r2->right) and flipEquiv(r1->right,r2->left))  
            );
        }
    };
```
{% endraw %}
