[Sudoku Solver - LeetCode](https://leetcode.com/problems/sudoku-solver/description/)


```cpp
void solveSudoku(vector<vector<char>>& ma) {
	bool ansFound=0;
	vector<vector<int>> rf(9,vector<int>(9,0)),cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
	for(int i=0;i<9;i++) for(int j=0;j<9;j++){
		if(ma[i][j]!='.') {
			rf[i][(ma[i][j]-'1')]++;
			cf[j][(ma[i][j]-'1')]++;
			mf[getMatNum(i,j)][(ma[i][j]-'1')]++;
		}
	}
	sudokoSolver(ma,rf,cf,mf,ansFound,0,0);
}
```

```cpp
void f(r,c){
	if(ansFound) return;
	if(r==9){
		ansFound=1;
		return;
	}
	if(ma[r][c]!='.'){
		//the block is already filled
		if(c<8) f(r,c+1);
		else f(r+1,0);
	}
	else{
		int matNum=getMatNum(r,c);
		for(int num=0;num<9;num++){
			if(!rf[r][num] and !cf[c][num] and !mf[matNum][num]){
				ma[r][c]='1'+num;
				rf[r][num]=cf[c][num]=mf[matNum][num]=1;
				if(c<8) f(i,j+1);
				else f(i+1,0);
				if(ansFound) return;
				ma[r][c]='.';
				rf[r][num]=cf[c][num]=mf[matNum][num]=0;
			}
		}
	}

}
```

```cpp
int getMatNum(int r, int c){
	return 3*(r/3)+ c/3;
}

```


# Full code

```cpp
int getMatNum(int r, int c){
    return 3*(r/3)+ c/3;
}

void sudokoSolver(vector<vector<char>>& ma, vector<vector<int>> &rf, vector<vector<int>> &cf, vector<vector<int>> &mf ,bool &ansFound, int r, int c){
    if(ansFound) return;
    if(r==9){
        ansFound=1;
        return;
    }
    if(ma[r][c]!='.'){
        if(c<8) sudokoSolver(ma,rf,cf,mf,ansFound,r,c+1);
        else sudokoSolver(ma,rf,cf,mf,ansFound,r+1,0);
    }
    else{
        int matNum=getMatNum(r,c);
        for(int i=0;i<9;i++){
            if(!rf[r][i] and !cf[c][i] and !mf[matNum][i]){
                ma[r][c]='1'+i;
                rf[r][i]=cf[c][i]=mf[matNum][i]=1;
                if(c<8) sudokoSolver(ma,rf,cf,mf,ansFound,r,c+1);
                else sudokoSolver(ma,rf,cf,mf,ansFound,r+1,0);   
                if(ansFound) return;
                ma[r][c]='.';
                rf[r][i]=cf[c][i]=mf[matNum][i]=0;                   
            }
        }
    }
}

void solveSudoku(vector<vector<char>>& ma) {
    bool ansFound=0;
    vector<vector<int>> rf(9,vector<int>(9,0)),cf(9,vector<int>(9,0)),mf(9,vector<int>(9,0));
    for(int i=0;i<9;i++) for(int j=0;j<9;j++){
        if(ma[i][j]!='.') {
            rf[i][(ma[i][j]-'1')]++;
            cf[j][(ma[i][j]-'1')]++;
            mf[getMatNum(i,j)][(ma[i][j]-'1')]++;
        }
    }
    sudokoSolver(ma,rf,cf,mf,ansFound,0,0);
}
```

