[Count Subarrays With Median K - LeetCode](https://leetcode.com/problems/count-subarrays-with-median-k/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/473f2812-7795-496d-9a72-99314f3d71ee--image.png)

1. All subarrays
2. Subarrays containing k
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b84be569-e78a-499a-ac31-61b056415be9--image.png)
3. K is the median of that subarray 

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/8e29cfce-33c4-4eb4-b838-08d8c40a2546--image.png)
![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/3091426c-2478-4fea-b882-339e8890d98e--image.png)

--------
 ![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/97cd340e-35fb-4056-8e98-0e662ff7253d--image.png)
 
 ![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/ffe743b7-97b6-4467-9f55-a0559f074179--image.png)
 




   


![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/0ac9c638-921c-4892-9a57-f9c6b7bec54b--image.png)

```cpp
int n=v.size();
int idx=-1;
for(int i=0;i<n;i++){
    if(v[i]==k){
        idx=i;
        break;
    }
}
if(idx==-1) return 0;
int diff=0;
unordered_map<int,int> right;
for(int e=idx;e<n;e++){
    if(v[e]>k){
        diff++;
    }
    else if(v[e]<k){
        diff--;
    }
    right[diff]++;
}
diff=0;
int ans=0;
for(int s=idx;s>=0;s--){
    if(v[s]>k){
        diff++;
    }
    else if(v[s]<k){
        diff--;
    }
    ans+=right[1-diff];
    ans+=right[-diff];
// 
return ans;
}
```