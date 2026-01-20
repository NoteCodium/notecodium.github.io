[leetcode.com](https://leetcode.com/problems/matchsticks-to-square/description/)

```cpp
if(n<4 or sum%4) return 0;
int sum=accumulate(it(v),0);
int a,b,c,d;
a=b=c=d=sum/4;
sort(it(v),greater<int>());
return f(v,0);
```
```cpp
bool f(idx){
	if(idx==n) return !a and !b and !c and !d;
	if(v[idx]<=a){
		a-=v[idx];
		if(f(idx+1)) return 1;
		a+=v[idx];
	}
	if(v[idx]<=b){
		b-=v[idx];
		if(f(v,idx+1)) return 1;
		b+=v[idx];
	}
	if(v[idx]<=c){
		c-=v[idx];
		if(f(v,idx+1)) return 1;
		c+=v[idx];
	}
	if(v[idx]<=d){
		d-=v[idx];
		if(f(v,idx+1)) return 1;
		d+=v[idx];
	}

	return 0;
}
```

# 4^n

[Divide array into k equal subsets](https://my.supernotes.app/?preview=16577d31-a02a-42db-8fe3-6335697d0292)
