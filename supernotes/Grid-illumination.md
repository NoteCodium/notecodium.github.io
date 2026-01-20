
```
to tell a row have already a bulb
1. rowMap i
2. colMap j
3. majDia i-j
4. minDia i+j
```

[leetcode.com](https://leetcode.com/problems/grid-illumination/description/)

```cpp
vector<int> gridIllumination(int n, vector<vector<int>>& lamps, vector<vector<int>>& queries)
```

1. You are given a 2D array of lamp positions lamps, where lamps[i] = [rowi, coli] indicates that the lamp at grid[rowi][coli] is turned on. Even if the same lamp is listed more than once, it is turned on.
2. When a lamp is turned on, it **illuminates its cell** and **all other cells** in the same **row, column, or diagonal**.
So, while processing each lamp

```cpp
unordered_map<int,int> row,col,majD,minD;
set<vector<int>> bulb;
for(int i=0;i<ma.size();i++){
    int r=ma[i][0],c=ma[i][1];
    if(!bulb.count({r,c})){
        bulb.insert({r,c});
        row[r]++;
        col[c]++;
        majD[r-c]++;
        minD[r+c]++;
    }
}
```
1.   For the jth query, determine whether grid[rowj][colj] is illuminated or not. After answering the jth query, turn off the lamp at grid[rowj][colj] and its 8 adjacent lamps if they exist

```cpp
for(auto q: queries){
    int r=q[0],c=q[1];
    ans.push_back(row[r] or col[c] or majD[r-c] or minD[r+c]);
    int top=r,left=c;
    int bottom=r,right=c;
    if(r-1>=0) top=r-1;
    if(c-1>=0) left=c-1;
    if(r+1<n) bottom=r+1;
    if(c+1<n) right=c+1;
    for (int j = left; j <=right ; ++j) {
        for (int k = top; k <= bottom; ++k) {
            if(bulb.count({k,j})) {
                bulb.erase({k,j});
                row[k]--;
                col[j]--;
                majD[k-j]--;
                minD[k+j]--;
            }
        }
    }
}
```

