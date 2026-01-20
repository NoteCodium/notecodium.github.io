[Huffman Encoding | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1)

**Note:** While merging if two nodes have the same value, then the node which occurs at first will be taken on the left of Binary Tree and the other one to the right, otherwise Node with less value will be taken on the left of the subtree and other one to the right.?



# NLOGN

```cpp
class Solution{
public:
    struct Node{
        char c;
        int f;
        struct Node* l;
        struct Node* r;
        Node(char c, int f, Node* l, Node* r){
            this->c=c;
            this->f=f;
            this->l=l;
            this->r=r;
        }
    };
  
  
    struct cmp{
        bool operator()(Node* n1,Node* n2){
            return n1->f > n2->f;
        }  
    };
    
    void getCodes(string tmp, vector<string> &ans, Node* node){
        if(!node) return;
        if(!node->l and !node->r){
            ans.push_back(tmp);
            return;
        }
        getCodes(tmp+'0',ans,node->l);
        getCodes(tmp+'1',ans,node->r);
    }
    
	
	vector<string> huffmanCodes(string s,vector<int> f,int n){
	    priority_queue<Node*, vector<Node*>,cmp> pq;
	    for(int i=0;i<n;i++) pq.push(new Node(s[i],f[i],nullptr,nullptr)); 
	    while(pq.size()>1){
	        Node* n1=pq.top();pq.pop();
	        Node* n2=pq.top();pq.pop();		     
	        Node* n=new Node('#',n1->f+n2->f,n1,n2);
	        pq.push(n);
	    }
	    Node* root=pq.top();
	    vector<string> ans;
	    getCodes("",ans,root);
	    return ans;
	}
};
```