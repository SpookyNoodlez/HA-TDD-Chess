package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RookTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }

    @Test
    public void MoveLeftUnhindered(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,4));
        board.addPiece(rook);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(0,4)));
    }
    @Test
    public void MoveRightUnhindered(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,4));
        board.addPiece(rook);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(7,4)));
    }
    @Test
    public void MoveUpUnhindered(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,5));
        board.addPiece(rook);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void MoveDownUnhindered(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        board.addPiece(rook);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(4,5)));
    }
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
}
