1. In the beginning all will be parent of itself
2. All nodes will have size of 1

```cpp
class dsu{
pubblic: 
  vector<int> par,size;
  dsu(int n)
  {
      for(int i=0;i<n;i++)
      {
          par.push_back(i);
          size.push_back(1);
      }
  }
};
```