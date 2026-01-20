```cpp
class TicTacToe {
public:
    int sz;
    vector<int> rows;
    vector<int> cols;
    int diagonal;
    int antiDiagonal;

    TicTacToe(int n) {
        sz=n;
        rows.resize(n, 0);
        cols.resize(n, 0);
        diagonal = 0;
        antiDiagonal = 0;        
    }
    
    int move(int r, int c, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        rows[r]+=currentPlayer;
        cols[c]+=currentPlayer;
        if(r==c) diagonal+=currentPlayer;
        if(c==sz-r-1) antiDiagonal += currentPlayer;
        if ( abs(rows[r])==sz or abs(cols[c])==sz or abs(diagonal)==sz or abs(antiDiagonal)==sz ) return player;
        return 0;
    }
};

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe* obj = new TicTacToe(n);
 * int param_1 = obj->move(row,col,player);
 */
```