package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

import static java.lang.Math.abs;

public class Bishop extends ChessPiece {
    public Bishop(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return "B";
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
        if (abs(destination.getX() - location.getX()) == abs(destination.getY() - location.getY())){
            //Left and up
            if (destination.getX() < location.getX() && destination.getY() < location.getY()){
                int checkX = location.getX();
                int checkY = location.getY();
                checkX--;
                checkY--;
                while (destination.getX() < checkX){
                    if (chessboard.getPiece(new Coordinates(checkX,checkY)) != null){
                        return false;
                    }
                    checkX--;
                    checkY--;
                }
            }
            //Left and down
            else if (destination.getX() < location.getX() && destination.getY() > location.getY()){
                int checkX = location.getX();
                int checkY = location.getY();
                checkX--;
                checkY++;
                while (destination.getX() < checkX){
                    if (chessboard.getPiece(new Coordinates(checkX,checkY)) != null){
                        return false;
                    }
                    checkX--;
                    checkY++;
                }
            }
            //Right and up
            else if (destination.getX() > location.getX() && destination.getY() < location.getY()){
                int checkX = location.getX();
                int checkY = location.getY();
                checkX++;
                checkY--;
                while (destination.getX() > checkX){
                    if (chessboard.getPiece(new Coordinates(checkX,checkY)) != null){
                        return false;
                    }
                    checkX++;
                    checkY--;
                }
            }
            //Right and down
            else if (destination.getX() > location.getX() && destination.getY() > location.getY()){
                int checkX = location.getX();
                int checkY = location.getY();
                checkX++;
                checkY++;
                while (destination.getX() > checkX){
                    if (chessboard.getPiece(new Coordinates(checkX,checkY)) != null){
                        return false;
                    }
                    checkX++;
                    checkY++;
                }
            }
        }
        else{
            return false;
        }

        return true;
    }
}
