In thes type of questions l and h always starts from 0

# All elements are positive
1. No. of subarrays whose sum is >=k

1. agar ek chota array at l and h hain to all the elements from h going to present till n will be part of answer (these all will be forming big sub arrays) 



2. ans+=(n-h);
[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/D)

## Bade wale me  while ke andar answer


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
# smallest subarray with sum>=k

[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/B)
```cpp
int l=0,h=0,sum=0,ans=INT_MAX;
while(h<n){
    sum+=v[h];
    while(sum>=k and l<=r){ 
      //condition for answer
        ans=min(ans,r-l+1);
        sum-=v[l];
        l++;
    }
    h++;  
}  
```


# no. of subarrays whose sum is <=k
agar ek bari cheez ki hain to usse chote wale subarrays ko to hogi heen 

[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/C)

```cpp
int l=0,h=0,sum=0,ans=0;
while(h<n){
    sum+=v[h]; //same as above
    while(sum>k and l<r){
      //this is not the condition of answer
      sum-=v[l];
      l++;
    }
    if(sum<=k) ans+=(h-l+1);  //with that particular h we have these many answers
    h++;  
}
```

# largest subarray with sum<=k
[codeforces.com](https://codeforces.com/edu/course/2/lesson/9/2/practice/contest/307093/problem/A)



```cpp
int l=0,h=0,sum=0,ans=0;
while(h<n){
    sum+=v[r]; //same as above
    while(sum>k and l<r){
      //this is not the condition of answer
      sum-=v[l];
      l++;
    }
    if(sum<=k and l<=h) ans=max(ans,h-l+1); 
    h++;  
}
```


--------------------------------------------------------------------------------------------
