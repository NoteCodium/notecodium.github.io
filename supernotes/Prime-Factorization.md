# Brute force O(n)
```cpp
for(int i=2;i<=n;i++){
	while(n%i==0){
		cout<<i<<" ";
		n=n/i;
	}
} 
```
# Optimized 
1. Prime factorization can’t contain two primes which are both greater than sqrt(n) because their product will exceed n.
2. There is only one prime factor of a number which lies outside of sqrt(n)
```cpp
for(int i=2;i*i<=n;i++){
	while(n%i==0){
		cout<<i<<" ";
		n=n/i;
	}
}
if(n!=1) cout<<n;
```

# Do preprocessing in nloglogn after which find prime factorisation of any number in logn

```cpp
#define maxx 1000000

vector<int> primes(maxx+1,1),spf(maxx+1);  
primes[0]=primes[1]=0;   
spf[0]=spf[1]=-1;  
for(long long i=2;i<=maxx;i++){   
    if(primes[i]){  
        spf[i]=i;  
        for(int j=i;i*j<=maxx;j++){   
            if(primes[i*j]){  
                    primes[i*j]=0;   
                    spf[i*j]=i;  
                }  
        }         
    }  
}
```


## Using the above
```cpp
while(spf[n]!=-1){
	cout<<spf[n];
	n=n/spf[n];
}
```

# Doing the prime factorisation
q sqrt(n)

vs

q log(n)  + nloglogn


# qsqrt(n)  vs nloglogn
