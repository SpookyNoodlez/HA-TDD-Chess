package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Queen extends ChessPiece {

    public Queen(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        //Queen is an eldritch amalgamation consisting of a rook and bishop
        Rook rook = new Rook(pieceType,player,location);
        Bishop bishop = new Bishop(pieceType,player,location);
        if (bishop.canMove(chessboard,destination) || rook.canMove(chessboard,destination)){
            return true;
        }

        return false;
    }
}
