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
  if(r==9){
    ansFound=1;
    return;
  }
  if(ma{r][c]!='.'){
  //the block is already filled with a number, so move to the next block accordingly
    if(c<8){
      sudokoSolver((ma,rf,cf,mf,ansFound,r,c+1);
    }
    else{
      sudokoSolver((ma,rf,cf,mf,ansFound,r+1,0);
    }
  }  
}
else{
  int matNum=getMatNum(r,c);
  for(int num=0;num<9;num++){
    if(!rf[r][num] and !cf[c][num] and !mf[matNum][num]){
      ma[r][c]='1'+num;
      rf[r][num]=cf[c][num]=mf[matnum][num]=1;
      if(c<8){
        sudokoSolver((ma,rf,cf,mf,ansFound,r,c+1);
      }
      else{
        sudokoSolver((ma,rf,cf,mf,ansFound,r+1,0);
      }
      if(ansFound){
        return;
      }
      ma[r][c]='.';
      rf[r][num]=cf[c][num]=mf[matnum][num]=0;
    }
  }
}

void solveSudoko(vector<vector<char>> &ma){
  bool ansFound=0;
  vector<vector<int>> rf(9,vector<int>(9,0)), cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
  populateTrackers(ma,rf,cf,mf);
  sudokoSolver((ma,rf,cf,mf,ansFound,0,0);
}


```



https://leetcode.com/problems/valid-sudoku/description/
1. only the filled cells needs to be validated

```cpp
int getMatNum(int r, int c){
  return 3*(r/3)+c/3;
}

bool isValidSudoko(vector<vector<char>> &ma){
  vector<vector<int>> rf(9,vector<int>(9,0)), cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
  for(int r=0;r<9;r++){
    for(int c=0;c<9;c++){
       if(ma[r][c]!='.'){
        if(++rf[r][ma[r][c]-'1']>1 or ++cf[c][ma[r][c]-'1']>1 or ++mf[getMatNum(r,c)][ma[r][c]-'1']>1){
              return 0;
            }
      }   
    }
  }
  return 1;
}




```

https://leetcode.com/problems/n-queens/description/
1. Placing n queens on a n*n chessboard such that no two queens attack each other
2. vector<string> is one such configuration, given an input, you have to return all the possible configurations

```cpp

bool isSafe(int r, int c, int n, vector<string> &tmp){
  int x=r-1,y;
  while(x>=0){
    if(tmp[x][c]=='Q'){
      return 0;
    }
    x--;
  }
  x=r-1,y=c-1;
  while(x>=0 and y>=0){
    if(tmp[x][c]=='Q'){
      return 0;
    }
    x--;
    y--;
  }
  x=r-1,y=c+1;
  while(x>=0 and y<n){
    if(tmp[x][c]=='Q'){
      return 0;
    }
    x--;
    y++;
  }
  return 1;
}



void f(vector<vector<string>> &ans, vector<string> &tmp, int r, int n){
  if(r==n){
    ans.push_back(tmp);
    return;
  }

  for(int c=0;c<n;c++){
    if(!isSafe(r,c,n,tmp)){
      continue;
    }
    tmp[r][c]='Q';
    //if there is a queen in a row, there will not be any queen in that row
    f(ans,tmp,r+1,n);
    tmp[r][c]='.';
  }

}

vector<vector<string>> solveNQueens(int n){
  vector<vector<string>> ans;
  vector<string> tmp(n,string(n,'.'));
  f(ans,tmp,0,n);
  return ans;
}

```

https://leetcode.com/problems/generate-parentheses/description/
1. Given n pairs of valid brackets

```cpp

void f(vector<string> &ans, string &tmp, int idx, int n, int l, int r){
  if(idx==2*n){
    ans.push_back(tmp);
    return;
  }

  if(l==r){
    tmp.push_back('(');
    f(ans,tmp,idx+1,n,l+1,r);
    tmp.pop_back();
  }
  else{
  //l>r
    if(l==n){
      tmp.push_back(')');
      f(ans,tmp,idx+1,n,l,r+1);
      tmp.pop_back();
    }
    else{
      tmp.push_back('(');
      f(ans,tmp,idx+1,n,l+1,r);
      tmp.pop_back();
  
      tmp.push_back('(');
      f(ans,tmp,idx+1,n,l+1,r);
      tmp.pop_back();
    }
  
  }

}

vector<string> generateParenthesis(int n){
  vector<string> ans;
  string tmp;
  f(ans,tmp,0,n,0,0);
  return ans;
}

```


```cpp
void f(int s1, int e1, int s2, int e2, string s, stack<char> &st, vector<string> &ans){
  if(s1+e1+s2+e2==0){
    if(st.empty()){
      ans.push_back(s);
    }
    return;
  }

  





}



int main(){
string s;
stack<char> st;
vector<string> ans;
rfs(n,n,m,m,s,st,ans);

}

```




