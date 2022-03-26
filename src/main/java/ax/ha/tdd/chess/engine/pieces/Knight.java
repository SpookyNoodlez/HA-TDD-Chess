package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPiece {

    public Knight(PieceType pieceType, Player player, Coordinates location) {
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

        if      (destination.getY() == location.getY()-1 && destination.getX() == location.getX()-2){return true;}//One up two left
        else if (destination.getY() == location.getY()-1 && destination.getX() == location.getX()+2){return true;}//One up two right
        else if (destination.getY() == location.getY()+1 && destination.getX() == location.getX()-2){return true;}//One down two left
        else if (destination.getY() == location.getY()+1 && destination.getX() == location.getX()+2){return true;}//One down two right


        return false;
    }
}
