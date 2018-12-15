package UI;

import constants.Images;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class EndGameScreen extends Scene {
	private Pane root;
	private static GraphicsContext gc;

	public EndGameScreen() {
		super(new Pane(), constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		root = (Pane) getRoot();

		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(Images.victory, 0, 0);

		root.getChildren().add(canvas);
	}
}
