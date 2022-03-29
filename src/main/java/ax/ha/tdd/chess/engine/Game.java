package ax.ha.tdd.chess.engine;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    String lastMoveResult = "Game hasn't begun";
    Player playerToMove = Player.BLACK;


    public Player getPlayerToMove() {
        if (playerToMove == Player.BLACK){
            playerToMove = Player.WHITE;
        }
        else{
            playerToMove = Player.BLACK;
        }
        return playerToMove;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc.


        return lastMoveResult;
    }

    public void move(String move) {
        //TODO this should trigger your move logic.
        //input from field


        System.out.println("Player tried to perform move: " + move);
    }
}
