[Count pairs with given sum | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1)


# Sum
```cpp
int l=0,h=n-1;
while(l<h){
  
}

//User function template for C++

class Solution{   
public:
    int getPairsCount(int v[], int n, int k) {
    	sort(v,v+n);
    	int l=0,h=n-1;
    	int ans=0;
    	while(l<h){
    	    int sum=v[l]+v[h];
    	    if(sum==k){
    	        int p=v[l];
    	        int q=v[h];
	            if(p==q){
	                int tmp=h-l+1;
	                ans+=(long long)((tmp*(tmp-1))/2);
	                break;
	            }
	            else{
	                int cnt1=0,cnt2=0;
	                while(l<n and p==v[l]) cnt1++,l++;
	                while(h>0 and q==v[h]) cnt2++,h--;
	                ans+=(cnt1*cnt2);
	            }
    	    }
    	    else if(sum>k) h--;
    	    else l++;
    	}
    	return ans;
    }
};
```
------------------------------------------------------------------------------------------
  This is nlogn, we have a O(n) solution with memoru, works with number of pairs having given xor also

```cpp
unordered_map<int,int> m;
long long ans=0;
for(int x: v){
    ans+=m[k-x];
    m[x]++;
}
return ans;
```
# Number of unique pairs with given xor==k 
[www.interviewbit.com](https://www.interviewbit.com/problems/pairs-with-given-xor/)
```cpp
for(int x: v){
  if(se.count(x^k)) ans++;
  else se[x]++;
}
```


[Find Pair Given Difference | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1)

 [Count distinct pairs with difference k | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)     

```cpp
if(n==1) return 0;
sort(v,v+n);
int l=0,h=1;
while(h<n){
    int diff=v[h]-v[l];
    if(diff==k) return 1;
    else if(diff<k) h++;
    else l++;
    if(l==h) h++;
}
return 0;
```


```cpp
int l=0,h=0;
int ans=0;

while(h<n){
  int diff=v[h]-v[l];
  if(diff==k){
    if(v[l]==v[h]){
      int len=h-l+1;
      ans+=(len*(len-1)//2);
    }
    int q=v[l],w=v[h];
    int cnt1=0,cnt2=0;
    while(l<n and v[l]==q){
        cnt1++;
        l++;
      }
    while(h>=0 and v[h]==w){
        cnt2++;
        h--;
      }
    ans+=(cnt1*cnt2);
  } 
  if(l==h) h++;
}
```

```cpp
sort(v.begin(),v.end());
int n=v.size();
int l=0,h=1;
int ans=0;

while(h<n){
  int diff=v[h]-v[l];
  if(diff==k){
        ans++;
        if(v[l]==v[h]){
            break;
        }
        int q=v[l],w=v[h];
        while(l<n and v[l]==q){
            l++;
          }
        while(h>=0 and v[h]==w){
            h--;
          }
    } 
  else if(diff<k){
      h++;
  } 
  else{
    l++;  
  } 
  if(l==h){
      h++;
  }
}
```