package main;

import UI.EndGameScreen;
import UI.GameOverScreen;
import UI.GameScreen;
import UI.LvUpScreen;
import UI.MainScreen;
import UI.StageScreen;
import constants.Images;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	private static MainScreen mainScreen;
	private static StageScreen stageScreen;
	private static GameScreen gameScreen;
	private static LvUpScreen lvUpScreen;
	private static EndGameScreen endGameScreen;
	private static GameOverScreen gameOverScreen;
	
	private static Stage stage;
	
	public void start(Stage primaryStage){
		stage = primaryStage;
		mainScreen = new MainScreen();
		stageScreen = new StageScreen();
		gameScreen = new GameScreen();
		lvUpScreen = new LvUpScreen();
		endGameScreen = new EndGameScreen();
		gameOverScreen = new GameOverScreen();

		stage.setTitle("Battle of Realm");
		stage.getIcons().add(Images.Logo);
		stage.setScene(mainScreen);
		stage.show();
		
		Images.loadImages();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static StageScreen getStageScreen() {
		return stageScreen;
	}
	
	public static GameScreen getGameScreen() {
		return gameScreen;
	}

	public static MainScreen getMainScreen() {
		return mainScreen;
	}

	public static LvUpScreen getLvUpScreen() {
		return lvUpScreen;
	}

	public static EndGameScreen getEndGameScreen() {
		return endGameScreen;
	}

	public static GameOverScreen getGameOverScreen() {
		return gameOverScreen;
	}
}
