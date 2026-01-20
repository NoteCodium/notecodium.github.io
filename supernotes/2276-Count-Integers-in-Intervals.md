[Just a moment...](https://leetcode.com/problems/count-integers-in-intervals/description/?envType=list&envId=ppzcw7vd)





# TLE
```cpp
class CountIntervals {
    vector<vector<int>> intervals;
    int ans;

    void insertInterval(vector<int>& ni){
        vector<int> tmp={ni[0],INT_MIN};
        intervals.insert(upper_bound(intervals.begin(),intervals.end(),tmp),ni);
    }

        void merge() {
            ans=0;
            vector<vector<int>> merged;
            for(auto interval:intervals){
                if(merged.empty() or merged.back()[1]<interval[0]){
                    merged.push_back(interval);
                    ans+=interval[1]-interval[0]+1;
                }    
                else{
                ans -= merged.back()[1];
                merged.back()[1] = max(merged.back()[1], interval[1]);
                ans += merged.back()[1];
                } 
            }
            intervals=merged;
    }

public:
    CountIntervals() {
        ans=0;        
    }
    
    void add(int l, int r) {
        vector<int> tmp={l,r};
        insertInterval(tmp);
        merge();        
    }
    
    int count() {
        return ans;
    }
};

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals* obj = new CountIntervals();
 * obj->add(left,right);
 * int param_2 = obj->count();
 */
```