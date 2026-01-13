1. in an array, if i<j and v[i]>v[j]
2. https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

![image.png](/images/image-86.png)

```cpp
void merge(long long int v[], int l, int m, int r, long long int &cnt){
     int p1=l,p2=m+1;
     vector<long long int> temp;
     while(p1<=m and p2<=r){
         if(v[p1]<=v[p2]) temp.push_back(v[p1++]);
         else{
            temp.push_back(v[p2++]);
            cnt+=(m-p1+1); 
         } 
     }
     while(p1<=m) temp.push_back(v[p1++]);
     while(p2<=r) temp.push_back(v[p2++]);
     for(int i=l;i<=r;i++){
         v[i]=temp[i-l];
     }
}


void mergeSort(long long int v[], int l, int r, long long int &cnt){
    if(l==r) return;
    int m=(l+r)/2;
    mergeSort(v,l,m,cnt);
    mergeSort(v,m+1,r,cnt);
    merge(v,l,m,r,cnt);
}
    
    
 long long int inversionCount(long long v[], long long n){
    long long int cnt=0;
    mergeSort(v,0,n-1,cnt);
    return cnt;
}
```

https://leetcode.com/problems/reverse-pairs/description/

0 <= i < j < nums.length and

nums[i] > 2 * nums[j]

```cpp
void merge(vector<int> &v, int l, int m, int r, int &cnt){
	    int p1=l,p2=m+1;
	    while(p2<=r){
	        while(p1<=m and v[p1]*0.5<=v[p2]*1.0) p1++;
	        ans+=(m-p1+1);
	        p2++;
	    }

     p1=l,p2=m+1;
     vector<int> temp;
     while(p1<=m and p2<=r){
        	if(v[p1]<=v[p2]) tmp.push_back(v[p1++]);
        	else tmp.push_back(v[p2++]);


     }
     while(p1<=m) temp.push_back(v[p1++]);
     while(p2<=r) temp.push_back(v[p2++]);
     for(int i=l;i<=r;i++){
         v[i]=temp[i-l];
     }
}


void mergeSort(vector<int> &v, int l, int r, long long int &cnt){
    if(l==r) return;
    int m=(l+r)/2;
    mergeSort(v,l,m,cnt);
    mergeSort(v,m+1,r,cnt);
    merge(v,l,m,r,cnt);
}
    
    
 int reversePairs(vector<int> &v){
    int cnt=0,n=v.size();
    mergeSort(v,0,n-1,cnt);
    return cnt;
}
```