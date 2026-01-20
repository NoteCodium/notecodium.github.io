[Min distance between two given nodes of a Binary Tree | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1)

```cpp
Node* findLCA(Node* n, int v1, int v2){
    if(!n) return NULL;
    if(n->data==v1 or n->data==v2) return n;
    Node* lst=findLCA(n->left,v1,v2);
    Node* rst=findLCA(n->right,v1,v2);
    if(!lst) return rst;
    if(!rst) return lst;
    return n; 
}    


void t(Node* n,int LCA ,int v1, int v2, int &l1, int &l2, int &l3,int l){
    if(!n) return;
    if(n->data==LCA) l1=l;
    if(n->data==v1) l2=l; 
    if(n->data==v2) l3=l;
    t(n->left,LCA,v1,v2,l1,l2,l3,l+1);
    t(n->right,LCA,v1,v2,l1,l2,l3,l+1);        
}


int findDist(Node* root, int v1, int v2) {
    int LCA=(findLCA(root,v1,v2))->data;
    int l1=-1,l2=-1,l3=-1,l=0;
    t(root,LCA,v1,v2,l1,l2,l3,l);
    return l2-l1 + l3-l1;
}
```
