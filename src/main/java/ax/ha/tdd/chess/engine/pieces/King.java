package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class King extends ChessPiece {

    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //Don't capture own pieces (also makes sure you can't move to the same square)
        if (chessboard.getPiece(destination) != null){
            if (chessboard.getPiece(destination).matchesPlayer(player)){
                return false;
            }
        }
        //Move one space
        if (destination.getX() == location.getX()+1 || destination.getX() == location.getX()-1
            || destination.getY() == location.getY()+1 || destination.getY() == location.getY()-1){
            return true;
        }


        return false;
    }
}
