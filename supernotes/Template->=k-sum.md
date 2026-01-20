```cpp
int l=0,h=0,sum=0,ans=0;
while(h<n){
    sum+=v[h];
    while(sum>=k and l<=r){ 
      //condition for answer
        ans+=n-h;
        sum-=v[l];
        l++;
    }
    h++;  
}  
```

