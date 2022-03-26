package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPiece {

    public Bishop(PieceType pieceType, Player player, Coordinates location) {
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
        //Check if destination is on a diagonal
        if (destination.getX() - location.getX() == destination.getY() - location.getY()){
            //Left and up
            if (destination.getX() < location.getX() && destination.getY() < location.getY()){
                int x = location.getX()-1;
                int y = location.getY()-1;
                while (x > destination.getX() && y > destination.getY()){
                    if (chessboard.getPiece(new Coordinates(x,y)) != null){
                        return false;
                    }
                    x--;
                    y--;
                }
            }
        }

        return true;
    }
}
