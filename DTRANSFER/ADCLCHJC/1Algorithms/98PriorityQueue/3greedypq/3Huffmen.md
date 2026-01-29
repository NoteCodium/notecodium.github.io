---
title: 3Huffmen
---

{% raw %}
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_3greedypq_3Huffmen__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_3greedypq_3Huffmen__att_0002.png)

# Process    
Always pick the two smallest

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_3greedypq_3Huffmen__att_0003.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_3greedypq_3Huffmen__att_0004.png)

# ENCODING :

Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.

class Solution {
  public:
    vector<string> huffmanCodes(string S, vector<int> f, int N) {
        // Code here
        
    }
};

https://www.geeksforgeeks.org/problems/huffman-encoding3345/1

sol. your map is already given

NLOGN

```python
class Solution{
public:  
    
    void getCodes(string tmp, vector<string> &ans, Node* node){
        if(!node) return;
        if(!node->l and !node->r){
            ans.push_back(tmp);
            return;
        }
        getCodes(tmp+'0',ans,node->l);
        getCodes(tmp+'1',ans,node->r);
    }
    
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
	

    void constructHuffmanTree(priority_queue<Node*, vector<Node*>,cmp> &pq){
        while(pq.size()>1){
            Node* n1=pq.top();pq.pop();
            Node* n2=pq.top();pq.pop();
            Node* n=new Node('#',n1->f+n2->f,n1,n2);
            pq.push(n);
        }
    }

    struct cmp{
        bool operator()(Node* n1,Node* n2){
            return n1->f > n2->f;
        }  
    };

	vector<string> huffmanCodes(string s,vector<int> f,int n){
	    priority_queue<Node*, vector<Node*>,cmp> pq;
	    for(int i=0;i<n;i++) pq.push(new Node(s[i],f[i],nullptr,nullptr)); 
        //constructing the initial pq

        constructHuffmanTree(pq);

	    Node* root=pq.top();
	    vector<string> ans;
        // Your task is to build the Huffman tree print all the huffman codes in preorder 
        //traversal of the tree.
	    getCodes("",ans,root);
	    return ans;
	}
};
```

# Decoding    
https://www.geeksforgeeks.org/problems/huffman-decoding/1

```python
class Solution {
    public:
      string decodeHuffmanData(struct MinHeapNode* root, string binaryString) {
          // Code here
          
      }

      struct MinHeapNode{
          char data;
          int freq;
          MinHeapNode *left, *right;
      };

  };
```

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_3greedypq_3Huffmen__att_0005.png)

```python
string decodeHuffmanData(struct MinHeapNode* root, string e){
    string d;
    struct MinHeapNode* curr=root;
    for(char c: e){
        if(c=='0') curr=curr->left;
        else curr=curr->right;
        
        if(!curr->left and !curr->right){
            //we reached a leaf node
            d+=curr->data;

            //start again from root
            curr=root;
        }
    }
    return d;
}
```
{% endraw %}
