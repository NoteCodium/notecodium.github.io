package com.example.TicTacToeBackend.game;

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
