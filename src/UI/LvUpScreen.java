package UI;

import constants.Constant;
import constants.Fonts;
import constants.Images;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.util.Duration;
import logic.GameManager;
import main.Main;
import utilities.AudioPlayer;

public class LvUpScreen extends Scene {
	private Pane root;
	private static GraphicsContext gc;
	private static GameManager gm = GameManager.getInstance();

	public LvUpScreen() {
		super(new Pane(), constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		root = (Pane) getRoot();

		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);

		ImageView nextButton = new ImageView(constants.Images.nextButton);
		nextButton.setX(850);
		nextButton.setY(680);
		nextButton.setOnMouseClicked(e -> {
			gm.setStageScreen(true);
			gm.setGameScreen(false);

			Main.getStage().setScene(Main.getStageScreen());
			System.out.println("Next Stage = " + gm.getStageNumber());

			AudioPlayer.getInstance().pauseVictoryBGM();
			AudioPlayer.getInstance().playWorldBGM();
		});

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
		gc.setFill(Color.LIGHTGOLDENRODYELLOW);
		gc.fillRect(0, 0, Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);

		gc.setFill(Color.PURPLE);
		gc.setFont(Fonts.statusFont);
		gc.fillText("Status Up!", 400, 80);

		gc.setFill(Color.LIGHTSKYBLUE);
		gc.fillRoundRect(90, 120, 250, 500, 15, 15);
		gc.fillRoundRect(387, 120, 250, 500, 15, 15);
		gc.fillRoundRect(684, 120, 250, 500, 15, 15);
		gc.setStroke(Color.BLACK);
		gc.strokeRoundRect(90, 120, 250, 500, 15, 15);
		gc.strokeRoundRect(387, 120, 250, 500, 15, 15);
		gc.strokeRoundRect(684, 120, 250, 500, 15, 15);

		gc.drawImage(Images.warriorIdle1, 150, 100);
		gc.drawImage(Images.wizardIdle1, 460, 120);
		gc.drawImage(Images.archerIdle1, 770, 120);

		drawText();
	}

	public static void drawText() {
		gc.setFont(Fonts.nameFont);
		gc.setFill(Color.BLACK);

		gc.fillText("HP     : " + Constant.warriorStat[gm.getStageNumber() - 1][0] + " -> "
				+ Constant.warriorStat[gm.getStageNumber()][0], 100, 290);
		gc.fillText("ATK  : " + Constant.warriorStat[gm.getStageNumber() - 1][1] + " -> "
				+ Constant.warriorStat[gm.getStageNumber()][1], 100, 350);
		gc.fillText("DEF : " + Constant.warriorStat[gm.getStageNumber() - 1][2] + " -> "
				+ Constant.warriorStat[gm.getStageNumber()][2], 100, 410);
		gc.fillText("SPD : " + Constant.warriorStat[gm.getStageNumber() - 1][3] + " -> "
				+ Constant.warriorStat[gm.getStageNumber()][3], 100, 470);
		gc.fillText("CRI     : " + Constant.warriorStat[gm.getStageNumber() - 1][4] + " -> "
				+ Constant.warriorStat[gm.getStageNumber()][4], 100, 530);

		gc.fillText("HP     : " + Constant.wizardStat[gm.getStageNumber() - 1][0] + " -> "
				+ Constant.wizardStat[gm.getStageNumber()][0], 400, 290);
		gc.fillText("ATK  : " + Constant.wizardStat[gm.getStageNumber() - 1][1] + " -> "
				+ Constant.wizardStat[gm.getStageNumber()][1], 400, 350);
		gc.fillText("DEF : " + Constant.wizardStat[gm.getStageNumber() - 1][2] + " -> "
				+ Constant.wizardStat[gm.getStageNumber()][2], 400, 400);
		gc.fillText("SPD : " + Constant.wizardStat[gm.getStageNumber() - 1][3] + " -> "
				+ Constant.wizardStat[gm.getStageNumber()][3], 400, 470);
		gc.fillText("CRI     : " + Constant.wizardStat[gm.getStageNumber() - 1][4] + " -> "
				+ Constant.wizardStat[gm.getStageNumber()][4], 400, 530);

		gc.fillText("HP     : " + Constant.archerStat[gm.getStageNumber() - 1][0] + " -> "
				+ Constant.archerStat[gm.getStageNumber()][0], 700, 290);
		gc.fillText("ATK  : " + Constant.archerStat[gm.getStageNumber() - 1][1] + " -> "
				+ Constant.archerStat[gm.getStageNumber()][1], 700, 350);
		gc.fillText("DEF : " + Constant.archerStat[gm.getStageNumber() - 1][2] + " -> "
				+ Constant.archerStat[gm.getStageNumber()][2], 700, 410);
		gc.fillText("SPD : " + Constant.archerStat[gm.getStageNumber() - 1][3] + " -> "
				+ Constant.archerStat[gm.getStageNumber()][3], 700, 470);
		gc.fillText("CRI     : " + Constant.archerStat[gm.getStageNumber() - 1][4] + " -> "
				+ Constant.archerStat[gm.getStageNumber()][4], 700, 530);
	}

}