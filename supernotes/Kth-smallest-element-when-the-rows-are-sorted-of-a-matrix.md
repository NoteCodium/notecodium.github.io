[Kth Smallest Number in M Sorted Lists (medium)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63a376b4a41249d4abecb716)


```cpp
using namespace std;

#include <iostream>
#include <queue>
#include <vector>

class Solution {
public:

int findKthSmallest(const vector<vector<int>> &ma, int k) {
  int result = 0;
  int rr=ma.size();
  vector<vector<int>> tmp;
  for(int r=0;r<rr;r++) tmp.push_back({r,0});

  auto cmp=[&](vector<int> &a, vector<int> &b){
    int x=ma[a[0]][a[1]],y=ma[b[0]][b[1]];
    return x>y;
  };


  priority_queue<vector<int> ,vector<vector<int>>,decltype(cmp)> pq(cmp,tmp);

  while(k){
      auto vv=pq.top();pq.pop();
      int r=vv[0],c=vv[1];
      result=ma[r][c];
      if(c+1<ma[r].size()) pq.push({r,c+1});
      k--;
    }

  return result;
}
};

```


```cpp
struct cmp{ 
    bool operator()(vector<int> &a, vector<int> &b){ 
        int x=gm[a[0]][a[1]],y=gm[b[0]][b[1]];
        return x>y;
    } 
};

int findKthSmallest(const vector<vector<int>> &ma, int k) {
  gm=ma;
  int result = 0;
  int rr=ma.size();
  vector<vector<int>> tmp;
  for(int r=0;r<rr;r++) tmp.push_back({r,0});
  priority_queue<vector<int> ,vector<vector<int>>,cmp> pq(tmp.begin(),tmp.end());

  while(!pq.empty() and k){
      auto vv=pq.top();pq.pop();
      int r=vv[0],c=vv[1];
      result=ma[r][c];  
      if(c+1<ma[r].size()) pq.push({r,c+1});
      k--;
    }

  return result;
}
```