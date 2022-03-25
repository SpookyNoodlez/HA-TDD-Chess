package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

public class Pawn extends ChessPiece {

    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //White pawns only move up
        if (player == Player.WHITE){
            //Capture enemy
            if ((destination.getX() == location.getX()+1 || destination.getX() == location.getX()-1) && destination.getY() == location.getY()-1 // IF destination is diagonally adjacent
                && chessboard.getPiece(destination).player == super.getOpponent()){ //AND is occupied by and enemy
                return true;
            }
            //Moving two spaces
            else if (destination.getX() == location.getX() && destination.getY() == 4 && location.getY() == 6 // IF trying to move two spaces on the first turn
                && chessboard.getPiece(destination) == null && chessboard.getPiece(new Coordinates(location.getX(),location.getY()-1)) == null){ //AND both spaces in front are empty
                return true;
            }
            //Moving one space normally
            else if (destination.getX() == location.getX() && destination.getY() == location.getY()-1 //IF moving one space forward
                && chessboard.getPiece(destination) == null){ // AND destination is empty
                return true;
            }
        }

        //Black pawns only move down
        if (player == Player.BLACK){
            //Capture enemy
            if ((destination.getX() == location.getX()+1 || destination.getX() == location.getX()-1) && destination.getY() == location.getY()+1 // IF destination is diagonally adjacent
                    && chessboard.getPiece(destination).player == super.getOpponent()){ //AND is occupied by and enemy
                return true;
            }
            //Moving two spaces
            else if (destination.getX() == location.getX() && destination.getY() == 3 && location.getY() == 1 // IF trying to move two spaces on the first turn
                    && chessboard.getPiece(destination) == null && chessboard.getPiece(new Coordinates(location.getX(),location.getY()+1)) == null){ //AND both spaces in front are empty
                return true;
            }
            //Moving one space normally
            else if (destination.getX() == location.getX() && destination.getY() == location.getY()+1 //IF moving one space forward
                    && chessboard.getPiece(destination) == null){ // AND destination is empty
                return true;
            }
        }


        return false;
    }
}
