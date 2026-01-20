[Row with max 1s | Practice | GeeksforGeeks ](https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1)

```cpp
int rowWithMax1s(vector<vector<int> > ma, int rr, int cc) {     
    int r=0,c=cc-1;
    int ans_r=-1;
    int ans_c=cc;
    while(r<rr and cc>=0){
        if(ma[r][c]==1 and c<ans_c){
          ans_r=r;
          ans_c=c;
          c--;
        } 
        else r++;
    }
    return ans_r;
}
```
