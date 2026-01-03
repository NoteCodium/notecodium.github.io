https://leetcode.com/problems/sudoku-solver/description/
1. vecor<int> indicates one square 3*3 matrix
2. the input is vector<vector<int>>
3. Unique solution is given in the question
4. A sudoko have multiple solutions when its invalid
5. The min. no. of clues needed to force a unique solution is 17

```cpp
int getMatNum(int r, int c){
  return 3*(r/3)+c/3;
}

void populateTrackers(vector<vector<char>> &ma,vector<vector<int>> &rf, vector<vector<int>> &cf, vector<vector<int>> &mf){
  for(int r=0;r<9;r++){
    for(int c=0;c<9;c++){
       if(ma[r][c]!='.'){
         rf[r][ma[r][c]-'1']++;
         cf[c][ma[r][c]-'1']++;
         mf[getMatNum(r,c)][ma[r][c]-'1']++;  
      }   
    }
  }
}

void sudokoSolver(vector<vector<char>> &ma,vector<vector<int>> &rf, vector<vector<int>> &cf, vector<vector<int>> &mf, bool &ansFound, int r, int c){
  if(ansFound){
    return;
  }
  
  
}

void solveSudoko(vector<vector<char>> &ma){
  bool ansFound=0;
  vector<vector<int>> rf(9,vector<int>(9,0)), cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
  populateTrackers(ma,rf,cf,mf);
  sudokoSolver((ma,rf,cf,mf,ansFound,0,0);
}


```
