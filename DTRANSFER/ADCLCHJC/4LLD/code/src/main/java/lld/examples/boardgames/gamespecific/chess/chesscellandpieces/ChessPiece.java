package code.src.main.java.lld.examples.boardgames.gamespecific.chess.chesscellandpieces;

import lld.examples.boardgames.allboardgames.boards.ChessBoard;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ChessPiece {
    private final Color color;
    private final PieceName name;
    private boolean isDead;

    // public ChessPiece(Color color, PieceName name, boolean isDead) {
    //     this.color = color;
    //     this.name = name;
    //     this.isDead=isDead;
    // }

    public abstract void move(ChessCell src, ChessCell des, ChessBoard chessBoard);

    boolean isDead(){
        return isDead;
    }
    void setDead(boolean isDead){
        this.isDead=isDead;
    }

    public PieceName getName(){
        return this.name;
    }

    public Color getColor() {
        return color;
    }

}
