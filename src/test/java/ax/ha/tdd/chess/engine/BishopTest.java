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
    @Test
    public void MoveUpLeftBlocked(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(4,4));
        Bishop bishop2 = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(3,3));
        board.addPiece(bishop);
        board.addPiece(bishop2);

        Assertions.assertFalse(bishop.canMove(board,new Coordinates(2,2)));
    }
    @Test
    public void MoveDownLeftUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(7,2));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveDownLeftBlocked(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(7,2));
        Bishop bishop2 = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(5,4));
        board.addPiece(bishop);
        board.addPiece(bishop2);

        Assertions.assertFalse(bishop.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveUpRightUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(4,4));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(6,2)));
    }
    @Test
    public void MoveDownRightUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(0,2));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(3,5)));
    }

    /*
    @Test
    public void MoveDownLeftUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(7,2));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveUpRightUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(4,4));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(6,2)));
    }
    @Test
    public void MoveDownRightUnhindered(){
        Bishop bishop = new Bishop(PieceType.BISHOP,Player.WHITE,new Coordinates(0,2));
        board.addPiece(bishop);

        Assertions.assertTrue(bishop.canMove(board,new Coordinates(3,5)));
    }*/

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
