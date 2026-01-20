[Course Schedule III - LeetCode](https://leetcode.com/problems/course-schedule-iii/description/)

# do with recursion according to editorial
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/d3241e17-bedf-4d98-8f15-86982dfbcbaf--image.png)

Tough greedy approach

only possibe to understand it by watching the video

[Course Schedule III | Live Coding with Explanation | Leetcode - 630 - YouTube](https://youtu.be/ey8FxYsFAMU?si=5dPEQHn8uzOceF36)


```cpp
int scheduleCourse(vector<vector<int>>& ma) {
    //[durationi, lastDayi]
    sort(ma.begin(),ma.end(),[](vector<int> &a, vector<int> &b){
        return a[1]<b[1];
    });
    priority_queue<int> curr;
    int time=0;
    for(auto v: ma){
        if(v[0]<=v[1]){
            if(v[0]+time<=v[1]){
                curr.push(v[0]);
                time+=v[0];
            }
            else{
                if(curr.top()>v[0]){
                    time-=curr.top();curr.pop();
                    time+=v[0];
                    curr.push(v[0]);                        
                }
            }

        }
    }
    return curr.size();

}
```