https://leetcode.com/problems/evaluate-division/description/     



![image.png](3FractionalMultiplication_images/image.png)


![image.png](3FractionalMultiplication_images/image.png)


![image.png](3FractionalMultiplication_images/image.png)


```python
    vector<double> ansv;

    int n=c.size();
    unordered_map<string, vector<pair<string, double>>> al;
    for(int i=0;i<n;i++){
        al[c[i][0]].push_back({c[i][1],v[i]});
        al[c[i][1]].push_back({c[i][0],1/v[i]});        
    }
```

```python
for(int i=0;i<q.size();i++){
    unordered_set<string> visited;
    double ans=-1.0,tmp=1.0;
    string src=q[i][0],des=q[i][1];
    dfsal(src,des,al,visited,ans,tmp);
    ansv.push_back(ans);
}
```

```python
void dfsal(string &node, string &des,unordered_map<string, vector<pair<string, double>>> &al, unordered_set<string> &visited, double &ans, double tmp){
    if(!al.count(node) or visited.count(node)){
        return;
    } 
    visited.insert(node);
    if(node==des){
        ans=tmp;
        return;
    }
    for(auto x:al[node]){
        dfsal(x.first,des,al,visited,ans,tmp*(x.second));
    }  
}
```
