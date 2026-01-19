package code.src.main.java.lld.examples.boardgames.gamespecific.chess.players;


import java.util.Map;

import examplesRefractor.boardgames.allboardgames.Move;
import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessPiece;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.PieceName;

public class ComputerChessPlayer extends ChessPlayer{
    //using some api so write wrapper classes for it
    //will require ChessBoard to make it move


    public ComputerChessPlayer(String name, Map<PieceName,ChessPiece> pieces, ChessBoard chessBoard){
        super(name,pieces,chessBoard);
    }


    @Override
    public Move makeMove(){
        
    }


}
