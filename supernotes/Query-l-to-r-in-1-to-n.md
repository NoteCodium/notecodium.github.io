# ^
# 1 to n
n%4
0  = n 
1   = 1
2  = n+1
3  = 0


# &
yashesh
![WhatsApp%20Image%202023-10-01%20at%2016.58.27_14e03408.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/3181f77c-fd0f-4d32-a148-d83fc02f2733--WhatsApp%2520Image%25202023-10-01%2520at%252016.58.27_14e03408.jpg)

```cpp
ll mask=1ll<<31;
ll ans=0;
while(mask){
  if((mask&l)==(mask&r)) ans+=mask;
  else break;
  mask>>=1;
}
```

