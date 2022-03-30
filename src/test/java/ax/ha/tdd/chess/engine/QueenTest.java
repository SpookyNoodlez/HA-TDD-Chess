package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueenTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }

    //Rook tests
    @Test
    public void MoveLeftUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(0,4)));
    }
    @Test
    public void MoveRightUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(7,4)));
    }
    @Test
    public void MoveUpUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,5));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void MoveDownUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void FailToTakeOwnPiece(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(1,2));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(1,2)));
    }
    @Test
    public void PieceInThePathGoingLeft(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(2,2));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(0,2)));
    }
    @Test
    public void PieceInThePathGoingRight(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(5,2));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(7,2)));
    }
    @Test
    public void PieceInThePathGoingUp(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,6));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void PieceInThePathGoingDown(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,3));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void CaptureEnemyDown(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,3));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates(4,5));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void CaptureEnemyUp(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,5));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates(4,3));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void CaptureEnemyLeft(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,5));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates(1,5));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(1,5)));
    }
    @Test
    public void CaptureEnemyRight(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,5));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.BLACK,new Coordinates(7,5));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(7,5)));
    }
    @Test
    public void FailToMoveToSameSpace(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        board.addPiece(queen);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void FailToMoveToRandomSpace(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,2));
        board.addPiece(queen);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(6,5)));
    }

    //Bishop tests
    @Test
    public void MoveUpLeftUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(2,2)));
    }
    @Test
    public void MoveUpLeftBlocked(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(3,3));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(2,2)));
    }
    @Test
    public void MoveDownLeftUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(7,2));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveDownLeftBlocked(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(7,2));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(5,4));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveUpRightUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(6,2)));
    }
    @Test
    public void MoveUpRightBlocked(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(4,4));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(5,3));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(6,2)));
    }

    @Test
    public void MoveDownRightUnhindered(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(0,2));
        board.addPiece(queen);

        Assertions.assertTrue(queen.canMove(board,new Coordinates(3,5)));
    }
    @Test
    public void MoveDownRightBlocked(){
        Queen queen = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(0,2));
        Queen queen2 = new Queen(PieceType.QUEEN,Player.WHITE,new Coordinates(1,3));
        board.addPiece(queen);
        board.addPiece(queen2);

        Assertions.assertFalse(queen.canMove(board,new Coordinates(3,5)));
    }
}
