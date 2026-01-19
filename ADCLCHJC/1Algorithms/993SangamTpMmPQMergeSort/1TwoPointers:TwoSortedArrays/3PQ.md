Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.


```python
    vector<vector<int>> kSmallestPairs(vector<int>& v1, vector<int>& v2, int k) {
        vector<vector<int>> ans;
        auto cmp=[&](auto &a, auto &b){
            return v1[a.first]+v2[a.second]>v1[b.first]+v2[b.second];
        };

        priority_queue<pair<int,int>,vector<pair<int,int>>,decltype(cmp)> pq(cmp);
        map<pair<int,int>,bool> m;
        pq.push({0,0});
        m[{0,0}];
        long long n1=v1.size(),n2=v2.size();
        while(k--){
            pair<int,int> p=pq.top();
            pq.pop();;
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
        return ans; 
                
    }
```
