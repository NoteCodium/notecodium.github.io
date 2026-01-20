odd n//2    7//2 3                 0 1 2 3 4 5 6
even  8//2 4                  0 1 2 3 4 5 6 7   n//2-1 and n//2



[leetcode.com](https://leetcode.com/problems/median-of-two-sorted-arrays/description/)

#nlogn without actually creating the large array, in constant space

```cpp
int f(vector<int>& v1, vector<int>& v2, int n1, int n2, int m){
    int count=0;
    count+=(upper_bound(v1.begin(),v1.end(),m))-v1.begin();
    count+=(upper_bound(v2.begin(),v2.end(),m))-v2.begin();        
    return count;         
}


int kth(vector<int>& v1, vector<int>& v2, int n1, int n2, int k){
    if(!n1) return v2[k-1];
    if(!n2) return v1[k-1];        
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


double findMedianSortedArrays(vector<int>& v1, vector<int>& v2) {
    int n1=v1.size(), n2=v2.size();
    int k=(n1+n2)/2;
    if((n1+n2)%2==0){
        return (kth(v1,v2,n1,n2,(k+1))+kth(v1,v2,n1,n2,(k-1+1)))*0.5;
    }
    else{
        return kth(v1,v2,n1,n2,(k+1));
    }
}
```



# Linear solution by striver interview 

Neetcode
[Median of Two Sorted Arrays - Binary Search - Leetcode 4 - YouTube](https://www.youtube.com/watch?v=q6IEA26hvXc)