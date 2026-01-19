package code.src.main.java.lld.examples.boardgames.gamespecific.chess.players;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import examplesRefractor.boardgames.allboardgames.Move;
import examplesRefractor.boardgames.allboardgames.Pair;
import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessPiece;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.PieceName;

public class HumanChessPlayer extends ChessPlayer{

    public HumanChessPlayer(String name, Map<PieceName,ChessPiece> pieceName2ChessPieceMap, ChessBoard chessBoard){
        super(name,pieceName2ChessPieceMap,chessBoard);
    }

    @Override
    public Move makeMove(){
        //how it is working, 
        //as it is extending ChessPlayer and ChessPlayer have this 
        //function available as public
        getChessBoard().display();
        int x, y;
        Scanner scanner=
            new Scanner(System.in);

        x=scanner.nextInt();
        y=scanner.nextInt();

        Pair src= new Pair(x,y);

        Optional<ChessPiece> chessPieceOptional=
            getChessBoard().getCell(src).getChessPiece();
        
        if(!chessPieceOptional.isPresent()){
            throw new RuntimeException("Invalid spot");
        }
        ChessPiece chessPiece=chessPieceOptional.get();

        if (!chessPiece.getColor().equals(getChessPiece(chessPiece.getName()).getColor())){
            throw new RuntimeException("Invalid piece");
        }
        //to check we are moving our own piece


        x=scanner.nextInt();
        y=scanner.nextInt();

        Pair des= new Pair(x,y);
        return new Move(src, des);

        //doubt how it is actually working
    }
}
