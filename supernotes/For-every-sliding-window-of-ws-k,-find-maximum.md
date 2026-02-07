[leetcode.com](https://leetcode.com/problems/sliding-window-maximum/)
1. General knowledge
![image.png](../images/19d2769b-ad63-49eb-ba55-d2d2a18d79c8--image.png)

# Sliding window with the help of decreasing multiset
```cpp
  vector<int> maxSlidingWindow(vector<int>& v, int k) {
      int n=v.size();
      multiset<int,greater<int>> se;
      vector<int> ans;
      for(int i=0;i<=k-2;i++) se.insert(v[i]);
      for(int i=k-1;i<n;i++){
          se.insert(v[i]);
          ans.push_back(*se.begin());
          se.erase(se.find(v[i-k+1]));
      }
      return ans;
  }
```

# Monotonic Queue
# The above was monotonic deceasing Queue, which give maxima, montonic increasing queue will give minima at front
![image.png](../images/d6e2e5fd-0e87-41f4-9e6a-3935b68578ab--image.png)

![image.png](../images/ff39447c-2f9e-4c88-99fa-79ddf6cb4c89--image.png)

![image.png](../images/6bb4c32c-03bb-418c-ab82-fa6fa8f09cec--image.png)

![image.png](../images/7bd1c4e6-8067-4ab9-8e09-b9581e396994--image.png)



```cpp
//insertBack only insert the usefull elements
void insertBack(deque<int> &d, int idx,  vector<int>& v){
    while(!d.empty() and v[idx]>=v[d.back()]) d.pop_back();
    d.push_back(idx);
}
```

```cpp
vector<int> maxSlidingWindow(vector<int>& v, int k) {
    vector<int> ans;
    deque<int> d;
    int n=v.size();
    for(int i=0;i<=k-2;i++) insertBack(d,i,v);
    for(int i=k-1;i<n;i++){
        insertBack(d,i,v);
        ans.push_back(v[d.front()]);
        if(d.front()==i-k+1) d.pop_front();
    }
    return ans;
}
```

