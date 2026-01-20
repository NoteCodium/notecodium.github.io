[leetcode.com](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)

1. use set and not map
```cpp
vector<vector<int>> ans;
priority_queue<pair<int,int>,vector<pair<int,int>>,cmp> pq;
map<pair<int,int>,bool> m;
pq.push({0,0});
m[{0,0}];
long long n1=v1.size(),n2=v2.size();
long long sz=n1*n2;
while(k-- and sz--){
    pair<int,int> p=pq.top();pq.pop();;
    int i=p.first,j=p.second;
    ans.push_back({v1[i],v2[j]});
    
    if(i+1<v1.size() and !m.count({i+1,j})){
        pq.push({i+1,j});
        m[{i+1,j}];
    }

    if(j+1<v2.size() and !m.count({i,j+1})){
        pq.push({i,j+1});
        m[{i,j+1}];
    }
}
```
```cpp
struct cmp{
    bool operator()(pair<int,int> &a, pair<int,int> &b)
		{
        return gv1[a.first]+gv2[a.second]>gv1[b.first]+gv2[b.second];
    }
};
```
