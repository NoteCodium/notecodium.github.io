```cpp
priority_queue<int> pq(v.begin(),v.end());
while(pq.size()!=1 and pq.size()!=0){
    int max1=pq.top();
    pq.pop();
    int max2=pq.top();
    pq.pop();
    if(max1==max2) continue;
    pq.push(max1-max2);
}
if(pq.empty()) return 0;
return pq.top();
```
