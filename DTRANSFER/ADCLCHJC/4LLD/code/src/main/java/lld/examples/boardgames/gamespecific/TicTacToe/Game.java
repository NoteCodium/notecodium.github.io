package code.src.main.java.lld.examples.boardgames.gamespecific.TicTacToe;
import java.util.Random;

public class Game {
    private Board board;
    private ChessPlayer player1, player2,nextPlayer,winner;
    private int n;

//See how beautifully we are handling two calls to registerNewPlayer
    public int registerNewPlayer(int n){
        Random random = new Random();
        int id;
        if(player1==null){
            player1=new ChessPlayer(random.nextInt(1,100),Move.ZERO);
            id=player1.getId();
            this.n=n;
        }
        else if(player2==null){
            if(n!=this.n){
                throw new IllegalArgumentException("Choose Another Board size");
            }
            player2=new ChessPlayer(random.nextInt(1,100),Move.CROSS);
            //How we are confirming there are no collision?
            id=player2.getId();
            nextPlayer=player1;
            board.setUp(this.n);
        }
        else{
            //doubt revise error handling
            throw new IllegalStateException("Registration is closed");
        }
        return id;
    }


    public String getBoard(){
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
