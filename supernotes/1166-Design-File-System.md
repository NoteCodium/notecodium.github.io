[Design File System - LeetCode](https://leetcode.com/problems/design-file-system/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2380198d-4d88-4adf-b553-3741ab0eb12c--image.png)

do its trie solution

```cpp
class FileSystem {
    unordered_map<string,int> m;

public:
    FileSystem() {
        
    }
    
    bool createPath(string path, int value) {
        if(path.empty() or path=="/" or m.count(path)) return 0;
        if(m.count(path)) return 0;
        int delimIdx=path.find_last_of('/')-1;
        string par=path.substr(0, delimIdx+1);
        if(par!="" and !m.count(par)) return 0;
        //this is how we make sure we rejectted / and ""
        m[path]=value;
        return 1;
    }
    
    int get(string path) {
        if(!m.count(path)) return -1;
        return m[path];
    }
};

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem* obj = new FileSystem();
 * bool param_1 = obj->createPath(path,value);
 * int param_2 = obj->get(path);
 */
```

# Trie

```cpp
class FileSystem {
    class TrieNode{
        public:
            string name;
            int val=-1;
            unordered_map <string,TrieNode*> m;
            //storing nodes
            //change

            TrieNode(string name){
                this->name=name;
            }
    };

    TrieNode *root=nullptr;

    vector<string> split(string &s){
        vector<string> ans;
        stringstream ss(s);
        string tok;
        while(getline(ss,tok,'/')){
            ans.push_back(tok);
            // cout<<tok<<endl;
        } 
        return ans; 
    }

public:
    FileSystem() {
        this->root= new TrieNode(""); 
    }

    int get(string path){
        vector<string> components=split(path);
        TrieNode* curr = this->root;
        for(int i=1;i<components.size();i++){
            if(!(curr->m[components[i]])){
                return -1;
            }
            curr=curr->m[components[i]];
        }
        return curr->val;
    }

    bool createPath(string path, int value){
        vector<string> components=split(path);
        TrieNode* curr = this->root;
        for(int i=1;i<components.size();i++){
            if(!(curr->m[components[i]])){
                if(i==(int)(components.size()-1)){
                    curr->m[components[i]]=new TrieNode(components[i]);
                }
                else{
                    return 0;
                }
            }
            curr=curr->m[components[i]];
        }

        if(curr->val!=-1) return 0;
        curr->val=value;
        return 1;
    }



    
};

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem* obj = new FileSystem();
 * bool param_1 = obj->createPath(path,value);
 * int param_2 = obj->get(path);
 */
```
