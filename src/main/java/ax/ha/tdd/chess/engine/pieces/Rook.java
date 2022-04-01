package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Rook extends ChessPiece {
    private boolean hasMoved = false;

    public Rook(PieceType pieceType, Player player, Coordinates location) {
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

        //If moving vertically
        if (location.getY() == destination.getY()){
            //If moving left
            if (destination.getX() < location.getX()){
                for (int i = location.getX()-1;i>destination.getX();i--){
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(i, location.getY())) != null){
                        return false;
                    }
                }
            }
            //if moving right
            else{
                for (int i = location.getX()+1;i<destination.getX();i++){
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(i, location.getY())) != null){
                        return false;
                    }
                }
            }
        }
        //If moving horizontally
        else if (location.getX() == destination.getX()){
            //If moving up
            if (destination.getY() < location.getY()){
                for (int i = location.getY()-1;i>destination.getY();i--){
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(location.getX(), i)) != null){
                        return false;
                    }
                }
            }
            //if moving down
            else{
                for (int i = location.getY()+1;i<destination.getY();i++){
                    //If obstacle hit
                    if (chessboard.getPiece(new Coordinates(location.getX(), i)) != null){
                        return false;
                    }
                }
            }
        }
        //not lined up
        else{
            return false;
        }

        //for castling
        hasMoved = true;
        return true;
    }

    public boolean getHasMoved(){
        return hasMoved;
    }
}
