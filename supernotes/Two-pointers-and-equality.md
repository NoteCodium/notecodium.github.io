
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/32465f37-2b2e-44cb-9129-a197c6c53460--image.png)


[Valid Pair Sum | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/valid-pair-sum--141631/1)

```cpp
long long ValidPair(int v[], int n) { 
    int k=0;
    sort(v,v+n);
    long long l=0,r=n-1;
    long long cnt=0;
    while (l<=r){
        int sum=v[l]+v[r];
        if (sum > k) {
          //take all the pairs except the present element alone
          cnt+= (r - l);
          r--;    
        } else l++;
    }
    return cnt;
} 
```

[Pairs with Difference less than K | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/pairs-with-difference-less-than-k1348/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/57948bc5-4614-4e72-bafe-dd3e144fc8a8--image.png)

```cpp
int countPairs(int v[], int n, int k){
    sort(v,v+n);
    int l=0,h=1;
    int ans=0;
    while(h<n){
        if(abs(v[h]-v[l])<k){
            ans+=h-l;
            h++;
        }
        else l++;
    }
    return ans;
}
```

