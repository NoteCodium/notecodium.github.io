```
//dp[i][j]= s[i]==s[j]?2+dp[i+1][j-1]:max(dp[i+1][j],dp[i][j-1]);
```
```cpp
vvl dp(n,vl(n,0));
for(int i=0;i<n;i++) dp[i][i]=1;
for(int d=1;d<n;d++){
	int r=0,c=d;
	while(r<n and c<n){
		r++;
		c++;
	}
}
```
