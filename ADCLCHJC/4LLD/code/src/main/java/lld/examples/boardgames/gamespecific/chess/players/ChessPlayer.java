package code.src.main.java.lld.examples.boardgames.gamespecific.chess.players;

import java.util.Map;

import examplesRefractor.boardgames.allboardgames.Player;
import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessPiece;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.PieceName;

public abstract class ChessPlayer extends Player{

    private final Map<PieceName,ChessPiece> pieceName2ChessPieceMap;
    private final ChessBoard chessBoard;

    public ChessPlayer(String name, Map<PieceName,ChessPiece> pieceName2ChessPieceMap, ChessBoard chessBoard) {
        super(name);
        this.pieceName2ChessPieceMap=pieceName2ChessPieceMap;
        this.chessBoard=chessBoard;
    }
    
    public ChessBoard getChessBoard(){
        return this.chessBoard;
    }

    // public Map<PieceName,ChessPiece> getPieces(){
    //     return pieces;
    // }

        public ChessPiece getChessPiece(PieceName pieceName){
            if(!pieceName2ChessPieceMap.containsKey(pieceName)){
                throw new IllegalArgumentException("Invalid piece");
            }
            return this.pieceName2ChessPieceMap.get(pieceName);    

        }

    // @Override
    // Move makeMove(){

    // }

}
