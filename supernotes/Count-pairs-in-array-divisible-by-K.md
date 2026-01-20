[Count pairs in array divisible by K | Practice | GeeksforGeeks ](https://www.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a56d39a5-287d-42e5-a27d-62551be87a72--image.png)


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/7acee796-ba66-4216-89b3-19033a9ff517--image.png)


# Making buckets
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/017079e8-1c5c-4931-8059-2301d0c8d457--image.png)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3cb2552f-1719-467a-abc7-70612642d6d5--image.png)

# There will be 2 special buckets
1) Having sum of remainders as zero === both r1 and r2 as zero
2) When k is even, 1   2   3 4  5  6 7    8  9
3. the k//2 bucket 




nc2






![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ffad9f09-0855-4a2d-9a34-03bd91697fa9--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/de314625-6aa7-4b70-93be-0421ef02a13b--image.png)


```cpp
long long countKdivPairs(int v[], int n, int k){
    vector<long long> cnt(k,0);
    long long ans=0;
    for(int i=0;i<n;i++) cnt[v[i]%k]++;
    ans+=(cnt[0]*(cnt[0]-1))/2;
    for(int i=1;i<=k/2 and i != k - i;i++) ans+=cnt[i]*cnt[k-i];
    if(k%2==0) ans+=(cnt[k/2]*(cnt[k/2]-1))/2;
    return ans;
}
```