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
        Rook leftLegOfExodia = new Rook(player,location);
        Bishop rightLegOfExodia = new Bishop(PieceType.BISHOP,player,location);
        if (leftLegOfExodia.canMove(chessboard,destination) || rightLegOfExodia.canMove(chessboard,destination)){
            return true;
        }

        return false;
    }
}
