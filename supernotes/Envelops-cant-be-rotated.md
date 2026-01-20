[leetcode.com](https://leetcode.com/problems/russian-doll-envelopes/description/)

```cpp
static bool cmp(vector<int> &v1, vector<int> &v2){
    if(v1[0]!=v2[0]) return v1[0]<v2[0];
    return v1[1]>v2[1];
}

int maxEnvelopes(vector<vector<int>>& ma) {
    sort(it(ma));
    int n=ma.size();
    vector<int> ans;  
    ans.push_back(ma[0][1]);
    for(int i=1;i<n;i++) if(ma[i][1]>ans.back()) ans.push_back(ma[i][1]);
    else{
        int idx=lower_bound(it(ans),ma[i][1])-ans.begin();
        ans[idx]=ma[i][1];
    }
    return ans.size(); 
}
```

![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/b608d689-8f15-4e92-a94a-241fbf22a2aa--image.png)

If a tie happens on the level of length, we have to make sure there are not counted in answer, for that we will make the breadth sorted in reverse order, so that the letter can not fit inside each other, if the widths are equal, it will not simply added in the answer 

