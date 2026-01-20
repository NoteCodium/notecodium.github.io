

# Three sum
```
return all the unique triplets such that 
a+b+c==k
```
```cpp
for(int i=0;i<n;i++){
  if(i>0 and v[i]==v[i-1]) continue;
  //continuing if the a is same as last a
  int rem=k-v[i];
  int l=i+1,h=n-1;
  while(l<h){
      int sum=v[l]+v[h];
      if(sum==rem){
        ans.pb({v[i],v[l],v[h]});
        int p=v[l],q=v[h];
        if(p==q) break;
        while(l<n and v[l]==p) l++;
        while(h>=0 and v[h]==q) h--;
      }
      else if(sum<rem) l++;
      else h--;
    }
}
```



# Four some

```cpp
for(int i=0;i<n;i++){
    if(i>0 and v[i]==v[i-1]) continue;
    for(int j=i+1;j<n;j++){
        if(j>i+1 and v[j]==v[j-1]) continue;
            ll rem=(ll)k-(v[i]+v[j]);
            int l=j+1,h=n-1; 
            while(l<h){
                ll sum=v[l]+v[h];
                if(sum==rem){
                    ans.push_back({v[i],v[j],v[l],v[h]});
                    int p=v[l],q=v[h];
                    if(p==q) break;
                    while(l<n and v[l]==p) l++;
                    while(h>=0 and v[h]==q) h--;
                }
                else if(sum<rem) l++;
                else h--;
            }
    }
}
```