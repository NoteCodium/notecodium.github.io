Min. no of intervals to remove such that resulting all are non intersecting


https://leetcode.com/problems/non-overlapping-intervals/description/


```python
class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& ma) {
        int n=ma.size();
        sort(ma.begin(),ma.end());
        int i=0,ans=0;
        while(i<=n-2){
            if(ma[i][1]>ma[i+1][0]){
            //intersection happen
                ans++;
                ma[i+1][1]=min(ma[i][1],ma[i+1][1]);
            }
            i++;
        }
        return ans;
    }
};
```

![image.png](4TwoPointersIntervals_images/image.png)


https://leetcode.com/problems/interval-list-intersections/description/


```python
bool f(vector<int> &v1, vector<int> &v2){
    return min(v1[1],v2[1])>=max(v1[0],v2[0]);
}

vector<vector<int>> intervalIntersection(vector<vector<int>>& v1, vector<vector<int>>& v2) {
    vector<vector<int>> ans;
    int n1=v1.size(),n2=v2.size();
    int i=0,j=0;
    while(i<n1 and j<n2){
        if(f(v1[i],v2[j])) ans.push_back({max(v1[i][0],v2[j][0]),min(v1[i][1],v2[j][1])});
        if(v1[i][1]<v2[j][1]) i++;
        else j++;
    }
    return ans;
    
}
```

https://leetcode.com/problems/remove-covered-intervals/description/


![image.png](4TwoPointersIntervals_images/image.png)


https://youtu.be/nhAsMabiVkM?si=Bw7cxv7xj5PsDiLr     
https://youtu.be/FUvMJ71eIWc?si=ExaXl9T-L_zjQiP_


```python
class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& ma) {
        sort(ma.begin(),ma.end(),[](auto &a, auto &b){
            return a[0]!=b[0]?a[0]<b[0]:a[1]>b[1];
        });
        //this part is explained by neetcode best

        //this part is explained by ayushi sharma best
        int n=ma.size();
        int ans=n;  
        int r=-1;
        
        for(int i=0;i<n;i++){
            if(r>=ma[i][1]){
                ans--;
            }
            r=max(r,ma[i][1]);
        }

        return ans;
    }
};
```
