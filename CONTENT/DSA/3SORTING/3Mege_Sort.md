![image.png](/images/image-85.png)

https://www.geeksforgeeks.org/problems/merge-sort/1

```
void mergeSort(int v[], int l, int r){
    if(l==r) return;
    int m=(l+r)/2;
    mergeSort(v,l,m);
    mergeSort(v,m+1,r);
    merge(v,l,m,r);
}
```

1. Merging two sorted arrays using extra space, a problem exist where your goal is to merge two sorted arrays in constant space

```cpp
void merge(int v[], int l, int m, int r){
    int p1=l,p2=m+1;
    vector<int> tmp;
    while(p1<=m and p2<=r){
        if(v[p1]<=v[p2]) tmp.push_back(v[p1++]);
        else tmp.push_back(v[p2++]);
    }
    while(p1<=m) tmp.push_back(v[p1++]);
    while(p2<=r) tmp.push_back(v[p2++]);
    for(int i=l;i<=r;i++){
        v[i]=tmp[i-l];
    }
}
```





# MAANG

    1. Merging two sorted arrays using extra space, a problem exist where your goal is to merge two sorted arrays in constant space

https://leetcode.com/problems/count-of-range-sum/solutions/3680067/c-merge-sort-segment-tree-bit/