[leetcode.com](https://leetcode.com/problems/word-ladder-ii/)

[G-31. Word Ladder - 2 | Optimised Approach for Leetcode - YouTube](https://youtu.be/AD4SFl7tu7I?si=m4bf_mEOPUiGHy6F)


Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, return *all the **shortest transformation sequences** from* `beginWord` *to* `endWord`*, or an empty list if no such sequence exists.*


```cpp
void bfs(string &beginWord, string &endWord, unordered_set<string> &words, unordered_map<string,int> &levels){
    queue<pair<string,int>> q;
    unordered_map<string,bool> visited;
    visited[beginWord]=1;
    levels[beginWord]=0;
    q.push({beginWord,0});
    while(!q.empty()){
        auto p=q.front();q.pop();
        string tmp=p.first;
        if(tmp==endWord) return;
        for(int i=0;i<tmp.size();i++){
            char ch=tmp[i];
            for(int j=0;j<26;j++){
                char rep=j+'a';
                tmp[i]=rep;
                if(words.count(tmp) and !visited[tmp]){
                    visited[tmp]=1;
                    q.push({tmp,p.second+1});
                    levels[tmp]=p.second+1;
                }
            }
            tmp[i]=ch;
        }
    }
}

void backtrack(string &word,string &beginWord, vector<vector<string>> &ans, vector<string> &tmp, unordered_map<string,int> &levels){
    if(word==beginWord){
        reverse(tmp.begin(),tmp.end());
        ans.push_back(tmp);
        reverse(tmp.begin(),tmp.end());
        return;
    }

    int currLevel=levels[word];
    for(int i=0;i<word.size();i++){
        char ch=word[i];
        for(int j=0;j<26;j++){
            char rep=j+'a';
            word[i]=rep;
            if(levels.count(word) and currLevel==1+levels[word]){
                tmp.push_back(word);
                backtrack(word,beginWord,ans,tmp,levels);
                tmp.pop_back();
            }
        }
        word[i]=ch;
    }
}

vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> words(wordList.begin(),wordList.end());
    if(!words.count(endWord)) return {};
    unordered_map<string,int> levels;
    bfs(beginWord,endWord,words,levels);
    if(!levels.count(endWord)) return {};
    vector<vector<string>> ans;
    vector<string> tmp;
    tmp.push_back(endWord);
    backtrack(endWord,beginWord,ans,tmp,levels);
    return ans;
}
```
