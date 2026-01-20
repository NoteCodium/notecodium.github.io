[Valid Sudoku - LeetCode](https://leetcode.com/problems/valid-sudoku/description/)

```cpp

int getMatNum(int r, int c){
    return 3*(r/3)+ c/3;
}


bool isValidSudoku(vector<vector<char>>& ma) {
    vector<vector<int>> rf(9,vector<int>(9,0)),cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
    for(int i=0;i<9;i++) for(int j=0;j<9;j++){
        if(ma[i][j]!='.') {
            if(++rf[i][(ma[i][j]-'1')]>1 or ++cf[j][(ma[i][j]-'1')]>1 or ++mf[getMatNum(i,j)][(ma[i][j]-'1')]>1) return 0;
        }
    }
    return 1;
}
```