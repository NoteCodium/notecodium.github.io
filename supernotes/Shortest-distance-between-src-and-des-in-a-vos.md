[Shortest Word Distance (easy) ](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63daaa1a0d01fe363b68c8d4)

```cpp
int shortestDistance(vector<string>& vos, string w1, string w2) {
  int idx1=-1,idx2=-1;
  int n=vos.size();
  int minn=n;
  for(int i=0;i<n;i++){
    string s=vos[i];
    if(s==w1) idx1=i;
    if(s==w2) idx2=i;
    //the distane will be minimum when the elements are consecutive
    if(idx1!=-1 and idx2!=-1) minn=min(minn,abs(idx1-idx2));
  }
  return minn;
}
```
