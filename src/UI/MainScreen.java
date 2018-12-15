	package UI;

import constants.Images;
import logic.GameManager;
import main.Main;
import utilities.AudioPlayer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainScreen extends Scene {
	Pane root;
	private int mainScreenStage = 0;
	private int cursorPosX = 300;
	private int cursorPosY[] = { 400, 550 };

	public MainScreen() {
		super(new Pane(), constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		root = (Pane) getRoot();

		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		render(gc);

		ImageView startButton = new ImageView();
		startButton.setImage(Images.startButton);
		startButton.setX(400);
		startButton.setY(400);

		ImageView quitButton = new ImageView();
		quitButton.setImage(Images.quitButton);
		quitButton.setX(400);
		quitButton.setY(550);

		buttonHandler(startButton, quitButton, gc);

		root.getChildren().add(canvas);
		root.getChildren().addAll(startButton, quitButton);

		AudioPlayer.getInstance().playStartBGM();
	}

	public void buttonHandler(ImageView startButton, ImageView quitButton, GraphicsContext gc) {
		startButton.setOnMouseEntered(e -> {
			mainScreenStage = 0;
			render(gc);
		});

		startButton.setOnMouseClicked(e -> {
			System.out.println("Game Start!");

			Main.getStage().setScene(Main.getStageScreen());
			GameManager.getInstance().setStageScreen(true);
			GameManager.getInstance().setMainScreen(false);

			AudioPlayer.getInstance().pauseStartBGM();
			AudioPlayer.getInstance().playStartSound();
			AudioPlayer.getInstance().playWorldBGM();
		});

		quitButton.setOnMouseEntered(e -> {
			mainScreenStage = 1;
			render(gc);
		});

		quitButton.setOnMouseClicked(e -> {
			System.exit(0);
		});
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(Images.startBG, 0, 0);
		gc.drawImage(constants.Images.cursor, cursorPosX, cursorPosY[mainScreenStage]);
	}
}
