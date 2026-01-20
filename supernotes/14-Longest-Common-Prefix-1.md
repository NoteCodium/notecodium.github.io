[Just a moment...](https://leetcode.com/problems/longest-common-prefix/description/)

```cpp
void lcp(string &ans, string &s, int minLen, int n){
    TrieNode* current = root;
    for(int i=0;i<minLen;i++){
        char c=s[i];
        int idx=c-'a';
        if(current->children[idx] && current->children[idx]->strings == n){
            ans.push_back(c);
            current=current->children[idx];
        }
        else{
            break;
        }
    }
}
```

```cpp
class Trie{
    private:
        struct TrieNode{
            TrieNode* children[26];
            int noOfTimesPresent;
            int strings; 

            TrieNode(){
                noOfTimesPresent = 0;
                strings = 0;
                for(int i = 0; i < 26; i++) {
                    children[i] = nullptr;
                }
            }
        };

        TrieNode* root=nullptr;

    public:

    Trie(){
        root = new TrieNode();
    }

    ~Trie() {
        delete root;
    }
/*******************************************************************************************/

    void insertUtil(TrieNode* node, string &word, int idx){
        node->strings++;
        if(idx==word.size()){
            node->noOfTimesPresent++;
            return;
        }
        int childIdx=word[idx]-'a';
        if(!node->children[childIdx]){
            node->children[childIdx]= new TrieNode();;
        }
        node=node->children[childIdx];        
        insertUtil(node,word,idx+1);   
    }

    void insert(string &word){
        insertUtil(root,word,0);
    }

/*******************************************************************************************/

    int searchUtil(string &word, int idx, TrieNode* node){
        if(!node) return 0;
        if(idx==word.size()) return node->noOfTimesPresent;
        return searchUtil(word,idx+1,node->children[word[idx]-'a']);
    }

    int search(string word) {
        return searchUtil(word,0,root);
    }

/*******************************************************************************************/


    int startsWithUtil(string &prefix, int idx, TrieNode* node){
        if(!node) return 0;
        if(idx==prefix.size()) return node->strings;
        return startsWithUtil(prefix,idx+1,node->children[prefix[idx]-'a']);
    }

    int startsWith(string prefix) {
        return startsWithUtil(prefix,0,root);
    }


/*******************************************************************************************/

    void eraseUtil(string &word, int idx, TrieNode* node){
        node->strings--;
        if(idx==word.size()){
            node->noOfTimesPresent--;
            return;
        }
        eraseUtil(word,idx+1,node->children[word[idx]-'a']);
    }


    void erase(string &word){
        if(search(word)){
            eraseUtil(word,0,root);
        }
    }

/*******************************************************************************************/

    void lcp(string &ans, string &s, int minLen, int n){
        TrieNode* current = root;
        for(int i=0;i<minLen;i++){
            char c=s[i];
            int idx=c-'a';
            if(current->children[idx] && current->children[idx]->strings == n){
                ans.push_back(c);
                current=current->children[idx];
            }
            else{
                break;
            }
        }
    }

};


class Solution {
public:
    string longestCommonPrefix(vector<string>& vos) {
        int n=vos.size();
        string minn=*min_element(vos.begin(),vos.end());
        int minLen=minn.size();

        Trie t= Trie();
        for(auto s: vos){
            t.insert(s);
        }

        string ans="";
        t.lcp(ans,vos[0],minLen,n);

        return ans;
    }
};
```
