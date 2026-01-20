[Just a moment...](https://leetcode.com/problems/meeting-rooms-iii/description/)

[Meeting Rooms III | Detailed Intuition | Brute Force | Optimal | Leetcode 2402 - YouTube](https://youtu.be/8JTr7Hk0p2o?si=HRkmaoMLm5phzATx)


```cpp
int mostBooked(int no, vector<vector<int>>& ma) {
    int n=ma.size();
    sort(ma.begin(),ma.end());
    vector<int> roomUsed(no,0);
    priority_queue<V,vector<V>,greater<V>> usedRooms;
    vector<int> tmp;
    for(int i=0;i<no;i++) tmp.push_back(i);
    priority_queue<int,vector<int>,greater<int>> rooms(tmp.begin(),tmp.end());

    for(auto in: ma){
        int start=in[0],end=in[1];
        int duration=end-start;

        while(!usedRooms.empty() and usedRooms.top()[0]<=start){
            int availRoom=usedRooms.top()[1];usedRooms.pop();
            rooms.push(availRoom);
        }

        if(!rooms.empty()){
            int currRoom=rooms.top();rooms.pop();
            usedRooms.push({end,currRoom});
            roomUsed[currRoom]++;
        }
        else{
            int futRoom=usedRooms.top()[1];
            long long endTime=usedRooms.top()[0];
            usedRooms.pop();
            usedRooms.push({endTime+duration,futRoom});
            roomUsed[futRoom]++;
        }
    }
    return find(roomUsed.begin(),roomUsed.end(),*max_element(roomUsed.begin(),roomUsed.end()))-roomUsed.begin();

}
```

