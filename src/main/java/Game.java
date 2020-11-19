public class Game {
    private TicTacToe ticTacToe = new TicTacToe();
    private Figure whoseMove = Figure.X;

    @Override
    public String toString() {
        String s = ticTacToe.toString();
        s += "Next move: " + TicTacToe.getFigureSymbol(whoseMove) + "\n";
        return s;
    }

    public void doMove(Coords coords) {
        if (ticTacToe.setFigure(coords.getX(), coords.getY(), whoseMove))
            whoseMove = opposite(whoseMove);
    }

    private Figure opposite(Figure whoseMove) {
        return (whoseMove == Figure.X) ? Figure.O : Figure.X;
    }

    public boolean isWinner() {
        return ticTacToe.checkWinner() != Figure.NONE;
    }

    public boolean areMovesPossible() {
        return ticTacToe.areMovesPossible();
    }

    public Figure getFigure(int col, int row) {
        return ticTacToe.getFigure(col, row);
    }

    public void initBoard() {
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                ticTacToe.clearCell(x, y);
    }
}
