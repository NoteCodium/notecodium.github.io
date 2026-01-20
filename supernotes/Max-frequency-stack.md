[Maximum Frequency Stack - LeetCode](https://leetcode.com/problems/maximum-frequency-stack/description/)


```cpp
class FreqStack {
private:
    priority_queue<vector<int>> pq;
    unordered_map<int,int> freq;
    int idx;
public:
    FreqStack() {
        idx=-1;
    }
    void push(int val) {
        pq.push({++freq[val],++idx,val});
    }
    
    int pop() {
        auto v=pq.top();pq.pop();
        int x=v[2];
        freq[x]--;
        return x;
    }
};
```
