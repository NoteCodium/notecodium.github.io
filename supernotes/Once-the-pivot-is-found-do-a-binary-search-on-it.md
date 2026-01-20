[Problem Challenge 1: Search Bitonic Array (medium)](https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639f98b9d239f7cde26ddcaf)

```cpp
int bs(const vector<int> &v, int ll, int hh, int k){
  int ans=-1;
  int l=ll,h=hh;
  while(l<=h){
    int m=(l+h)/2;
    if(v[l]<v[h]){
      if(v[m]==k) return m;
      else if(v[m]<k) l=m+1;
      else h=m-1;
    }
    else{
      if(v[m]==k) return m;
      else if(v[m]>k) l=m+1;
      else h=m-1;
    }
  }
  return ans;
}


int search(const vector<int> &v, int k) {
  int n=v.size();
  int pivot=-1;
  int l=0,h=n-1;
  while(l<=h){
      int m=(l+h)/2;
      if(m==0 or v[m-1]<v[m]){
          pivot=m;
          l=m+1;
      }
      else if(m==n-1 or v[m]>v[m+1]) h=m-1;
  }
  int ans=bs(v,0,pivot,k);
  if(ans!=-1) return ans;
  ans=bs(v,pivot+1,n-1,k);
  return ans!=-1?ans:-1;
}
```