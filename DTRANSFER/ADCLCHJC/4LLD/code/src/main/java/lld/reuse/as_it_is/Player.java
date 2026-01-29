package code.src.main.java.lld.reuse.as_it_is;

public class Player {
    private final int id;
    private final TicMove move;
    public Player(int id, TicMove move){
        this.id=id;
        this.move=move;
    }
    public int getId() {
        return id;
    }

    public TicMove getMove() {
        return move;
    }
}
