1. input is already sorted
```cpp
if(n==1) return;
int s=1,f=1;
while(f<n){ 
    if(v[f]!=v[s-1]){ 
        v[s]=v[f]; 
        s++; 
    } 
    f++; 
}
```

2. input is not sorted
=> sorting will destroy the order
=> sorting makes sure if elements are repeatimg, they should repeat consecutively 
```cpp
 int s=0,f=0; 
unordered_map<int,int> m; 
while(f<n){ 
    if(!m.count(v[f])){ 
        m[v[f]]; 
        v[s]=v[f];
        s++;
    } 
    f++;
} 
```
[leetcode.com](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
# at most two times
1. sorted input
```cpp
  if(n==1) return 1;
  if(n==2) return 2;

  int s=2,j=2;
  while(f<n){
      if(v[f]!=v[s-2]){
          v[s]=v[f];
          s++;
      }
      f++;
  }
  return s;
```


2. unsorted input
```cpp
  int s=1,f=1;
  unordered_map<int,int> m;  
  m[v[0]]++; 
  while(f<n){  
      if(m.count(v[f])==0 or m[v[f]]==1){  
          v[s]=v[f];  
          s++;  
      }
      m[v[f]]++;  
      f++;  
  }  
  return s;
```


