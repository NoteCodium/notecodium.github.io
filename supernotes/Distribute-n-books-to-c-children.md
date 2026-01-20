1. The allocation will be continuous
2. Each child need to receive at least one book
3. Maximum page received by a child need to be minimized
4. (itna kam mat dene lag jao ki books heen na bache)


```cpp
int Solution::books(vector<int>& v, int c) {  
        int l=*max_element(it(v)),h=accumulate(it(v),0),ans=-1;  
        int n=v.size();
        if(c>n) return -1;
        while(l<=h){  
            int m=l+(h-l)/2;  
            if(f(m,c,v)) ans=m,h=m-1;  
            else l=m+1;  
        }  
        return ans;  
    }
```

```cpp
bool f(m){
  int cnt=0;
  int sum=0;
  for(int i=0;i<books.size();i++){
    if(books[i]>m) return 0;
    if(sum+v[i]<=m) sum+=v[i];
    else{
      sum=v[i];
      cnt++;
    }
  }
  return cnt<=c;
}
```
