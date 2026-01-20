[Matrix Block Sum - LeetCode](https://leetcode.com/problems/matrix-block-sum/description/)

```cpp
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& ma, int k) {
        // prefix_sum_matrix(ma);
        int rr=ma.size(),cc=ma[0].size();
        for(int r=0;r<rr;r++) for(int c=0;c<cc;c++){
            if(c-1>=0) ma[r][c]+=ma[r][c-1];
            if(r-1>=0) ma[r][c]+=ma[r-1][c];
            if(r-1>=0 and c-1>=0) ma[r][c]-=ma[r-1][c-1]; 
         }

        vector<vector<int>> ans(rr,vector<int>(cc,0));
        for(int r=0;r<rr;r++) for(int c=0;c<cc;c++){
                int i1 = r-k>=0 ? r-k : 0;
                int j1 = c-k>=0 ? c-k : 0;
                int i2 = r+k<rr ? r+k : rr-1;
                int j2 = c+k<cc ? c+k : cc-1;

                ans[r][c]=ma[i2][j2];
                if(j1-1>=0) ans[r][c]-=ma[i2][j1-1];
                if(i1-1>=0) ans[r][c]-=ma[i1-1][j2];
                if(i1-1>=0 and j1-1>=0) ans[r][c]+=ma[i1-1][j1-1];
        }
        return ans;
    }
```
