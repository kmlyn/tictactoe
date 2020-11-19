import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {
    private Image imageback = new Image("file:src/main/resources/board.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(360, 360, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);
        for(int n = 0; n < 3; n++) {
            grid.getColumnConstraints().add(new ColumnConstraints(120));
            grid.getRowConstraints().add(new RowConstraints(120));
        }
        Game game = new Game();
        GameGfx gameGfx = new GameGfx(grid, game);
        gameGfx.displayOnGrid();

        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Tic tac toe");
        Label label= new Label("");
        Button button= new Button("Close");
        button.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);
        Scene popupScene= new Scene(layout, 250, 100);
        popupwindow.setScene(popupScene);

        grid.setOnMouseClicked(e -> {
            int x = (int) (e.getX()/120);
            int y = (int) (e.getY()/120);
            game.doMove(new Coords(x, y));
            gameGfx.displayOnGrid();
            if (game.isWinner()) {
                // show popup with information "Game over"
                // clear board
                label.setText("Game over");
                popupwindow.showAndWait();

                game.initBoard();
                gameGfx.displayOnGrid();
            } else if (!game.areMovesPossible()) {
                // show popup "game drawn"
                label.setText("Game drawn");
                popupwindow.showAndWait();

                game.initBoard();
                gameGfx.displayOnGrid();
            }
        });
        Scene scene = new Scene(grid, 360, 360, Color.WHITE);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
