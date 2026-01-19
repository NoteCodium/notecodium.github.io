package code.src.main.java.lld.reuse.as_it_is.random;

public class IdGeneration {
    public int registerNewPlayer(int n){
        Random random = new Random();
        int id;
        if(player1==null){
            player1=new ChessPlayer(random.nextInt(1,100),TicMove.ZERO);
            id=player1.getId();
            this.n=n;
        }
        else if(player2==null){
            if(n!=this.n){
                throw new IllegalArgumentException("Choose Another Board size");
            }
            player2=new ChessPlayer(random.nextInt(1,100),TicMove.CROSS);
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
}
