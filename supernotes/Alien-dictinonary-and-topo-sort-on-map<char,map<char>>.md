[leetcode.com](https://leetcode.com/problems/alien-dictionary/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/69da800e-6eff-4f84-a587-cf1f9eab1dc8--image.png)


```cpp
string topo(unordered_map<char, vector<char>> al){   
    string ans;
    //finding the indegegree of all the nodes
    unordered_map<char,int> ind;
    for(auto p:al)
    {
        ind[p.first];
        for(auto c: p.second)
        {
            ind[c]++;
        }
    }
    queue<char> q;
    // // doing the first insertion in the queue
    for(auto p: ind)
    {
        if(p.second==0)
        {
            q.push(p.first);
        }
    }

    while(!q.empty()){
        char x=q.front(); q.pop();
        ind.erase(x);
        ans.push_back(x);
        for(char c: al[x])
        {
            ind[c]--;
            if(ind[c]==0)
            {
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

    int n=words.size();
    for(int i=0;i<=n-2;i++)
    {
        string s1=words[i];
        string s2=words[i+1];

        int minLen=min(s1.size(),s2.size());
        int p=0;
        while(p<minLen)
        {
            if(s1[p]!=s2[p])
            {
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