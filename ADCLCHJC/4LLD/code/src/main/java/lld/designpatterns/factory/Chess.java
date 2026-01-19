package code.src.main.java.lld.designpatterns.factory;
public class Chess{
    private final Board board;
    // public Chess(){
    //     this.board= new Board();
    // }

    //minimising the usage of new

    //this is DI (study in detail\)
    //DI with Polymorphic type
    public Chess(Board board){
        this.board= board;
    }
    //we can pass any type of board

}