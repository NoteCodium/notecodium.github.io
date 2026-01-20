![WhatsApp%20Image%202023-10-01%20at%2019.24.10_714bd637.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/11e17a0e-92dd-49ac-a192-8fb68d1cf345--WhatsApp%2520Image%25202023-10-01%2520at%252019.24.10_714bd637.jpg)

[Decimal to binary | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/decimal-to-binary-1587115620/1)

```cpp
string ans;
while(n){
  s.push(n%2);
  n=/2;
}
reverse(it(s));
return s;
```
```cpp
int bin[32];
int i=0;
while(n){
    bin[i]=n%2;
    n/=2;
    i++;
}
for(int j=i-1;j>=0;j--) printf("%d", bin[j]);
```