package code.src.main.java.lld.examples.boardgames.allboardgames;

public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    String getName(){
        return name;
    }

    public abstract Move makeMove();


}
