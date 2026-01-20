[leetcode.com](https://leetcode.com/problems/evaluate-division/description/)

# Weighted graph
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7c6d84bb-3eb7-447f-8fce-a68cec48c36c--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8ad91df9-b2ba-4987-968a-b68c5fb1ff7b--image.png)


```cpp
    vector<double> ansv;

    int n=c.size();
    unordered_map<string, vector<pair<string, double>>> al;
    for(int i=0;i<n;i++){
        al[c[i][0]].push_back({c[i][1],v[i]});
        al[c[i][1]].push_back({c[i][0],1/v[i]});        
    }
```
```cpp
    for(int i=0;i<q.size();i++){
        unordered_set<string> visited;
        double ans=-1.0,temp=1.0;
        string src=q[i][0],des=q[i][1];
        dfsal(src,des,al,visited,ans,temp);
        ansv.push_back(ans);
    }
```

```cpp
void dfsal(string &node, string &des,unordered_map<string, vector<pair<string, double>>> &al, unordered_set<string> &visited, double &ans, double temp){
    if(!al.count(node)) return;
    if(visited.count(node)) return ;
    visited.insert(node);
    if(node==des)
    {
        ans=temp;
        return;
    }
    for(auto x:al[node])
    {
        dfsal(x.first,des,al,visited,ans,temp*(x.second));
    }  
}
```
