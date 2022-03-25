package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PawnTest {
    Chessboard board;

    @BeforeEach
    public void setup(){
        board = Chessboard.startingBoard();
    }
    @Test
    public void WhiteMoveOneSpaceUnhindered(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        board.addPiece(pawn);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void WhiteMoveOneSpaceBlocked(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,5));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,5)));
    }
    @Test
    public void WhiteMoveTwoSpacesUnhindered(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        board.addPiece(pawn);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(4,4)));
    }
    @Test
    public void WhiteMoveTwoSpacesBlockedOnFirstSquare(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,5));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,4)));
    }
    @Test
    public void WhiteMoveTwoSpacesBlockedOnSecondSquare(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,4));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,4)));
    }
    @Test
    public void WhiteCaptureLeft(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(3,5));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(3,5)));
    }
    @Test
    public void WhiteCaptureRight(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(5,5));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(5,5)));
    }
    @Test
    public void WhiteFailToGoToRandomPlace(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        board.addPiece(pawn);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(7,1)));
    }

    //TODO: CHANGE TESTS TO BLACK AND MAKE IT WORK IN PAWN.JAVA
    @Test
    public void BlackMoveOneSpaceUnhindered(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        board.addPiece(pawn);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void BlackMoveOneSpaceBlocked(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,2));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,2)));
    }
    @Test
    public void BlackMoveTwoSpacesUnhindered(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        board.addPiece(pawn);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void BlackMoveTwoSpacesBlockedOnFirstSquare(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,2));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void BlackMoveTwoSpacesBlockedOnSecondSquare(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,3));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(4,3)));
    }
    @Test
    public void BlackCaptureLeft(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(3,2));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(3,2)));
    }
    @Test
    public void BlackCaptureRight(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        Pawn pawn2 = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(5,2));
        board.addPiece(pawn);
        board.addPiece(pawn2);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(5,2)));
    }
    @Test
    public void BlackFailToGoToRandomPlace(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.BLACK,new Coordinates(4,1));
        board.addPiece(pawn);

        Assertions.assertFalse(pawn.canMove(board,new Coordinates(7,1)));
    }
}
