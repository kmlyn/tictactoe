
public class TicTacToe {
    private Figure[][] board;

    public TicTacToe() {
        board = new Figure[3][];
        for (int n = 0; n < 3; n++) {
            board[n] = new Figure[3];
            for (int k = 0; k < 3; k++)
                board[n][k] = Figure.NONE;
        }
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public boolean setFigure(int x, int y, Figure figure) {
        if (board[x][y] == Figure.NONE) {
            board[x][y] = figure;
            return true;
        }
        return false;
    }

    public void clearCell(int x, int y) {
        board[x][y] = Figure.NONE;
    }

    public Figure checkWinner() {
        // TODO
        Figure[] symbols = {Figure.X, Figure.O};
        for (Figure symbol : symbols) {
            for (int n = 0; n < 3; n++) {
                if (board[n][0] == symbol && board[n][1] == symbol && board[n][2] == symbol)
                    return symbol;
                if (board[0][n] == symbol && board[1][n] == symbol && board[2][n] == symbol)
                    return symbol;
            }
            if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
                return symbol;
            if (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol)
                return symbol;
        }
        return Figure.NONE;
    }

    public boolean areMovesPossible() {
        for (int n = 0; n < 3; n++) {
            for (int k = 0; k < 3; k++)
                if (board[n][k] == Figure.NONE)
                    return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "|---|---|---|\n";
        for (int y = 0; y < 3; y++) {
            s += "|";
            for (int x = 0; x < 3; x++) {
                s += " " + getFigureSymbol(board[x][y]) + " |";
            }
            s += "\n";
        }
        s += "|---|---|---|\n";
        return s;
    }

    public static String getFigureSymbol(Figure figure) {
        if (figure == Figure.X)
            return "X";
        if (figure == Figure.O)
            return "O";
        return " ";
    }
}
