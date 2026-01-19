package code.src.main.java.lld.examples.boardgames.gamespecific.chess.chesscellandpieces;

import java.util.Optional;

//there should be property of color, not necessary, it doesnt matter
public class ChessCell {
    private final int x;
    private final int y;
    //I think using pair here would be better
    private Optional<ChessPiece> chessPiece;
    public ChessCell(int x, int y) {
        this.x = x;
        this.y = y;
        chessPiece=Optional.empty();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Optional<ChessPiece> getChessPiece() {
        return chessPiece;
    }
    public void setChessPiece(Optional<ChessPiece> chessPiece) {
        this.chessPiece = chessPiece;
    }
    
    



}
