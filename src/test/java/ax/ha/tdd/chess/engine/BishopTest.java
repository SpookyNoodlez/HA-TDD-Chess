package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }

    @Test
    public void MoveUpLeftUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(4,4));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(2,2)));
    }

    /*
    @Test
    public void FailToMoveToSameSpace(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        board.addPiece(rook);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void FailToMoveToRandomSpace(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        board.addPiece(rook);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(6,5)));
    }
    */
}
