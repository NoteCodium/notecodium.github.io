package code.src.main.java.lld.examples.boardgames.gamespecific.chess.chesscellandpieces;

import java.awt.Color;

import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;

//sanity check abstract class codes
public class Bishop extends ChessPiece{
    public Bishop(Color color, PieceName pieceName, boolean isDead) {
        super(color, pieceName, isDead);
        //doubt
    }


    @Override
    public void move(ChessCell src, ChessCell des, ChessBoard chessBoard) {

    }
}
