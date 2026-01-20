[Array With Elements Not Equal to Average of Neighbors - LeetCode](https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/9d13b0cf-bbe9-4ac5-a74b-6dab4e43a506--image.png)


```cpp
vector<int> rearrangeArray(vector<int>& v) {
    int n=v.size();
    sort(v.begin(),v.end());
    vector<int> ans(n);
    int i=0;
    for(int j=0;j<n;j=j+2) ans[j]=v[i++];
    for(int j=1;j<n;j=j+2) ans[j]=v[i++];
    return ans;
}
```
