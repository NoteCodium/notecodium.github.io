[Smallest Range Covering Elements from K Lists - LeetCode](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/)

![image.png](../images/4c111139-835f-4fc2-bb3f-9ee7a118dd77--image.png)

The above is basically this question with k vectors instead of 3 and priority queue will be used to maintain

[minimize max(ai,aj,ak) - min(ai,aj,ak)](https://my.supernotes.app/?preview=0e37e912-e52e-44ac-81e0-6bee17fdca45)

[Merging n sorted arrays](https://my.supernotes.app/?preview=9cf7ac4f-a16d-4d1e-8483-c3a4e78e7863)

```cpp
vector<vector<int>> gm;
class Solution {
public:
    struct cmp{ 
         bool operator()(pair<int,int> &a, pair<int,int> &b){ 
            int x=gm[a.first][a.second],y=gm[b.first][b.second];
            return x>y;
        } 
    };


    vector<int> smallestRange(vector<vector<int>>& ma) {
        gm=ma;
        vector<int> ansv(2);
        int n=ma.size();
        int ans=INT_MAX;
        int maxx=INT_MIN;
        vector<pair<int,int>> tmp;
        for(int i=0;i<n;i++){
            tmp.push_back({i,0});
            maxx=max(maxx,ma[i][0]);
        } 
        priority_queue<pair<int,int> ,vector<pair<int,int>>,cmp> pq(tmp.begin(),tmp.end());
        while(!pq.empty()){
            auto p=pq.top();pq.pop();
            int i=p.first,j=p.second;
            int minn=ma[i][j];
            if(maxx-minn<ans){
                ans=min(ans,maxx-minn);
                ansv[0]=minn;
                ansv[1]=maxx;
            }
            if(j+1<ma[i].size()){
                pq.push({i,j+1});
                maxx=max(maxx,ma[i][j+1]);    
            } 
            else break;
        }
        // cout<<ans;
        return ansv;
    }
};
```