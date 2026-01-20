```
//dp[i][j]=s1[i-1]==s2[j-1]?1+dp[i-1][j-1]:max(dp[i-1][j],dp[i][j-1])
//dp[0][0]=0
//dp[i][0]=0
//dp[0][j]=0
```
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a6cb312a-9c63-4c58-a150-fec2d79b393d--image.png)

```cpp
string ans;
int i=n1,j=n2;
while(i>0 and j>0){
	if(s1[i-1]==s2[j-1]){
		ans.push_back(s1[i-1]);
		i--;
		j--;
	}
	else if(dp[i-1][j]>dp[i][j-1]) i--;
	else j--;
}
reverse(it(ans));
```

