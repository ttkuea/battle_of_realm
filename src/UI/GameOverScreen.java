package UI;

import constants.Constant;
import constants.Images;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GameOverScreen extends Scene {
	private Pane root;
	private static GraphicsContext gc;
	
	public GameOverScreen() {
		super(new Pane(), Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
		
		this.root = (Pane) getRoot();
		
		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.drawImage(Images.gameOver, 0, 0);
		
		root.getChildren().add(canvas);
		
		ImageView quitButton = new ImageView();
		quitButton.setImage(Images.quitButton);
		quitButton.setX(400);
		quitButton.setY(550);
		
		quitButton.setOnMouseClicked(e->{
			System.exit(0);
		});
		
		root.getChildren().add(quitButton);
		
	}
	
	

}
