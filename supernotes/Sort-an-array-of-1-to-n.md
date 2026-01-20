[Cyclic Sort (easy)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6393a98bd8a93f4bff961b4d)


# Easier Method?
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/c5f508e1-cd17-4e2f-809c-557e3959f92a--image.png)

```cpp
vector<int> sort(vector<int> &v) {
  int n=v.size();
  for(int i=0;i<n;i++){
    while(v[i]!=i+1){
      int idx=v[i]-1;
      swap(v[i],v[idx]);
    }
  }
  return v;
}
```



# Traditional method
```cpp
vector<int> sort(vector<int> &v) {
  int n=v.size();
  for(int i=0;i<n;i++){
    if(v[i]!=i+1){
      int idx=v[i]-1;
      int val=v[i];
      while(idx!=i){
        int tmp=v[idx];
        v[idx]=val;
        idx=tmp-1;
        val=tmp;
      }
      v[i]=val;  
    }
  }
  return v;
}
```
