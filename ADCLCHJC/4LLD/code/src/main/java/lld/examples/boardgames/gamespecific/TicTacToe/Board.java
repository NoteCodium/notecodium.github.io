package code.src.main.java.lld.examples.boardgames.gamespecific.TicTacToe;

public class Board {
    private Move[][] moves;
    private int n;


    public void setUp(int n){
        this.n=n;
        this.moves=new Move[this.n][this.n];
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n;j++){
                moves[i][j]=Move.EMPTY;
            }
        }
    }

    public String getFormattedBoard(){
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.n;j++){
                if(moves[i][j]==Move.ZERO){
                    sb.append('1');
                }
                else if(moves[i][j]==Move.CROSS){
                    sb.append('2');
                }
                else{
                    sb.append('0');
                }
            }
        }
        return sb.toString();
    }

    public void setMove(int x, int y, Move move){
        if(moves[x][y]!=Move.EMPTY) throw new IllegalArgumentException("Invalid move");
        moves[x][y]=move;
    }

    public boolean checkIfOver() {
        //Slow algorithm
        // for (int i = 0; i < 3; i++) {
        //     if (moves[0][i] != Move.EMPTY && moves[0][i] == moves[1][i] && moves[1][i] == moves[2][i]) return true;
        //     if (moves[i][0] != Move.EMPTY && moves[i][0] == moves[i][1] && moves[i][1] == moves[i][2]) return true;
        // }
        // if (moves[0][0] != Move.EMPTY && moves[0][0] == moves[1][1] && moves[1][1] == moves[2][2]) return true;
        // if (moves[0][2] != Move.EMPTY && moves[0][2] == moves[1][1] && moves[1][1] == moves[2][0]) return true;
        // return false;
        

        //Writing an eficient algorithm after leetcode
    }
}

