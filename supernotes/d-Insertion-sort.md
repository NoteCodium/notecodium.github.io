1. Inserting the new elements at its deserving position in a sorted array
2. Merge between a sorted array and a single element
3. Its optimized version is merge sort

```cpp
int i=1;
while(i<n){
  int j=i;
  while(j>0 and v[j-1]>v[j]){
    swap(v[j-1],v[j]);
    j--;
  }
  i++;
}
```
# No. of swaps: ic of the array

