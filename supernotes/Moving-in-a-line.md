[leetcode.com](https://leetcode.com/problems/check-if-move-is-legal/description/)

![image.png](https://supernotes-resources.s3.amazonaws.com/profile-photos/78762315-8d04-428d-8564-d6679779c250--image.png)

{% raw %}
```cpp
    bool legal(int r, int c, char color, vector<int> &dirv, vector<vector<char>>& board){
        int rr=board.size(),cc=board[0].size();
        r+=dirv[0];
        c+=dirv[1];
        int length=1;
        while(r>=0 and r<rr and c>=0 and c<cc){
            length += 1;
            if(board[r][c] == '.') return 0;
            if(board[r][c] == color) return length >= 3;
            r+=dirv[0];
            c+=dirv[1];
        }
        return 0;
    }


    bool checkMove(vector<vector<char>>& board, int rmove, int cmove, char color) {
        //free .
        //white W
        //black B
        vector<vector<int>> dir={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{1,-1},{-1,1},{1,1}};
        for(auto &v: dir) if(legal(rmove,cmove,color,v,board)) return 1;
        return 0;
    }
```
{% endraw %}

