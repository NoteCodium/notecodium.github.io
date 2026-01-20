`1. n^k= n^(k/2) * n^(k/2) if k is even`
`2.  n^k=(n^(k/2) * n^(k/2)	) * n  if k is odd`

```cpp
int f(n,k){
	if(k==0) return 1;
	int x=f(n,k/2);
	if(k%2==0) return x*x;
	return x*x*n;
}
```

![WhatsApp%20Image%202023-11-19%20at%2012.16.16_942b94c9.jpg](https://supernotes-resources.s3.amazonaws.com/image-uploads/a5e5cceb-7f54-4020-9ee0-2a142232e5c5--WhatsApp%2520Image%25202023-11-19%2520at%252012.16.16_942b94c9.jpg)

