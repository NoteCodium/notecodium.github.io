package code.src.main.java.lld.examples.boardgames.gamespecific.chess;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lld.examples.boardgames.allboardgames.Board;
import lld.examples.boardgames.allboardgames.Move;
import lld.examples.boardgames.allboardgames.Pair;
import lld.examples.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessCell;
import lld.examples.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessPiece;

public class ChessBoard implements Board{

    private final List<List<ChessCell>> chessCells;
    private static final int rowCnt=8;
    private static final int colCnt=8;


    public ChessBoard(){
        this.chessCells=new ArrayList<>();
        for(int i=0;i<rowCnt;i++){
            List<ChessCell> cells=new ArrayList<>();
            for(int j=0;j<colCnt;j++){
                cells.add(new ChessCell(i,j));
            }
            this.chessCells.add(cells);
        }
    }
    
    
    public void setUp(){
        //but we have used ArrayList this time
        // this.cells=new ChessCell[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){

            }
        }
    }

    public ChessCell getChessCell(Pair pair){
        return this.chessCells.get(pair.getX()).get(pair.getY());
    }

    public List<List<ChessCell>> getCells() {
        return chessCells;
    }
    
    @Override
    public void display() {
        for(int row=0;row<rowCnt;row++){
            for(int col=0;col<colCnt;col++){
                Pair p=new Pair(row,col);
                Optional<ChessPiece> chessPieceOptional=getChessCell(p).getChessPiece();
                if(!chessPieceOptional.isPresent()){
                    System.out.print("0|");
                }
                else{
                    ChessPiece chessPiece= chessPieceOptional.get();
                    System.out.print(chessPiece.getColor()+" ");
                    System.out.print(chessPiece.getName()+"|");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void applyMove(Move move) {
        //The core logic
        ChessCell srcCell=getChessCell(move.getSrc());
        ChessPiece chessPiece=srcCell.getChessPiece().get();
        chessPiece.move(srcCell, getChessCell(move.getDes()), this);
    }


    
    
}
