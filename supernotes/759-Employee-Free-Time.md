[Just a moment...](https://leetcode.com/problems/employee-free-time/description/?envType=list&envId=ppzcw7vd)
[Problem Challenge 3: Employee Free Time (hard) ](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63936f6bb15a00b56fb3cf01)

```cpp
vector<Interval> employeeFreeTime(vector<vector<Interval>> ma) {
        if(!ma.size()) return {};
        vector<Interval> ans;
        auto cmp=[](auto &a, auto &b){return a[0]>b[0];};
        priority_queue<vector<int>, vector<vector<int>>,decltype(cmp)> pq;
        int n=ma.size();
        for(int i=0;i<n;i++){
          pq.push({ma[i][0].start,ma[i][0].end,i,0});
        }
        int endTime=pq.top()[1];
        while(!pq.empty()){
          auto currInt=pq.top();pq.pop();
          int newStartTime=currInt[0];
          int newEndTime=currInt[1];
          if(newStartTime>endTime) ans.push_back(Interval(endTime,newStartTime));
          endTime=max(endTime,newEndTime);
          int row=currInt[2],col=currInt[3];
          if(col+1<ma[row].size()) pq.push({ma[row][col+1].start,ma[row][col+1].end,row,col+1});
    }
    return ans;
}
```

