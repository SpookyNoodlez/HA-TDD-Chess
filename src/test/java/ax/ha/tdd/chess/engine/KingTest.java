package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }

    @Test
    public void MoveUp(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void MoveUpRight(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(5,3)));
    }
    @Test
    public void MoveRight(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(5,4)));
    }
    @Test
    public void MoveRightDown(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(5,5)));
    }
    @Test
    public void MoveDown(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void MoveDownLeft(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(3,5)));
    }
    @Test
    public void MoveLeft(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(3,4)));
    }
    @Test
    public void MoveLeftUp(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertTrue(king.canMove(board,new Coordinates(3,5)));
    }
    @Test
    public void FailToGoToRandomPlace(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        board.addPiece(king);

        Assertions.assertFalse(king.canMove(board,new Coordinates(7,1)));
    }
    @Test
    public void FailToMoveIntoCheck(){
        King king = new King(PieceType.KING,Player.WHITE,new Coordinates(4,4));
        Rook rook = new Rook(PieceType.ROOK,Player.BLACK,new Coordinates(0,5));
        board.addPiece(king);
        board.addPiece(rook);

        Assertions.assertFalse(king.canMove(board,new Coordinates(4,5)));
    }
}
