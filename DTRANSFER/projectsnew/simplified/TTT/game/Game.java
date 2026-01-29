package com.example.TicTacToeBackend.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Game {
    @Autowired
    private Board board;
    private Player player1, player2,nextPlayer,winner;

    public int registerNewPlayer(){
        Random random = new Random();
        int id;
        if(player1==null){
            player1=new Player(random.nextInt(1,100),Move.ZERO);
            id=player1.getId();
        }
        else if(player2==null){
            player2=new Player(random.nextInt(1,100),Move.CROSS);
            id=player2.getId();
            nextPlayer=player1;
            board.setUp();
        }
        else{
            //doubt revise error handling
            throw new IllegalStateException("Registration is closed");
        }
        return id;
    }


    public int getBoard(){
        if(nextPlayer==null) throw new IllegalStateException("Game has not started yet");
        return board.getFormattedBoard();
    }

    public String play(int playerId,int x, int y){
        if(winner!=null) return "Game Over"+ winner.getId()+" wins";
        if(nextPlayer==null) throw new IllegalStateException("Game has not started yet");
        if(playerId!=nextPlayer.getId()) throw new IllegalStateException("Not your turn");
        if(x<0 || x>2 || y<0 || y>2) throw new IllegalArgumentException("Invalid move");
        board.setMove(x,y,nextPlayer.getMove());
        if(board.checkIfOver()){
            winner=nextPlayer;
            return "Game Over"+ winner.getId()+" wins";
        }
        nextPlayer=nextPlayer==player1?player2:player1;
        return "Move made";
    }

}
