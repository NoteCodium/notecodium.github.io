[ - LeetCode](https://leetcode.com/problems/design-in-memory-file-system/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9b39df1c-0531-4a63-8a84-d6353248c2a7--image.png)

```cpp
class FileSystem {
    class File{
        public:
            bool isFile=0;
            map<string,File*> files;
            string content;
    };
    File* root;

    vector<string> split(string &s){
        vector<string> ans;
        s="root"+s;
        stringstream ss(s);
        string tok;
        while(getline(ss,tok,'/')){
            ans.push_back(tok);
            cout<<tok<<endl;
        } 
        return ans; 
    }

public:
    FileSystem() {
        root=new File();  
    }

    File* lsUtil(vector<string> &components){
        File* curr=root;
        for (int i = 0; i < components.size(); i++) {
            curr = curr->files[components[i]];
        }
        return curr;
    }
    
    vector<string> ls(string path) {
        vector<string> components=split(path);
        File* curr=lsUtil(components);
        if(!curr) return {};
        if(curr->isFile){
            return {components.back()};
        }
        vector<string> resFiles;
        for(auto p: curr->files){
            resFiles.push_back(p.first);
        }
        return resFiles;
    }

    File* mkdirUtil(string path){
        File* curr=root;
        vector<string> components=split(path);
        for (int i = 0; i < components.size(); i++) {
            if(!curr->files[components[i]]){
                curr->files[components[i]]=new File();
            }
            curr = curr->files[components[i]];
        }
        return curr;
    }
    
    void mkdir(string path) {
        mkdirUtil(path);
    }
    
    void addContentToFile(string path, string content) {
        File* curr=mkdirUtil(path);
        curr->isFile=1;
        curr->content+=content;
    }
    
    string readContentFromFile(string path) {
        vector<string> components=split(path);
        File* curr=lsUtil(components);
        return curr->content;
    }
};

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem* obj = new FileSystem();
 * vector<string> param_1 = obj->ls(path);
 * obj->mkdir(path);
 * obj->addContentToFile(filePath,content);
 * string param_4 = obj->readContentFromFile(filePath);
 */
```

