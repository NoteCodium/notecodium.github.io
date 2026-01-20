```cpp
priority_queue<int,vecor<int>,greater<int>> pq;
```


Comparator here is reverse of the sort function

1. a structure named cmp
2. oveloaded bracket operator

```cpp
struct cmp{
  bool operator()(int &a, int &b)
  {
    return a>b;
  }
};
```
