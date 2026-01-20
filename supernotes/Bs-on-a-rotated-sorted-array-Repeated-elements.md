- [https://leetcode.com/problems/search-in-rotated-sorted-array-ii/](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)
- 10 11 14 22 3 8
- rotated sorted array 1
- left half > v[n-1]
- right half <=v[n-1]
- Whats the problem in this in rotates sorted array 2
- 2,5,6,0,0,1,2
- the 2 at the front will say to move left

```cpp
    int searchHelper(vector<int>& v, int k, int ll, int hh) {   
        int l=ll,h=hh;
        int leastEL=v[h]; 
        int ans=ll-1;

        while(l<=h){
            int m=(l+h)/2;
            if(v[m]>leastEL) ans=m,l=m+1;
            else h=m-1;
        }

        if(k>leastEL) return binary_search(v.begin()+ll,v.begin()+ans+1,k);
        return binary_search(v.begin()+ans+1,v.begin()+hh+1,k);
    }



    bool search(vector<int>& v, int k) {
        int n=v.size();
        if(n==1) return v[0]==k;
        int l=0,h=n-1;
        int leastEL=v[n-1];
        if(k==leastEL) return 1;
        while(l<=h and (leastEL==v[l])) l++;
        return searchHelper(v,k,l,h);
    }
```


# Minn and Maxx
[TheJobOverflow | Rotated Sorted Array | Sigmoid](https://www.thejoboverflow.com/problem/287/)