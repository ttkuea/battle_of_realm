package UI;

import java.util.ArrayList;

import UI.map.Map;
import constants.Constant;
import exception.CooldownException;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import logic.GameManager;
import logic.MouseHandler;
import sprite.HealthEntity;

public class GameScreen extends Scene {
	private Pane root;
	private static GraphicsContext gc;
	private GameManager gm = GameManager.getInstance();

	private Map currentMap;
	private HealthEntity currentTurn;

	private int skillNo = 0;
	private MouseHandler mouseHandler;

	private ImageView skill1, skill2, skill3;
	private Label cooldown1, cooldown2, cooldown3;

	public GameScreen() {
		super(new Pane(), Constant.SCREEN_WIDTH, Constant.SCREEN_HEIGHT);
		root = (Pane) getRoot();

		Canvas canvas = new Canvas(constants.Constant.SCREEN_WIDTH, constants.Constant.SCREEN_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);

		this.currentMap = GameManager.getInstance().getMaps(GameManager.getInstance().getStageNumber());

		mouseHandler = new MouseHandler(GameManager.getInstance());
		mouseHandler(canvas);

		// Skill Button
		skill1 = new ImageView();
		skill1.setX(700);
		skill1.setY(500);

		skill2 = new ImageView();
		skill2.setX(800);
		skill2.setY(500);

		skill3 = new ImageView();
		skill3.setX(900);
		skill3.setY(500);

		skillEventHandler(skill1, skill2, skill3);

		// Skill CoolDown Label
		cooldown1 = new Label();
		cooldown1.setLayoutX(730);
		cooldown1.setLayoutY(520);
		cooldown1.setFont(constants.Fonts.nameFont);

		cooldown2 = new Label();
		cooldown2.setLayoutX(830);
		cooldown2.setLayoutY(520);
		cooldown2.setFont(constants.Fonts.nameFont);

		cooldown3 = new Label();
		cooldown3.setLayoutX(930);
		cooldown3.setLayoutY(520);
		cooldown3.setFont(constants.Fonts.nameFont);

		root.getChildren().addAll(skill1, skill2, skill3);
		root.getChildren().addAll(cooldown1, cooldown2, cooldown3);

	}

	public void mouseHandler(Canvas canvas) {
		canvas.setOnMouseClicked(e -> {
			mouseHandler.handleClick(e);
		});
	}

	public void update() {
		this.currentMap = GameManager.getInstance().getMaps(GameManager.getInstance().getStageNumber());
	}

	public void skillEventHandler(ImageView skill1, ImageView skill2, ImageView skill3) {
		skill1.setOnMouseClicked(e -> {
			System.out.println("Skill1");
			try {
				boolean ready = currentTurn.getSkillList().get(0).isReady();
				if (ready) {
					gm.setSelectSkill(true);
					skillNo = 1;
					System.out.println("Choose Target");
				}
			} catch (CooldownException ex) {
				System.out.println("Skill1 Cooldown");
			}
			setSkillVisible(false);
		});

		skill2.setOnMouseClicked(e -> {
			System.out.println("Skill2");
			try {
				boolean ready = currentTurn.getSkillList().get(1).isReady();
				if (ready) {
					gm.setSelectSkill(true);
					skillNo = 2;
					System.out.println("Choose Target");
				}
			} catch (CooldownException ex) {
				System.out.println("Skill2 Cooldown");
			}
			setSkillVisible(false);
		});

		skill3.setOnMouseClicked(e -> {
			System.out.println("Skill3");
			try {
				boolean ready = currentTurn.getSkillList().get(2).isReady();
				if (ready) {
					gm.setSelectSkill(true);
					skillNo = 3;
					System.out.println("Choose Target");
				}
			} catch (CooldownException ex) {
				System.out.println("Skill3 Cooldown");
			}
			setSkillVisible(false);
		});
	}

	public void cooldownLabelHandler() {
		try {
			boolean ready = currentTurn.getSkillList().get(0).isReady();
			cooldown1.setVisible(false);
		} catch (CooldownException ex) {
			cooldown1.setVisible(true);
			cooldown1.setText("" + currentTurn.getSkillList().get(0).getCurrentCooldown());
			skill1.setImage(currentTurn.getSkillIcon().get(3));
		}

		try {
			boolean ready = currentTurn.getSkillList().get(1).isReady();
			cooldown2.setVisible(false);
		} catch (CooldownException ex) {
			cooldown2.setVisible(true);
			cooldown2.setText("" + currentTurn.getSkillList().get(1).getCurrentCooldown());
			skill2.setImage(currentTurn.getSkillIcon().get(4));
		}

		try {
			boolean ready = currentTurn.getSkillList().get(2).isReady();
			cooldown3.setVisible(false);
		} catch (CooldownException ex) {
			cooldown3.setVisible(true);
			cooldown3.setText("" + currentTurn.getSkillList().get(2).getCurrentCooldown());
			skill3.setImage(currentTurn.getSkillIcon().get(5));
		}

	}

	// Getters and Setters
	public Map getCurrentMap() {
		return currentMap;
	}

	public void setCurrentMap(Map currentMap) {
		this.currentMap = currentMap;
	}

	public static GraphicsContext getGc() {
		return gc;
	}

	public HealthEntity getCurrentTurn() {
		return currentTurn;
	}

	public void setCurrentTurn(HealthEntity currentTurn) {
		this.currentTurn = currentTurn;
	}

	// Setters for skill box
	public void setSkills(ArrayList<Image> arr) {
		skill1.setImage(arr.get(0));
		skill2.setImage(arr.get(1));
		skill3.setImage(arr.get(2));
	}

	public void setSkillVisible(boolean visible) {
		skill1.setVisible(visible);
		skill2.setVisible(visible);
		skill3.setVisible(visible);
	}

	public int getSkillNo() {
		return skillNo;
	}

	public void setSkillNo(int skillNo) {
		this.skillNo = skillNo;
	}

}
