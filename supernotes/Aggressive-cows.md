1. you have to arrange the cows in such a way on the number line such that minimum distance is as high as possible
2. minimum distance will exist between consecutive cows
3. you place the cow at some distance m and check whether you were successful in placing the cows or not, that will be your predicate function of bs
4. You are given a vector of possible places

```cpp
sort(it(v));
int l=1,h=INT_MAX,ans=-1;
while(l<=h){
    int m=(l+h)/2;
    if(f(m)){
      ans=m;
      l=m+1;
      //increase m
    }
    else h=m-1;
    //decrease m
  }
```

```cpp
bool f(int m){
  int cnt=1;
  int prev=v[0];
  for(int i=1;i<v.size();i++){
    if(v[i]-prev>=m){
      cnt++;
      prev=v[i];
    }
  }
  return cnt>=c;
}
```

