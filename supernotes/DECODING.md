[Huffman Decoding | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/huffman-decoding/1)

```cpp
string decodeHuffmanData(struct MinHeapNode* root, string e){
    string d;
    struct MinHeapNode* curr=root;
    int n=e.size();
    for(int i=0;i<n;i++){
        if(e[i]=='0') curr=curr->left;
        else curr=curr->right;
        
        if(!curr->left and !curr->right){
            d+=curr->data;
            curr=root;
        }
    }
    return d;
}
```