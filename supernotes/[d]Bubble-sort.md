1. Taking the big elements to the end
2. sorted flag
```cpp
bool sorted=0;
while(!sorted){
  int i=0;
  //assume the array is sorted now
  sorted=1;
  while(i<=n-2){
    if(v[i]>v[i+1]){
      swap(v[i],v[i+1]);
      sorted=0;
      //our assumption was wrong
    }
    i++;
  }
}
```