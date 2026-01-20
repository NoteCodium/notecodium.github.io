1. given a continous elevation map in form of array, compute how much water can it trap



![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/2719de20-14e5-4e53-a4a9-4c022568e59f--image.png)


# Algorithm
1. for every element, there wil be water on top of it if there is a pillar on left and right bigger then it
2. The contribution of each pillar will be minimum of the two left and right

[](https://leetcode.com/problems/trapping-rain-water/description/)

```cpp
int trap(vector<int>& v) {
    int n=v.size(),ans=0;
    vector<int> premax(n),postmax(n);
    premax[0]=v[0],postmax[n-1]=v[n-1];
    for(int i=1;i<n;i++){
        premax[i]=max(premax[i-1],v[i]);
        postmax[n-i-1]=max(postmax[n-i],v[n-i-1]);
    }

    for(int i=1;i<=n-2;i++){
        int h1=premax[i-1],h2=postmax[i+1];
        int decide=min(h1,h2);
        if(decide>v[i]) ans+=decide-v[i];
    }
    return ans;
}
```
