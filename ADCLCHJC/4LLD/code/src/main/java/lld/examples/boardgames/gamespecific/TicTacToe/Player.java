package code.src.main.java.lld.examples.boardgames.gamespecific.TicTacToe;

public class Player {
    private final int id;
    private final Move move;
    public Player(int id, Move move){
        this.id=id;
        this.move=move;
    }
    public int getId() {
        return id;
    }

    public Move getMove() {
        return move;
    }
}
