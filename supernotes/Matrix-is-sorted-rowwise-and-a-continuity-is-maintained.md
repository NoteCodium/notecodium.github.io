[leetcode.com](https://leetcode.com/problems/search-a-2d-matrix/description/)

```cpp
bool searchMatrix(vector<vector<int>>& ma, int k) {
    int rr=ma.size(),cc=ma[0].size();
    int l=0,h=rr*cc-1;
    while(l<=h){
        int m=(l+h)/2;
        int curr=ma[m/cc][m%cc];
        if(curr==k) return 1;
        else if (curr<k) l=m+1;
        else h=m-1;
    }
    return 0;
}
```