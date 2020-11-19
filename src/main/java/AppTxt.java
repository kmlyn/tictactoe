public class AppTxt {
    public static void main(String[] args) {
        Game game = new Game();
        while(true) {
            System.out.println(game);
            Coords coords = UserDialogs.getCoords();
            game.doMove(coords);
            if(game.isWinner() || !game.areMovesPossible())
                break;
        }
    }
}
