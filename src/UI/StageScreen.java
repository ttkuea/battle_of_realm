package UI;

import constants.Images;
import logic.GameManager;
import logic.LogicLoop;
import main.Main;
import utilities.AudioPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class StageScreen extends Scene {
	private Pane root;
	private static GraphicsContext gc;
	GameManager gm = GameManager.getInstance();

	public StageScreen() {
		super(new Pane(), constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		root = (Pane) getRoot();

		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);

		ImageView nextButton = new ImageView(constants.Images.nextButton);
		nextButton.setX(850);
		nextButton.setY(680);
		nextButton.setOnMouseClicked(e -> {
			Main.getStage().setScene(Main.getGameScreen());
			LogicLoop.getInstance().call();
			Main.getGameScreen().update();
			Main.getGameScreen().setSkillVisible(false);

			gm.loadMapEntity();
			gm.setStageScreen(false);
			gm.setGameScreen(true);

			LogicLoop.getInstance().setShouldRun(true);
			AudioPlayer.getInstance().pauseWorldBGM();
			if (gm.getStageNumber() == 6) {
				AudioPlayer.getInstance().playBossBGM();
			} else {
				AudioPlayer.getInstance().playBattleBGM();
			}
			
		});
		;

		nextButton.setOnMouseEntered(e -> {
			nextButton.setImage(Images.nextButtonHover);
		});

		nextButton.setOnMouseExited(e -> {
			nextButton.setImage(Images.nextButton);
		});

		root.getChildren().add(nextButton);

		KeyFrame kf = new KeyFrame(Duration.seconds(1. / 60), e -> {
			render();
		});

		Timeline stageScreenLoop = new Timeline();
		stageScreenLoop.setCycleCount(Timeline.INDEFINITE);
		stageScreenLoop.getKeyFrames().add(kf);
		stageScreenLoop.play();
	}

	public static void render() {
		gc.drawImage(constants.Images.worldMaps[GameManager.getInstance().getStageNumber() - 1], 0, 0);
	}

}
