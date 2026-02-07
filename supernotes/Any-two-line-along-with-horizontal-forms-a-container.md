[Container With Most Water - LeetCode](https://leetcode.com/problems/container-with-most-water/description/)


1. Find that container having the most water

![image.png](../images/b99b9357-c313-4235-a9b9-e1c1f808b124--image.png)

# Two pointers
```
int maxArea(vector<int>& v) {
   int n=v.size();
   int l=0,h=n-1;
   int ans=INT_MIN;
   while(l<h){
       int minn=min(v[l],v[h]);
       ans=max(ans,(h-l)*minn);
       if(v[l]==minn) l++;
       else h--;
   } 
   return ans;
}
```

