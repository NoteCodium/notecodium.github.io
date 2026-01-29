---
title: 2Hoirzontal
---

{% raw %}
BFS in a tree is Level order traversal

```python
queue<Node*> q;
q.push(root);
while(q.size()){
  Node* n=q.front();
  q.pop();
  if(n->left) q.push(n->left);
  if(n->right) q.push(n->right);
}
```

When you have to store all the levels separately on vvNodes

```python
while(q.size()){
    int sz=q.size();
    while(sz--){
      vector<int> tmp;
      Node* n=q.front();
      q.pop();
      tmp.pb(q->val);
      if(n->left) q.push(n->left);
      if(n->right) q.push(n->right);
    }
    ans.pb(tmp);
}
```

the below is not useful but can be useful in finding the left view

```python
queue<pair<Node*,int>> q;
q.push({root,1});
int curr=1;
while(q.size()){
  Node* p=q.front();
  q.pop();
  if(p.s>curr){
    curr=p.s;
    ans.pb(tmp);
    tmp.clear();
  }
  tmp.pb(p.f->val);
  if(p.f->left) q.push({p.f->left,p.s+1});
  if(p.f->right) q.push({p.f->right,p.s+1});
}
if(!tmp.empty()) ans.pb(tmp);
```

# Bottom View

from left to right

```python
#define s second
#define f first
#define val data
#define pb push_back

vector <int> bottomView(Node *root) {
    queue<pair<Node*,int>> q;
    q.push({root,1});
    int curr=1;
    vector<int> tmp;
    while(q.size()){
      auto p=q.front();
      q.pop();
      if(p.s>curr){
        curr=p.s;
        tmp.clear();
      }
      tmp.pb(p.f->val);
      if(p.f->left) q.push({p.f->left,p.s+1});
      if(p.f->right) q.push({p.f->right,p.s+1});      
    }
    return tmp;
}
```

# Zig Zag traversal

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

```python
vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    vector<vector<int>> ans;
    if(!root) return {};
    queue<TreeNode*> q;
    q.push(root);
    int level=1;
    while(q.size()){
        int sz=q.size();
        vector<int> tmp;
        while(sz--){
            TreeNode* n=q.front();
            q.pop();
            tmp.push_back(n->val);
            if(n->left) q.push(n->left);
            if(n->right) q.push(n->right);
        }
        if(level%2==0) reverse(tmp.begin(),tmp.end());
        level++;
        ans.push_back(tmp); 
    }
    return ans;

}
```

# Left View

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0001.png)

```python
void f(vector<int> &ans,Node* node, int l, int &maxl){
    if(!node) return;
    if(l>maxl){
        maxl=l;
        ans.push_back(node->data);
    }
    f(ans,node->left,l+1,maxl);
    f(ans,node->right,l+1,maxl);
}


vector<int> leftView(Node *root){
   vector<int> ans;
   int maxl=0;
   f(ans,root,1,maxl);
   return ans;
}
```

# Right View

```python
f(ans,node->right,l+1,maxl);
f(ans,node->left,l+1,maxl);
```

https://leetcode.com/problems/maximum-width-of-binary-tree/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0002.png)

the level should have atleast 2 nodes

this does not work

```python
class Solution {
    public:
        void t(TreeNode* node, int &left, int &right, int x){
            if(!node) return;
            left=min(x,left);
            right=max(x,right);        
            t(node->left, left, right, x-1);
            t(node->right, left, right, x+1);
        }
    
        int widthOfBinaryTree(TreeNode* root) {
            int left=INT_MAX,right=INT_MIN;
            t(root,left,right, 0);
            return right-left;
        }
    };
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0003.png)

a different kind of numbering

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0004.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0005.png)

we will use this formulae

```python
#define ll unsigned long long
class Solution {
public:


    ll widthOfBinaryTree(TreeNode* root) {
        queue<pair<TreeNode*,ll>> q;
        q.push({root,0});
        ll ans=0;

        while(q.size()){
            ll n=q.size();
            ll maxx=q.back().second, minn=q.front().second;
            ans=max(ans,maxx-minn+1);
            while(n--){
                auto p= q.front();
                q.pop();
                TreeNode* node=p.first;
                ll idx=p.second;
                if(node->left)
                q.push({node->left,2*idx+1});
                if(node->right)
                q.push({node->right,2*idx+2});
            }

        }
        return ans;        
    }
};
```

https://leetcode.com/problems/find-bottom-left-tree-value/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0006.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0007.png)

```python
class Solution {
    public:
        int t(TreeNode* node){
            queue<TreeNode*> q;
            q.push(node);
            int firstVisited;
            while(q.size()){
                int sz=q.size();
                firstVisited=q.front()->val;
                while(sz--){
                    TreeNode* n=q.front();
                    q.pop();
                    if(n->left) q.push(n->left);
                    if(n->right) q.push(n->right);
                }
            }
            return firstVisited;
        }
    
    
        int findBottomLeftValue(TreeNode* node) {
            return t(node);
        }
    };
```

# Writing long codes

https://leetcode.com/problems/even-odd-tree/description/

```python
class Solution {
    public:
        bool isEvenOddTree(TreeNode* root) {
            //even level, odd value, stricty increasing
            int level=0;
            queue<TreeNode*> q;
            q.push(root);
            while(q.size()){
                bool isOdd=level%2;
                int n=q.size();
                TreeNode* prev=nullptr;
                while(n--){
                    TreeNode* node=q.front();
                    q.pop();
                    if(node->left) q.push(node->left);
                    if(node->right) q.push(node->right);
                    long val=node->val;
                    long prevVal=INT_MIN;
                    if(prev){
                        prevVal=prev->val;
                    }
    
                    if(isOdd and val%2){
                        return 0;
                    } 
                    if(!isOdd and !(val%2)){
                        return 0;
                    }
                    if(isOdd){
                        val*=-1;
                        if(prev){
                            prevVal*=-1;
                        }  
                    }
                    if(prevVal>=val){
                        return 0;
                    }
                    prev=node;
                }
                level++;
            }
            return 1;
        }
    };
```

more elegant

```python
class Solution {
    public:
        bool isEvenOddTree(TreeNode* root) {
            queue<TreeNode*> que;
            
            que.push(root);
            bool even_level = true;
            
            while(!que.empty()) {
                int n = que.size();
                int prev;
                if(even_level)
                    prev = INT_MIN;
                else
                    prev = INT_MAX;
                
                while(n--) {
                    
                    TreeNode* node = que.front();
                    que.pop();
                    
                    if(node->left) {
                        que.push(node->left);
                    }
                    if(node->right) {
                        que.push(node->right);
                    }

                    if (even_level && (node->val % 2 == 0 || node->val <= prev)) {
                        return false;
                    }
                    if (!even_level && (node->val % 2 == 1 || node->val >= prev)) {
                        return false;
                    }
                    
                    prev = node->val;
                }
                
                even_level = !even_level;
                
            }
            
            return true;
        }
    };
    
    
```

https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0008.png)

```python
class Solution {
    public:
        vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
            vector<vector<int>> ans;
            if(!root) return {};
            queue<TreeNode*> q;
            q.push(root);
            int level=1;
            while(q.size()){
                int sz=q.size();
                vector<int> tmp;
                while(sz--){
                    TreeNode* n=q.front();
                    q.pop();
                    tmp.push_back(n->val);
                    if(n->left) q.push(n->left);
                    if(n->right) q.push(n->right);
                }
                if(level%2==0) reverse(tmp.begin(),tmp.end());
                level++;
                ans.push_back(tmp); 
            }
            return ans;
    
        }
    
    
        TreeNode* reverseOddLevels(TreeNode* root) {
            vector<vector<int>> ma=zigzagLevelOrder(root);
            
        }
    };
```

```python
# Only reversing the values by bfs
```

```python
class Solution {
    public:
        TreeNode* reverseOddLevels(TreeNode* root) {
            queue<TreeNode*> q;
            q.push(root);
            int l=0;
            
            while(q.size()){
                bool isOdd=l%2;
                int n=q.size();
                vector<TreeNode*> levelNodes;
                while(n--){
                    TreeNode* node= q.front();
                    q.pop();
                    if(isOdd){
                        levelNodes.push_back(node);
                    }
                    if(node->left){
                        q.push(node->left);
                    }
                    if(node->right){
                        q.push(node->right);
                    }
                }
                if(isOdd){
                    int l=0,h=levelNodes.size()-1;
                    while(l<h){
                        swap(levelNodes[l]->val,levelNodes[h]->val);
                        l++;
                        h--;
                    }
                }
                l++;
            }
            return root;
        }
    
    };
```

proper recursion

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0009.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_Traversal_2Hoirzontal__att_0010.png)

```python
class Solution {
    public:
        void f(TreeNode* l, TreeNode* r, int level){
            if(!l) return;
            if(level%2){
                swap(l->val,r->val);
            }
    
            f(l->left, r->right, level+1);
            f(l->right, r->left, level+1);        
        }
    
        TreeNode* reverseOddLevels(TreeNode* root) {
            f(root->left,root->right,1);
            return root;
        }
    };
```
{% endraw %}
