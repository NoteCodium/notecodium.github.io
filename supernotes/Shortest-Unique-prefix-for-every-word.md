[Shortest Unique prefix for every word | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/1?problemType=functional&page=1&sortBy=submissions&category%5B%5D=Trie&query=problemTypefunctionalpage1sortBysubmissionscategory%5B%5DTrie)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7d93372b-e7c8-4eca-8846-0b4a443fac17--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/5d55df30-1623-4fba-9f0b-0842f05a9b7a--image.png)


```cpp
    void findUniquePrefixUtil(string &s, TrieNode* node, int idx, vector<string> &ans){
        if(node->strings==1){
            ans.push_back(s.substr(0,idx));
            return;
        }
        findUniquePrefixUtil(s,node->children[s[idx]-'a'],idx+1,ans);
    }

    void findUniquePrefix(string &s, vector<string> &ans){
        findUniquePrefixUtil(s, root, 0, ans);
    }
```


```cpp
class Trie {
private:
    struct TrieNode{
        TrieNode* children[26];
        bool isPresent;
        int strings;    
    };

    TrieNode* root=nullptr;

    TrieNode* createNode(){
        TrieNode *node=new TrieNode;
        node->isPresent=0;
        node->strings=0;
        for(int i=0;i<26;i++) node->children[i]=nullptr;
        return node;
    }

public: 
    Trie(){
        root= createNode();
    }
/*******************************************************************************************/
    void insertUtil(TrieNode* node, string &word, int idx){
        node->strings++;
        if(idx==word.size()){
            node->isPresent=1;
            return;
        }
        int childIdx=word[idx]-'a';
        if(!node->children[childIdx]){
            node->children[childIdx]=createNode();
        }
        node=node->children[childIdx];        
        insertUtil(node,word,idx+1);   
    }
    
    void insert(string word) {
        insertUtil(root,word,0);
    }

/***************************************************************************************/    
/*this delete function is wrong and will disturb  startsWith*/
    void deleteUtil(string &word, int idx, TrieNode* node){
        node->strings--;
        if(idx==word.size()){
            node->isPresent=0;
            return;
        }
        deleteUtil(word,idx+1,node->children[word[idx]-'a']);
    }

  
  
    void deleteKey(TrieNode *root, char wordArray[]){
        int n= strlen(wordArray);
        string word;
        for(int i=0;i<n;i++) word.push_back(wordArray[i]);
        bool found=0;
        deleteWord(word);    
    }

    void deleteWord(string word) {
        if(search(word)){
            deleteUtil(word,0,root);
        }
    }

/*******************************************************************************/    
    bool searchUtil(string &word, int idx, TrieNode* node){
        if(!node) return 0;
        if(idx==word.size()) return node->isPresent;
        return searchUtil(word,idx+1,node->children[word[idx]-'a']);
    }

    bool search(string word) {
        return searchUtil(word,0,root);
    }
/*********************************************************************************/    
    int startsWithUtil(string &prefix, int idx, TrieNode* node){
        if(!node) return 0;
        if(idx==prefix.size()) return node->strings;
        return startsWithUtil(prefix,idx+1,node->children[prefix[idx]-'a']);
    }

    bool startsWith(string prefix) {
        return startsWithUtil(prefix,0,root);
    }
/************************************************************************************/

    void findUniquePrefixUtil(string &s, TrieNode* node, int idx, vector<string> &ans){
        if(node->strings==1){
            ans.push_back(s.substr(0,idx));
            return;
        }
        findUniquePrefixUtil(s,node->children[s[idx]-'a'],idx+1,ans);
    }

    void findUniquePrefix(string &s, vector<string> &ans){
        findUniquePrefixUtil(s, root, 0, ans);
    }


};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */


class Solution{

    
    public:
    vector<string> findPrefixes(string arr[], int n){
        Trie t= Trie();
        for(int i=0;i<n;i++) t.insert(arr[i]);
        vector<string> ans;
        for(int i=0;i<n;i++) t.findUniquePrefix(arr[i],ans);
        return ans;
    }
    
};
```