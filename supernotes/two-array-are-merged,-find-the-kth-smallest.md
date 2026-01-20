[K-th element of two  Arrays | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1)

```cpp
int f(int v1[], int v2[], int n1, int n2, int m){
    int count=0;
    count+=(upper_bound(v1,v1+n1,m))-v1;
    count+=(upper_bound(v2,v2+n2,m))-v2;        
    return count;         
}
```

```cpp
int kthElement(int v1[], int v2[], int n1, int n2, int k){
    int l=min(v1[0],v2[0]),h=max(v1[n1-1],v2[n2-1]),ans=-1;
    while(l<=h){
        int m=l+ (h-l)/2;
        if(f(v1,v2,n1,n2,m)>=k){
            ans=m;
            h=m-1;
        }
        else l=m+1;
    }
    return ans;
}
```
