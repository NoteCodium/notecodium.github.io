![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/98b8240b-7479-4464-83f9-bdaaa7c3e076--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/775d0a1b-af90-41b8-a4a1-1c3033cd9427--image.png)


[leetcode.com](https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/)
[Leetcode 1353. Maximum Number of Events That Can Be Attended - YouTube](https://youtu.be/ABH9cRhwmlg)
1. Sort based on end time

```cpp
int maxEvents(vector<vector<int>>& events) {
    sort(events.begin(),events.end(),[](auto &v1,auto &v2){
        return v1[1]<v2[1];
    });
    int ans=0;
    set<int> days;
    for(int i=1;i<=100000;i++) days.insert(i);
    for(auto &event:events){
        int s=event[0],e=event[1];
        auto it=days.lower_bound(s);
        if(it==days.end() or *it>e) continue;
        else{
            ans++;
            days.erase(it);
        }
    }
    return ans;
}
```

