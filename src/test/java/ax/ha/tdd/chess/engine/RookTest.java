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
    public void FailToTakeOwnPiece(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        Rook rook2 = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(1,2));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(1,2)));
    }
    @Test
    public void PieceInThePathGoingLeft(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        Rook rook2 = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(2,2));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(0,2)));
    }
    @Test
    public void PieceInThePathGoingRight(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,2));
        Rook rook2 = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(5,2));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(7,2)));
    }
    @Test
    public void PieceInThePathGoingUp(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,6));
        Rook rook2 = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,4));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void PieceInThePathGoingDown(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,3));
        Rook rook2 = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,4));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertFalse(rook.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void CaptureEnemyDown(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,3));
        Rook rook2 = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates(4,5));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void CaptureEnemyUp(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,5));
        Rook rook2 = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates(4,3));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void CaptureEnemyLeft(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,5));
        Rook rook2 = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates(1,5));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(1,5)));
    }
    @Test
    public void CaptureEnemyRight(){
        Rook rook = new Rook(PieceType.ROOK,Player.WHITE,new Coordinates(4,5));
        Rook rook2 = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates(7,5));
        board.addPiece(rook);
        board.addPiece(rook2);

        Assertions.assertTrue(rook.canMove(board,new Coordinates(7,5)));
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
