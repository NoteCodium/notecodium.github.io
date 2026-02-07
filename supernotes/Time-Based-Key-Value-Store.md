[Time Based Key-Value Store - LeetCode](https://leetcode.com/problems/time-based-key-value-store/description/)

![image.png](../images/87e48d92-339e-4e5d-9069-30b097b474e2--image.png)


```cpp
class TimeMap {
public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        
    }
    
    string get(string key, int timestamp) {
        
    }
};
```

![image.png](../images/6285615c-3445-4bfc-aa50-305560fd0a38--image.png)




```cpp
class TimeMap {
    unordered_map<string,map<int,string>> m;
public:
    TimeMap() {
        
    }
    
    void set(string key, string value, int timeStamp) {
        m[key][timeStamp]=value;
    }
    
    string get(string key, int timeStamp) {
        if(!m.count(key)) return "";
        if(m[key].count(timeStamp)) return m[key][timeStamp];
        auto it=m[key].upper_bound(timeStamp);
        if(it==m[key].begin()){
            return "";
        }
        it--;
        return it->second;
    }
};

```