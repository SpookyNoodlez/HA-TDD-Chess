package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.*;

public class PieceIdentifier {
    ChessPiece returnCorrectPiece(PieceType pieceType, Player player, Coordinates coordinates){
        switch (pieceType){
            case PAWN -> {
                return new Pawn(pieceType, player, coordinates);
            }
            case ROOK -> {
                return new Rook(pieceType, player, coordinates);
            }
            case KING -> {
                return new King(pieceType, player, coordinates);
            }
            case QUEEN -> {
                return new Queen(pieceType, player, coordinates);
            }
            case BISHOP -> {
                return new Bishop(pieceType, player, coordinates);
            }
            case KNIGHT -> {
                return new Knight(pieceType, player, coordinates);
            }
        }

        return null;
    }
}
