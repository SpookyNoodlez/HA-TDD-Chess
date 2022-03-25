package ax.ha.tdd.chess.engine;

public enum Player {
    WHITE("W"),
    BLACK("B");

    private String symbol;

    Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getOppositeSymbol(){
        if (this.symbol == "W"){
            return "B";
        }
        return "W";
    }
}
