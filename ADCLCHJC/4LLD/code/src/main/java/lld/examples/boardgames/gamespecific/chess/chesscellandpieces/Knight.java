package code.src.main.java.lld.examples.boardgames.gamespecific.chess.chesscellandpieces;

import lld.examples.boardgames.allboardgames.boards.ChessBoard;

public class Knight extends ChessPiece{

    public Knight(Color color, PieceName pieceName, boolean isDead) {
        super(color, pieceName, isDead);
        //doubt
    }

    //doubt here
    @Override
    public void move(ChessCell src, ChessCell des, ChessBoard chessBoard) {
        //There is  going to be a common functionaility among all the moves

        int x_diff=Math.abs(src.getX()-des.getX());
        int y_diff=Math.abs(src.getY()-des.getY());


        //specfic to knight
        if(!(Math.max(x_diff,y_diff)==2 && Math.min(x_diff,y_diff)==1)){
            throw new RuntimeException("Invalid move");
        }

        //There is  going to be a common functionaility among all the moves
        //Refractor it further

        if(des.getChessPiece().isPresent()){
            //Agar ye condition sahi rahegi tabhi tum katne par dhyan doge
            //Agar kati to move karoge, nahi kategi nahi move karge
            if(des.getChessPiece().get().getColor().equals(this.getColor())){
                throw new RuntimeException("Invalid move");
            }
            else{
                des.getChessPiece().get().setDead(true);
            }
        }

        




    }
}
