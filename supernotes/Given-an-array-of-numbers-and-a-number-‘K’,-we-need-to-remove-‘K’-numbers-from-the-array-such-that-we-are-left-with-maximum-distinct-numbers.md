[Quote from “Maximum Distinct Elements (medium)”](https://arc.net/l/quote/oiqxjnak)

```cpp
int findMaximumDistinctElements(const vector<int> &v, int no) {
  unordered_map<int,int> m;
  for(int x: v) m[x]++;
  vector<int> tmp;
  int dis=0;
  for(auto p: m){
    if(p.second==1) dis++;
    else tmp.push_back(p.second);
  } 
  priority_queue<int,vector<int>,greater<int>> pq(tmp.begin(),tmp.end());
  //while there are elements having non 1 frequency
  //and no of operations havenot become zero
  //increasing pq taki jaldi jaldi frequeny 1 milna shuru ho
  while(!pq.empty() and no!=0){
    int x=pq.top();pq.pop();
    if(x==1){
      dis++;
    }
    else{
      x--;
      pq.push(x);  
      no--;
    }
  }
  if(!pq.empty() and pq.top()==1) dis++;
  if(no!=0 and dis>=no) dis-=no;
  return dis;   
}
```