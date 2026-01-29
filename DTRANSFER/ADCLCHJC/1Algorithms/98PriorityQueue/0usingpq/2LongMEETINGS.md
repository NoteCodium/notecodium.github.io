---
title: 2LongMEETINGS
---

{% raw %}
2402. Meeting Rooms III    
https://leetcode.com/problems/meeting-rooms-iii/description/    
https://www.youtube.com/watch?v=8JTr7Hk0p2o    
![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_0usingpq_2LongMEETINGS__att_0001.png)

![image.png](/transfernew/notebook_images/transfernew_ADCLCHJC_1Algorithms_98PriorityQueue_0usingpq_2LongMEETINGS__att_0002.png)

```python
#define V vector<long long>
int mostBooked(int noOfRooms, vector<vector<int>>& meetings) {
    int n=meetings.size();
    sort(meetings.begin(),meetings.end());
    //
    vector<int> roomAvailableAfter(noOfRooms,0);
    //
    vector<int> roomOfTimesRoomUsed(noOfRooms,0);


    for(auto meeting: meetings){
        int start=meeting[0],end=meeting[1];
        int duration=end-start;
        
    
    }

}
```

```python
#define V vector<long long>
int mostBooked(int noOfRooms, vector<vector<int>>& meetings) {
    int n=meetings.size();
    sort(meetings.begin(),meetings.end());
    //
    vector<int> noOfTimesRoomUsed(noOfRooms,0);
    //{endTime,roomNo} in increasing order
    priority_queue<V,vector<V>,greater<V>> usedRooms;


    vector<int> tmp;
    for(int i=0;i<noOfRooms;i++) tmp.push_back(i);
    //{roomNumber in increasing order}
    priority_queue<int,vector<int>,greater<int>> freeRooms(tmp.begin(),tmp.end());

    for(auto meeting: meetings){
        int start=meeting[0],end=meeting[1];
        int duration=end-start;


        //the top will have the room having the minimum start time
        //in this block of code, we are checking that when the next
        //meeting starts, is there any room which is getting free
        while(usedRooms.size() and usedRooms.top()[0]<=start){
            int freeRoom=usedRooms.top()[1];
            usedRooms.pop();
            freeRooms.push(freeRoom);
        }

        if(freeRooms.size()){
            //room is available
            int currRoom=freeRooms.top();
            freeRooms.pop();
            usedRooms.push({end,currRoom});
            noOfTimesRoomUsed[currRoom]++;
        }
        else{
            //room is not available
            int futRoom=usedRooms.top()[1];
            long long endTime=usedRooms.top()[0];
            usedRooms.pop();
            usedRooms.push({endTime+duration,futRoom});
            noOfTimesRoomUsed[futRoom]++;
        }
    }
    return find(noOfTimesRoomUsed.begin(),noOfTimesRoomUsed.end(),*max_element(noOfTimesRoomUsed.begin(),noOfTimesRoomUsed.end()))-noOfTimesRoomUsed.begin();

}
```
{% endraw %}
