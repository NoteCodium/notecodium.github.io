# two pointers+ monotonic queue


[Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit - LeetCode](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)

[Leetcode - Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit - YouTube](https://www.youtube.com/watch?v=LDFZm4iB7tA)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/e5cf3a54-fe3b-4798-ac3a-9ae016bf55cc--image.png)

# Proving it is doable with two pointers
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/800c0d34-9fbf-4cb8-af15-e8089d32aa1c--image.png)

changing h will just increase the number of new elements which can further increase the difference, you have to increase l to decrease the difference



```cpp
void insertMinD(deque<int> &d, int idx, vector<int>& v){
        while(!d.empty() and v[d.back()]>=v[idx]) d.pop_back();
        d.push_back(idx);
    }

    void insertMaxD(deque<int> &d, int idx, vector<int>& v){
        while(!d.empty() and v[d.back()]<=v[idx]) d.pop_back();
        d.push_back(idx);        
    }

    int longestSubarray(vector<int>& v, int k) {
        //longest subarray
        //abs of any two elements<=k
        int ans=0;
        deque<int> minD,maxD;
        int l=0,h=0,n=v.size();
        while(h<n){
            insertMinD(minD,h,v);
            insertMaxD(maxD,h,v);
            int minn=minD.front(),maxx=maxD.front();
            if(abs(v[maxx]-v[minn])<=k){
                ans=max(ans,h-l+1);
                h++;
            }   
            else{
                l++;
                if(l>minD.front()) minD.pop_front();
                if(l>maxD.front()) maxD.pop_front();                
            }
        }    
        return ans;
    }

```
