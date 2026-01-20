```cpp
is_sorted(it(v));
```


```cpp
push_front() in vectors, not in string
```
```cpp
insert(v.begin()+idx,element);
```

To insert at the deserving idx in an sorted array

```cpp
v.insert(lower_bound(v.begin(), v.end(), num), num);
```