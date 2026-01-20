[Convert an Array Into a 2D Array With Conditions - LeetCode](https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/?envType=daily-question&envId=2024-01-02)

[2610. Convert an Array Into a 2D Array With Conditions | Hash Table | Arrays | Amazon - YouTube](https://youtu.be/XxBW71n-9FA?si=6OFWpHQUkY7bKNTG)

```cpp
vector<vector<int>> findMatrix(vector<int>& nums) {
        unordered_map<int,int> m;
        for(int x: nums) m[x]++;
        int distinctElements=m.size();
        priority_queue<vector<int>> pq;
        for(auto p: m) pq.push({p.second,p.first});
        vector<vector<int>> ans;
        
        while(!pq.empty()){
            vector<vector<int>> tmp;
            vector<int> tmpRow;
            while(1){
                if(pq.empty()){
                    ans.push_back(tmpRow);
                    break;
                }
                auto p=pq.top();pq.pop();
                tmpRow.push_back(p[1]);
                if(p[0]-1>0) tmp.push_back({p[0]-1,p[1]});
            }
            for(auto v: tmp) pq.push(v);
        }
        return ans;
    }
```

# Elegant as Fuck

```cpp
vector<vector<int>> findMatrix(vector<int>& v) {
    unordered_map<int,int> m;
    vector<vector<int>> ans;
    for(int x:v){
        m[x]++;
        if(ans.size()<m[x]) ans.push_back({});
        ans[m[x]-1].push_back(x);
    }

    return ans;
}
```
