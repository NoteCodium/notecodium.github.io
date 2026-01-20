[Just a moment...](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/)


[Leetcode 581. Shortest Unsorted Continuous Subarray || Intuition + Example + Code - YouTube](https://youtu.be/hZmwvBIJXPg?si=PFg9NXCF7q8f3U7V)

```cpp
int n=v.size();
if(n==1) return 0;
int minn=INT_MAX,maxx=INT_MIN;
for(int i=0;i<n;i++){
    if(((i!=0) and (v[i-1]>v[i])) or ((i!=n-1) and (v[i]>v[i+1]))){
        minn=min(v[i],minn);
        maxx=max(v[i],maxx);
    }
}
if(minn==INT_MAX and maxx==INT_MIN){
    return 0;
}
int i=0,j=n-1;
while(i<n and v[i]<=minn) i++;
while(j>=0 and v[j]>=maxx) j--;         
return j-i+1;
}
```




# OLD bad solution

```cpp
int findUnsortedSubarray(vector<int>& v) {
    int n=v.size();
    int l=1;
    int i;
    for(i=1;i<n;i++){
        if(v[i-1]>v[i]){
            l=i-1;
            break;
        }
    }
    if(i==n) return 0;
    int h=n-2;
    for(int i=n-2;i>=0;i--){
        if(v[i+1]<v[i]){
            h=i+1;
            break;
        }
    }
    int minn=*min_element(v.begin()+l,v.begin()+h+1);        
    int maxx=*max_element(v.begin()+l,v.begin()+h+1);

    while(l>0 and v[l-1]>minn) l--;
    while(h<=n-2 and v[h+1]<maxx) h++;
    return h-l+1;
}
```