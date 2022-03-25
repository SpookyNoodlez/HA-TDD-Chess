package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Rook extends ChessPiece {

    public Rook(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }


    //TODO: TAKE INTO ACCOUNT DESTINATION BEING THE SAME AS LOCATION
    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //Don't capture own pieces
        if (chessboard.getPiece(destination) != null){
            if (chessboard.getPiece(destination).matchesPlayer(player)){
                return false;
            }
        }

        //If moving vertically
        if (location.getX() == destination.getX()){
            //If moving left
            if (destination.getX() < location.getX()){
                for (int i = location.getX();i<destination.getX()+1;i--){ //one removed to not hit enemy piece to capture
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(i, location.getY())) != null){
                        return false;
                    }
                }
            }
            //if moving right
            else{
                for (int i = location.getX();i>destination.getX()-1;i++){ //one removed to not hit enemy piece to capture
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(i, location.getY())) != null){
                        return false;
                    }
                }
            }
        }


        return true;
    }
}
