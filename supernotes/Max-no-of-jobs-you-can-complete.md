1. cant be greedy based on start time, as someone with very low start  time can have a very high start time 
2. can be greedy based on end time

find oa link

```cpp

int maxJobComplete(){
  int n=ma.size();
  sort(ma.begin(),ma.end(),cmp);
  int ans=1;
  int et=ma[0][1];
  for(int i=1;i<n;i++){
      if(ma[i][0]>=et){
        ans++;
        et=ma[i][1];
      }
    }
}

static bool cmp(vector<int> &a, vector<int> &b)
{
  return a[1]<b[1];
}
```

