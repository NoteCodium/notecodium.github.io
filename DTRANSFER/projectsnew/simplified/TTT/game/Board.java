package com.example.TicTacToeBackend.game;

import org.springframework.stereotype.Component;

@Component
public class Board {
    private Move[][] moves;
    public void setUp(){
        this.moves=new Move[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                moves[i][j]=Move.EMPTY;
            }
        }
    }

    public int getFormattedBoard(){
        int board=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(moves[i][j]==Move.ZERO){
                    board=board*10+1;
                }
                else if(moves[i][j]==Move.CROSS){
                    board=board*10+2;
                }
                else{
                    board=board*10+0;
                }
            }
        }
        return board;
    }

    public void setMove(int x, int y, Move move){
        if(moves[x][y]!=Move.EMPTY) throw new IllegalArgumentException("Invalid move");
        moves[x][y]=move;
    }

    public boolean checkIfOver() {
        for (int i = 0; i < 3; i++) {
            if (moves[0][i] != Move.EMPTY && moves[0][i] == moves[1][i] && moves[1][i] == moves[2][i]) return true;
            if (moves[i][0] != Move.EMPTY && moves[i][0] == moves[i][1] && moves[i][1] == moves[i][2]) return true;
        }
        if (moves[0][0] != Move.EMPTY && moves[0][0] == moves[1][1] && moves[1][1] == moves[2][2]) return true;
        if (moves[0][2] != Move.EMPTY && moves[0][2] == moves[1][1] && moves[1][1] == moves[2][0]) return true;
        return false;
    }
}
