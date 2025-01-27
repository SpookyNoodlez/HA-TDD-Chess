package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

import static java.lang.Math.abs;

public class King extends ChessPiece {
    private boolean hasMoved = false;


    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //Don't capture own pieces (also makes sure you can't move to the same square)
        if (chessboard.getPiece(destination) != null) {
            if (chessboard.getPiece(destination).matchesPlayer(player)) {
                return false;
            }
        }
        //Move one space
        if (destination.getX() == location.getX() + 1 || destination.getX() == location.getX() - 1
                || destination.getY() == location.getY() + 1 || destination.getY() == location.getY() - 1) {
            //Go through all enemy moves to make sure king not in check
            for (ChessPiece[] row : chessboard
            ) {
                for (ChessPiece piece : row
                ) {
                    if (piece != null) {
                        if (piece.pieceType != PieceType.KING) {//Ignore kings
                            if (piece.canMove(chessboard, destination) && !piece.matchesPlayer(player)) {
                                return false;
                            }
                        }
                        else if(piece.pieceType == PieceType.KING && !piece.matchesPlayer(player)){
                            if (abs(piece.location.getX()) - abs(destination.getX()) == 1 || abs(piece.location.getY()) - abs(destination.getY()) == 1)
                            return false;
                        }
                    }
                }
            }
            //For castling
            hasMoved = true;
            return true;
        }

        return false;
    }
}