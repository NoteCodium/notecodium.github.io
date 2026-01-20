[Insert Interval - LeetCode](https://leetcode.com/problems/insert-interval/description/)


# With bs
```cpp
void insertInterval(vector<vector<int>>& intervals, vector<int>& ni){
    vector<int> tmp={ni[0],INT_MIN};
    intervals.insert(upper_bound(intervals.begin(),intervals.end(),tmp),ni);
}

vector<vector<int>> merge(vector<vector<int>>& intervals) {
    if(intervals.size()==0) return {};
    sort(intervals.begin(),intervals.end());
    vector<vector<int>> merged;
    for(auto interval:intervals){
        if(merged.empty() or merged.back()[1]<interval[0])
            merged.push_back(interval);
        else merged.back()[1]=max(merged.back()[1],interval[1]);
    }
    return merged;
}


vector<vector<int>> insert(vector<vector<int>>& ma, vector<int>& ni) {
    insertInterval(ma,ni);
    return merge(ma);
}
```


```cpp
    void insertInterval(vector<vector<int>>& intervals, vector<int>& ni){
        bool flag=0;
        int n=intervals.size();
        for(int i=0;i<n;i++){
            if(ni[0]<intervals[i][0]){
                intervals.insert(intervals.begin()+i,ni);
                flag=1;
                break;
            }
        }
        if(!flag) intervals.push_back(ni);
    }

    vector<vector<int>> merge(vector<vector<int>>& intervals) {
       if(intervals.size()==0) return {};
       vector<vector<int>> merged;
        for(auto interval:intervals){
            if(merged.empty() or merged.back()[1]<interval[0])
                merged.push_back(interval);
            else merged.back()[1]=max(merged.back()[1],interval[1]);
        }
       return merged;
    }


    vector<vector<int>> insert(vector<vector<int>>& ma, vector<int>& ni) {
        insertInterval(ma,ni);
        return merge(ma);
    }
```
