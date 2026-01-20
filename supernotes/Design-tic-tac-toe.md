![image.png](https://supernotes-resources.s3.amazonaws.com/image-uploads/a4645bd6-88e7-4d78-9077-61b978b3ef2e--image.png)

[leetcode.com](https://leetcode.com/problems/design-tic-tac-toe/description/)

```cpp
class TicTacToe {
public:

    vector<vector<int>> board;
    int n;

    TicTacToe(int n) {
        board.assign(n, vector<int>(n, 0));
        this->n = n;        
    }
    
    int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkCol(col, player) ||
            checkRow(row, player) ||
            (row == col && checkDiagonal(player)) ||
            (row == n - col - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        // No one wins
        return 0;        
    }

    bool checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) return false;
        }
        return true;
    }

    bool checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) return false;
        }
        return true;
    }

    bool checkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }

    bool checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }



};

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe* obj = new TicTacToe(n);
 * int param_1 = obj->move(row,col,player);
 */
```
