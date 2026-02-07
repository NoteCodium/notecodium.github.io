[Minimum Platforms | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1)
![image.png](../images/b0c6c51d-72cd-4f8b-ae4c-fcc724e46c10--image.png)
0000 to 2359


```cpp
int findPlatform(int arr[], int dep[], int n){
    vector<int> v(2460+5,0);
    for(int i=0;i<n;i++) v[arr[i]]++;
    for(int i=0;i<n;i++) v[dep[i]+1]--;
    for(int i=1;i<2460;i++) v[i]+=v[i-1];
    return *max_element(v.begin(),v.end());
}
```
[Meeting rooms | InterviewBit](https://www.interviewbit.com/problems/meeting-rooms/)



--------------------------------------------------------------------------------------------------

```cpp
int minMeetingRooms(vector<vector<int>>& ma) {
    priority_queue<vector<int>,vector<vector<int>>,greater<vector<int>>> pq;
    for(auto in: ma){
        pq.push({in[0],1});
        pq.push({in[1],-1});           
    }
    int ans=1,sum=0;
    while(!pq.empty()){
        int to=pq.top()[1];pq.pop();
        sum+=to;
        ans=max(ans,sum);
    }   
    return ans;
}
```

--------------------------------------------
# Also possible with sweep lines



# The below is extinct



\
[leetcode.com](https://leetcode.com/problems/meeting-rooms-ii/description/)

[youtu.be](https://youtu.be/FdzJmTCVyJU?si=jyvhDBzsmdp4JTJi)

![image.png](../images/e0f0d322-455f-4e3e-b89e-784daa9ff899--image.png)

![image.png](../images/7f55b217-cfea-41bc-8be3-cd35a1717f90--image.png)

Another meeting started before the ending of the first meeting

![image.png](../images/dc607891-ff91-448e-96eb-1c3d29a124b1--image.png)





```cpp
int minMeetingRooms(vector<vector<int>>& intervals) {
    vector<int> s,e;
    int n=intervals.size();
    for(int i=0;i<n;i++){
        s.push_back(intervals[i][0]);
        e.push_back(intervals[i][1]);
    }
    sort(s.begin(),s.end());
    sort(e.begin(),e.end());
    int i=0,j=0;
    int ans=0;
    int cnt=0;
    while(i<n){
        if(s[i]<e[j]){
            i++;
            cnt++;
        }
        else{
            j++;
            cnt--;
        }
        ans=max(cnt,ans);
    }
    return ans;
}
```
