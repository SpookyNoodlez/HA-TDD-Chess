package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;

public class Game {

    Chessboard board = Chessboard.startingBoard();
    String lastMoveResult = "Game hasn't begun";
    Player playerToMove = Player.WHITE;


    public Player getPlayerToMove() {
        return playerToMove;
    }

    public void switchActivePLayer() {
        if (playerToMove == Player.BLACK){
            playerToMove = Player.WHITE;
        }
        else{
            playerToMove = Player.BLACK;
        }
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //Used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc.
        return lastMoveResult;
    }

    public void move(String move) {
        //parse input from player
        if (move == "O-O"){
            //castle right
        }
        else if (move == "O-O-O"){
            //castle left
        }
        else if (move.matches("[A-Ha-h][1-8]-[A-Ha-h][1-8]")){
            String[] startAndEnd = move.split("-");
            String start = startAndEnd[0];
            String end = startAndEnd[1];

            ChessPiece selectedPiece = board.getPiece(new Coordinates(start));
            //Only allow movement of the piece if it is that player's turn
            if (selectedPiece.matchesPlayer(getPlayerToMove())){
                //Check if the piece can move there
                if (selectedPiece.canMove(board, new Coordinates(end))){
                    //Move the piece
                    selectedPiece.setLocation(new Coordinates(end));
                    board.addPiece(selectedPiece);
                    board.removePiece(new Coordinates(start));
                    //Update lastmoveresult
                    lastMoveResult = start + " to " + end;

                    switchActivePLayer();
                }
                else{
                    lastMoveResult = "That piece can't move there";
                }
            }
            else{
                lastMoveResult = "Wrong player selected";
            }
        }
        else{
            lastMoveResult = "Invalid input: " + move;
        }

        System.out.println("Player tried to perform move: " + move);
    }
}
