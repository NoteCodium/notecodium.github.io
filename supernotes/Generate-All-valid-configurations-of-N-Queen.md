
```cpp
void f(r){
	if(r==n){
		ans.pb(ma);
		return;
	}
	for(int c=0;c<n;c++){
		if(!isSafe(r,c,ma)) continue;
		ma[r][c]='Q';
		f(r+1);
		ma[r][c]='.';
	}

}
```

```cpp
bool isSafe(r,c,ma){
	int x=r-1,y=c-1;
	while(x>=0 and y>=0){
		if(ma[x][y]=='Q') return 0;
		x--;
		y--;
	}
	x=r-1,y=c+1;
	while(x>=0 and y<n){
		if(ma[x][y]=='Q') return 0;
		x--;
		y++;
	}
	x=r-1;
	while(x>=0){
		if(ma[x][y]=='Q') return 0;
		x--;
	}
    return 1;
}
```
