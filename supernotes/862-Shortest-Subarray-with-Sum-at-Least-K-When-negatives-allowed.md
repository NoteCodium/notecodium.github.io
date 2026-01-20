[Shortest Subarray with Sum at Least K - LeetCode](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/)

[https://www.youtube.com/watch?si=T8lpapqDu7VdQg5D&v=Jm-ZTGd6TOQ&feature=youtu.be](https://youtu.be/Jm-ZTGd6TOQ?si=T8lpapqDu7VdQg5D)

```cpp
void f(long ps, deque<pair<long,int>> &d){
    while(!d.empty() and ps<=d.back().first) d.pop_back();
}

void ff(long ps, deque<pair<long,int>> &d, long chk, int &len, int idx){
    while(!d.empty() and chk>=d.front().first){
        len=min(len,idx-d.front().second);
        d.pop_front();
    }
}

int shortestSubarray(vector<int>& v, int k) {
    int n=v.size();
    int len=INT_MAX;
    long ps=0;
    deque<pair<long,int>> d;
    d.push_front({0,-1});
    for(int i=0;i<n;i++){
        ps+=v[i];
        f(ps,d);
        long chk=ps-k;
        ff(ps,d,chk,len,i);
        d.push_back({ps,i});
    }
    return len==INT_MAX?-1:len;
}
```
