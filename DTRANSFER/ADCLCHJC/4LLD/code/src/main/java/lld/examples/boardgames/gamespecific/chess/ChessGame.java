package code.src.main.java.lld.examples.boardgames.gamespecific.chess;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

// import com.example.TicTacToeBackend.game.Player;

import examplesRefractor.boardgames.allboardgames.Game;
import examplesRefractor.boardgames.allboardgames.Player;
import examplesRefractor.boardgames.allboardgames.boards.ChessBoard;
import examplesRefractor.boardgames.allboardgames.gamespecific.chesscellandpieces.PieceName;
import examplesRefractor.boardgames.allboardgames.players.chess.ChessPlayer;

public class ChessGame extends Game{
    private final ChessPlayer player1, player2;

    public ChessGame(ChessBoard chessBoard,ChessPlayer player1, ChessPlayer player2){
        super(chessBoard, new ArrayDeque<Player>(Arrays.asList(player1, player2)));
        this.player1=player1;
        this.player2=player2;
        prepareBoard(this.player1, this.player2, chessBoard);
    }

    private void prepareBoard(ChessPlayer firstPlayer, ChessPlayer secondPlayer, ChessBoard chessBoard){
        placePawns(1,chessBoard,firstPlayer);
        placePawns(6,chessBoard,secondPlayer);
        placeRooks(0,chessBoard,firstPlayer);
        placeRooks(0,chessBoard,secondPlayer);
    }


    private void placeRooks(int row, ChessBoard chessBoard, ChessPlayer chessPlayer){
        chessBoard.putPiece(
            chessPlayer.getPiece(PieceName.ROOK1),
            row,
            0
        );
        chessBoard.putPiece(
            chessPlayer.getPiece(PieceName.ROOK2),
            row,
            7
        );
    }

    private void placePawns(int row, ChessBoard chessBoard, ChessPlayer chessPlayer){
        List<PieceName> pieceNames=
            Arrays.asList(PieceName.PAWN1,PieceName.PAWN2,PieceName.PAWN3,PieceName.PAWN4,PieceName.PAWN5,PieceName.PAWN6,PieceName.PAWN7,PieceName.PAWN8);
        
        int col=0;
        for(PieceName pieceName: pieceNames){
            chessBoard.putPiece(
                chessPlayer.getPiece(pieceName),
                row,
                col++
            );
        }

        //implement the unimplemented methods

    }

    
    // public ChessBoard getChessBoard(){
    //     return this.chessBoard;
    // }
    

    @Override
    public boolean isOver() {
        return player1.getChessPiece(PieceName.KING).isDead()||
        player2.getChessPiece(PieceName.KING).isDead();
    }




    // public ChessGame(Board board, Queue<Player> players, ChessPlayer player1, ChessPlayer player2) {
    //     super(board, players);
    //     this.player1 = player1;
    //     this.player2 = player2;
    // }
    
}
