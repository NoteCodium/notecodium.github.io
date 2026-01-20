```cpp
sort(ma.begin(),ma.end(),greater<vector<int>>);
```
dont work

- **greater<vector<int>>:** The `greater` functor provides a "greater-than" comparison, but it's intended for comparing individual elements of a basic type (like `int`, `double`, etc.), not entire vectors.