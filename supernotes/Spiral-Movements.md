[](https://leetcode.com/problems/spiral-matrix/)
  
```cpp
int top=0,bottom=rr-1;
int left=0,right=cc-1;
```
```cpp
while(left<right and top<bottom){
  for(c=left to right) ans.pb(ma[top][c]);
  for(r=top+1 to bottom-1) ans.pb(ma[r][right]);
  for(c=right to left) ans.pb(ma[bottom][c]);
  for(r=bottom-1 to top+1) ans.pb(ma[r][left]);
  top++;
  bottom--;
  left++;
  right--;
}
```

```cpp
if(top==bottom) for(c=left to right) ans.pb(ma[top][c]);
else if(left==right) for(r=top to bottom) ans.pb(ma[r][left]);
```
```cpp
vector<int> spiralOrder(vector<vector<int>>& ma) {
    int rr=ma.size(),cc=ma[0].size();
    vector<int> ans;
    int left=0,right=cc-1,top=0,bottom=rr-1;
    while(left<right and top<bottom){
        for (int c = left; c <= right; ++c) ans.push_back(ma[top][c]);
        for(int r=top+1;r<=bottom-1;r++) ans.push_back(ma[r][right]);
        for (int c = right; c >= left; --c) ans.push_back(ma[bottom][c]);
        for(int r=bottom-1;r>=top+1;--r) ans.push_back(ma[r][left]);
        top++;
        bottom--;
        left++;
        right--;
    }
    if(top==bottom) for (int c = left; c <= right; ++c) ans.push_back(ma[top][c]);
    else if(left==right) for(int r=top;r<=bottom;++r) ans.push_back(ma[r][left]);

    return ans;
}
```

