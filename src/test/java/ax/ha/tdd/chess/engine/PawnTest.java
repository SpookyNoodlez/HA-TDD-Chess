package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PawnTest {

    @Test
    public void WhiteMoveOneSpaceUnhindered(){
        Pawn pawn = new Pawn(PieceType.PAWN,Player.WHITE,new Coordinates(4,6));
        Chessboard board = Chessboard.startingBoard();
        board.addPiece(pawn);

        Assertions.assertTrue(pawn.canMove(board,new Coordinates(4,5)));

    }
}
