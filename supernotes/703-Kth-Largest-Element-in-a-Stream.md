[Kth Largest Element in a Stream - LeetCode](https://leetcode.com/problems/kth-largest-element-in-a-stream/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2c372a8c-554d-46b2-b137-08e0f891cd10--image.png)

```cpp
class KthLargest {
    priority_queue<int,vector<int>,greater<int>> pq;
    int k;

public:
    KthLargest(int k, vector<int>& nums) {
        this->k=k;
        for(int x: nums) pq.push(x);
        while(pq.size()>k){
            pq.pop();
        }
    }
    
    int add(int val) {
        pq.push(val);
        if(pq.size()>k) pq.pop();
        return pq.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
```
