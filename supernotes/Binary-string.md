1. s[0]=0
2. s[i]=s[i-1] 0 s[i-1]'
3. What is the kth character of the nth string
4. len(nthString) == 2^n -1
5. l=0, h= 2^n -2

```cpp
int bit=0;
while(l<=h){
    int m=(l+h)/2;
    if(m==k) return bit;
    if(m<k){
      l=m+1;
      bit=1-bit;
    }
    else h=m-1;
  }
```
