package ax.ha.tdd.chess.engine;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    boolean isNewGame = true;
    String lastMoveResult = "Game hasn't begun";



    public Player getPlayerToMove() {
        //TODO this should reflect the current state.
        return Player.WHITE;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc.
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return "Last move was successful (default reply, change this)";
    }

    public void move(String move) {
        //TODO this should trigger your move logic.
        //input from field


        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
    }
}
