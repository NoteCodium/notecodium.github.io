---
title: 4AlienDictionary
---

{% raw %}
https://leetcode.com/problems/alien-dictionary/description/     
premium   
https://www.geeksforgeeks.org/problems/alien-dictionary/1

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_4AlienDictionary__att_0001.png)

```python
string topo(unordered_map<char, vector<char>> al){   
    string ans;
    //finding the indegegree of all the nodes
    unordered_map<char,int> ind;
    for(auto p: al){
        ind[p.first];
        //even their indegree is 0,
        //thy get regsitered in the map
    }

    for(auto p:al){
        // ind[p.first]; we can combine logic here but for better
        //understanding we are doing it seperately
        for(auto c: p.second){
            ind[c]++;
        }
    }

    queue<char> q;
    // // doing the first insertion in the queue
    for(auto p: ind){
        if(p.second==0){
            q.push(p.first);
        }
    }

    while(q.size()){
        char x=q.front(); 
        q.pop();
        ind.erase(x);
        ans.push_back(x);
        for(char c: al[x]){
            ind[c]--;
            if(ind[c]==0){
                q.push(c);
            }
        }
    }  
    return ans;
}



string alienOrder(vector<string>& words) {
    unordered_map<char, vector<char>> al;
    for(string word: words) {
        for (char c: word) {
            al[c];
        }
    }
    //we have a map of all the unique char of the language        

    int n=words.size();
    for(int i=0;i<=n-2;i++){
        string s1=words[i];
        string s2=words[i+1];

        int minLen=min(s1.size(),s2.size());
        int p=0;
        while(p<minLen){
            if(s1[p]!=s2[p]){
                al[s1[p]].push_back(s2[p]);
                break;
            } 
            p++;
        }
        if(p==minLen and s1.size()>s2.size()) return "";
    }
    string res=topo(al);
    return res.size()==al.size()?res:"";
}
```

![image.png](/DTRANSFER/notebook_images/DTRANSFER_ADCLCHJC_1Algorithms_60Graph_4TopilogicalSort_4AlienDictionary__att_0002.png)

the reverse in this question, string is given, verify the order of words is  correct or not        
https://leetcode.com/problems/verifying-an-alien-dictionary/description/

```python
bool isAlienSorted(vector<string>& words, string order) {
    unordered_map<char,int> m;
    for(int i=0;i<order.size();i++){
        m[order[i]]=i;
        //for faster lookups
    } 
    int n=words.size();
    for(int i=0;i<=n-2;i++){
        string w1=words[i],w2=words[i+1];
        int minLen=min(w1.size(),w2.size());
        int p=0;
        for(p<minLen){
            if(w1[p]==w2[p]) continue;
            else if(m[w1[p]]<m[w2[p]]) break;
            else return 0;
            
            p++;
        }
        if(p==minLen and w1.size()>w2.size()) return 0;
    }
    return 1;
}
```
{% endraw %}
