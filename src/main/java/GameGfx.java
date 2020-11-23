import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class GameGfx {
    private GridPane grid;
    private Game game;
    private Image circle = new Image("file:src/main/resources/kolko.png");
    private Image cross = new Image("file:src/main/resources/krzyzyk.png");

    public GameGfx(GridPane grid, Game game) {
        this.grid = grid;
        this.game = game;
        grid.setAlignment(Pos.CENTER);
    }

    public void displayOnGrid() {
        grid.getChildren().clear();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ImageView imageView = null;
                Figure figure = game.getFigure(col, row);
                if (figure == Figure.X )
                    imageView = new ImageView(cross);
                if (figure == Figure.O)
                    imageView = new ImageView(circle);
                if (imageView != null) {
                    grid.add(imageView, col, row);
                    GridPane.setHalignment(imageView, HPos.CENTER);
                }
            }
        }
    }
}
