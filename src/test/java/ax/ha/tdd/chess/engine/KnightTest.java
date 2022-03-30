package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnightTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }

    @Test
    public void OneUpTwoLeft(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(2,2)));
    }
    @Test
    public void OneUpTwoRight(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(6,2)));
    }
    @Test
    public void OneDownTwoLeft(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(2,4)));
    }
    @Test
    public void OneDownTwoRight(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(6,4)));
    }
    @Test
    public void TwoUpOneLeft(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(3,1)));
    }
    @Test
    public void TwoUpOneRight(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(5,1)));
    }
    @Test
    public void TwoDownOneLeft(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(3,5)));
    }
    @Test
    public void TwoDownOneRight(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,3));
        board.addPiece(knight);

        Assertions.assertTrue(knight.canMove(board,new Coordinates(5,5)));
    }
    @Test
    public void FailToMoveToRandomSpace(){
        Knight knight = new Knight(PieceType.KNIGHT,Player.WHITE,new Coordinates(4,2));
        board.addPiece(knight);

        Assertions.assertFalse(knight.canMove(board,new Coordinates(7,7)));
    }

}
