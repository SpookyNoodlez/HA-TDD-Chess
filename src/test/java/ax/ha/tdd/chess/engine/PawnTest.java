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
}
