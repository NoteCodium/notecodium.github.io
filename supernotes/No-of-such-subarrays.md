[Continuous Subarrays - LeetCode](https://leetcode.com/problems/continuous-subarrays/)

```cpp
void insertMinD(deque<int> &d, int idx, vector<int>& v){
    while(!d.empty() and v[d.back()]>=v[idx]) d.pop_back();
    d.push_back(idx);
}

void insertMaxD(deque<int> &d, int idx, vector<int>& v){
    while(!d.empty() and v[d.back()]<=v[idx]) d.pop_back();
    d.push_back(idx);        
}

void longestSubarray(vector<int>& v, long long &ans) {
    int k=2;
    deque<int> minD,maxD;
    int l=0,h=0,n=v.size();
    while(h<n) 
    {
        insertMinD(minD,h,v);
        insertMaxD(maxD,h,v);
        int minn=minD.front(),maxx=maxD.front();
        if(abs(v[maxx]-v[minn])<=k)
        {
            ans+=(h-l+1);
            h++;
        }   
        else
        {
            l++;
            if(l>minD.front()) minD.pop_front();
            if(l>maxD.front()) maxD.pop_front();                
        }

    }    
}


long long continuousSubarrays(vector<int>& nums) {
    long long ans=0;
    longestSubarray(nums,ans);  
    return ans;     
}
```