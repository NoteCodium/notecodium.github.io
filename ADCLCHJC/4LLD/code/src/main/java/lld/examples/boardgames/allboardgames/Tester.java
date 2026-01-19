package code.src.main.java.lld.examples.boardgames.allboardgames;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;
import examplesRefractor.boardgames.allboardgames.games.ChessGame;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.Bishop;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.ChessPiece;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.PieceName;
import examplesRefractor.boardgames.allboardgames.players.chess.ChessPlayer;
import examplesRefractor.boardgames.allboardgames.players.chess.HumanChessPlayer;


public class Tester {
    public static void main(String[] args) {
        //chess
        ChessBoard chessBoard= new ChessBoard();
        //how to decide when to use concrete class and when to use interfaces
        ChessPlayer firstPlayer=
            new HumanChessPlayer(
                    "Saurabh White",
                    getPieces(Color.WHITE),
                    chessBoard
            );
        ChessPlayer secondPlayer=
            new HumanChessPlayer(
                    "Tarun Black",
                    getPieces(Color.BLACK),
                    chessBoard
            );

        Game chessGame=new ChessGame(chessBoard, firstPlayer, secondPlayer);
        chessGame.startGame();
    }

    private static Map<PieceName, ChessPiece> getPieces(Color color){
        Map<PieceName, ChessPiece> pieceName2ChessPieceMap=
            new HashMap<>();

        pieceName2ChessPieceMap.put(PieceName.BISHOP1, new Bishop(color, PieceName.BISHOP1, false));
        return pieceName2ChessPieceMap;
        
    }
}
