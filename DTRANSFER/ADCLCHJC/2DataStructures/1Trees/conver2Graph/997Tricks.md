---
title: 997Tricks
---

{% raw %}
# Tree to Graph

# NRI

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0001.png)

node 5 se 2 distance away

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

https://youtu.be/1PMjfQl_UVQ?si=1ZswvIcySN3iu0jx

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0002.png)

```python
class Solution {
    public:
        void t(TreeNode* node, unordered_map<TreeNode*, TreeNode*> &parent){
            //root will not have any parent and it will also be not 
            //populated by this algorithm
            if(!node){
                return;
            }

            if(node->left){
                parent[node->left]=node;
            }
            if(node->right){
                parent[node->right]=node;
            }

            t(node->left,parent);
            t(node->right,parent);
        }
    
        void bfs(TreeNode* target, int k, unordered_map<TreeNode*, TreeNode*> &parent, vector<int> &ans){
            queue<TreeNode*> q;
            q.push(target);
            unordered_set<int> visited;
            visited.insert(target->val);
            while(q.size()){
                if(k==0){
                    break;
                }
                int n=q.size();
                while(n--){
                    TreeNode* curr=q.front();
                    q.pop();
                    if(curr->left and !visited.count(curr->left->val)){
                        q.push(curr->left);
                        visited.insert(curr->left->val);
                    }
    
                    if(curr->right and !visited.count(curr->right->val)){
                        q.push(curr->right);
                        visited.insert(curr->right->val);
                    }
    
                    //root node will not have any parent
                    if(parent.count(curr) and !visited.count(parent[curr]->val)){
                        q.push(parent[curr]);
                        visited.insert(parent[curr]->val);
                    }
                }
                k--;
            }
            while(q.size()){
                ans.push_back(q.front()->val);
                q.pop();
            }
    
        }
    
        vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
            unordered_map<TreeNode*, TreeNode*> parent;
            t(root, parent);

            vector<int> ans;
            //notice how we need not to pass the root
            bfs(target,k, parent,ans);

            return ans;
        }
    }; 
```

pura heen mc, pura heen undirected graph

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0003.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0004.png)

```python
class Solution {
public:


    void makeGraph(unordered_map<int, vector<int>> &al, int par, TreeNode* node){
        if(!node) return;
        if(par!=-1){
            al[node->val].push_back(par);
        }
        if(node->left){
            al[node->val].push_back(node->left->val);
        }
        if(node->right){
            al[node->val].push_back(node->right->val);
        }
        makeGraph(al,node->val, node->left);
        makeGraph(al,node->val, node->right);        
    }


    int amountOfTime(TreeNode* root, int start) {
        unordered_map<int, vector<int>> al;
        makeGraph(al,-1,root);

        int minutes=-1;
        queue<int> q;
        unordered_set<int> visited;
        q.push(start);
        visited.insert(start);
        while(q.size()){
            int n=q.size();
            while(n--){
                int node=q.front();
                q.pop();
                for(auto nei: al[node]){
                    if(visited.count(nei)) continue;
                    q.push(nei);
                    visited.insert(nei);
                }
            }
            minutes++;
        }
        return minutes;
    }
};
```

striver done like above

# FAANG
Without map from dfs

https://youtu.be/JIlQvhrKuAk?si=fO_YY-aUDqw1-ch6

unintuitive

https://www.geeksforgeeks.org/problems/node-at-distance/1

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0005.png)

value of nodes can repeat

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0006.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0007.png)

```python
class Solution {
    public:
      void t(Node* node, vector<Node*> &path, int k, unordered_set<Node*> &se){
          if(!node) return;
          path.push_back(node);
          if(!node->left and !node->right){
              int n= path.size();
              if(k>n-1){
                path.pop_back();
                return;  
              } 
              se.insert(path[n-1-k]);
              path.pop_back();
              return; 
          }
          t(node->left,path,k,se);
          t(node->right,path,k,se);        
          path.pop_back();
      }
    
      int kthFromLeaf(Node* root, int k) {
          vector<Node*> path;
          unordered_set<Node*> se;
          t(root,path,k,se);
          return se.size();
      }
  };
```

```python
if(!node->left and !node->right){
    int n= path.size();
    if(k>n-1){
      path.pop_back();
      return;  
    } 
    se.insert(path[n-1-k]);
    path.pop_back();
    return; 
}
```

```python
if(!node->left and !node->right){ 
    if(k<=n-1){
        se.insert(path[n-1-k]);
    }
}
```

https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0008.png)

```python
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    public:
    
        void t(TreeNode* node, string &tmpPath, string &ansPath, int target){
            if(!node) return;
    
            if(node->val==target){
                ansPath=tmpPath;
                return;
            }
            tmpPath+='L';
            t(node->left,tmpPath,ansPath,target);
            tmpPath.pop_back();
    
            tmpPath+='R';
            t(node->right,tmpPath,ansPath,target);        
            tmpPath.pop_back();
        }
    
        string getDirections(TreeNode* root, int startValue, int destValue) {
            string tmpRoot2Start,ansRoot2Start,tmpRoot2Dest, ansRoot2Dest;
            t(root, tmpRoot2Start,ansRoot2Start,startValue);
            t(root, tmpRoot2Dest,ansRoot2Dest,destValue);
            int idx=0;
            int ansRoo2StartLen=ansRoot2Dest.size(),ansRoot2DestLen=ansRoot2Dest.size() ;
            while(idx<ansRoo2StartLen and idx<ansRoot2DestLen and ansRoot2Start[idx]==ansRoot2Dest[idx]){
                idx++;
            }
    
            //We dont handle the stuff explicityly
            // if(idx==ansRoo2StartLen or idx==ansRoot2DestLen){
            //     if(ansRoo2StartLen>=ansRoot2DestLen){
            //         // return string(lenLCA2Start, 'U');
            //     }
            // }
    
            int lenLCA2Start=ansRoot2Start.substr(idx).size();
            string LCA2Dest=ansRoot2Dest.substr(idx);
            return string(lenLCA2Start, 'U')+ LCA2Dest;
    
        }
    };
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0009.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0010.png)

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0011.png)

what if the startNode and endNode is present at the same path of lca

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_2DataStructures_1Trees_conver2Graph_997Tricks__att_0012.png)
{% endraw %}
