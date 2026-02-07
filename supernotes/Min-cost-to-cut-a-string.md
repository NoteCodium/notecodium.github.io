[leetcode.com](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/)
1. The cost of one cut is the length of the stick to be cut
![image.png](../images/ecce4e6e-ee3f-4356-a7dc-d735585ff803--image.png)

```cpp
sort(v.begin(),v.end());
v.insert(v.begin(),0);
v.push_back(len);
```
![image.png](../images/0471063a-5dfb-4ea4-a84a-288cfc1431a6--image.png)

![image.png](../images/88a90f61-7a24-48ee-b575-66587eaea6e1--image.png)

```cpp
int f(int i, int j, vector<int> &v){
  if(i>j) return 0;
  int minn=INT_MAX;
  for(int k=i;k<=j;k++){
      int cost=v[j+1]-v[i-1]+ f(i,k-1,v)+ f(k+1,j,v);
      minn= min(minn,cost); 
  }
  return minn;
    }
```

```cpp

int minCost(int len, vector<int>& v) {
    int n=v.size();
    sort(v.begin(),v.end());
    v.insert(v.begin(),0);
    v.push_back(len);
    //len become n+2
    //indices are between 0 to n+1
    return f(1,n,v);
}
```


