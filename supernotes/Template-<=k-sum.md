```cpp
int l=0,h=0,sum=0,ans=0;
while(h<n){
    sum+=v[h]; //same as above
    while(sum>k and l<=h){
      //this is not the condition of answer
      sum-=v[l];
      l++;
    }
    if(sum<=k and l<=h) ans+=(h-l+1); 
    h++;  
}
```

