package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import SharedObject.RenderableHolder;
import constants.Constant;
import main.Main;
import UI.map.Map;
import UI.map.Map_Stage1;
import UI.map.Map_Stage2;
import UI.map.Map_Stage3;
import UI.map.Map_Stage4;
import UI.map.Map_Stage5;
import UI.map.Map_StageBoss;
import UI.statusbar.StatusBar;
import sprite.HealthEntity;
import sprite.player.Archer;
import sprite.player.Warrior;
import sprite.player.Wizard;
import utilities.AudioPlayer;
import utilities.QueueExitAnimation;

public class GameManager {
	private static GameManager instance = new GameManager();
	
	private boolean isMainScreen = true;
	private boolean isStageScreen = false;
	private boolean isGameScreen = false;

	private int stageNumber = 1; // Check Game state

	private Warrior warrior = new Warrior(1, 250, 50, 70, 12, 10, 10, 5, "Warrior");
	private Wizard wizard = new Wizard(1, 60, 180, 70, 10, 7, 15, 5, "Wizard");
	private Archer archer = new Archer(1, 230, 330, 70, 15, 7, 11, 5, "Archer");

	private StatusBar statusBar = new StatusBar(1);

	private Map[] maps = { new Map_Stage1(), new Map_Stage2(), new Map_Stage3(), new Map_Stage4(), new Map_Stage5(),
			new Map_StageBoss() };

	private Queue<HealthEntity> turnQueue = new LinkedList<>();
	private ArrayList<Integer> animList = new ArrayList<>();
	private ArrayList<QueueExitAnimation> exitAnimList = new ArrayList<>();
	private ArrayList<HealthEntity> enemies = new ArrayList<>();
	private ArrayList<HealthEntity> friends = new ArrayList<>();

	private boolean isSelectSkill = false;
	private boolean isSelectTarget = false;
	private int targetNo = 0;
	// --------------------------------

	public GameManager() {
		loadMapEntity();
		RenderLoop.getInstance().call();
		Collections.addAll(friends, warrior, wizard, archer);
	}

	public void addToQueue(HealthEntity e) {
		System.out.println("Queue add " + e.getName());
		turnQueue.add(e);
		animList.add(64); // TODO: better value
		System.out.println("Queue Size = " + turnQueue.size());
		e.setInQueue(true);
	}

	public void nextQueue() {
		HealthEntity character  = turnQueue.poll();
		
		int last = animList.get(0);
		animList.remove(0);
		if (animList.size() > 0)
			animList.set(0, last+80); // 80 = CHAR_SIZE+16;
		exitAnimList.add(new QueueExitAnimation(character, last, 0));
		LogicLoop.getInstance().setQueueCooldown(50);
	}

	public HealthEntity getTopQueue() {
		return turnQueue.peek(); // null if queue is empty
	}

	public boolean canCallQueue() {
		return turnQueue.size() > 0;
	}

	public void loadMapEntity() {
		RenderableHolder.getInstance().clearEntities();
		RenderableHolder.getInstance().add(warrior);
		RenderableHolder.getInstance().add(wizard);
		RenderableHolder.getInstance().add(archer);
		RenderableHolder.getInstance().add(statusBar);
		RenderableHolder.getInstance().add(getMaps(getStageNumber()));
		enemies = getMaps(getStageNumber()).getEnemies();
	}

	public void update() {
		boolean friendsAllDead = true;
		boolean enemiesAllDead = true;

		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).update();
			if (!enemies.get(i).isDead())
				enemiesAllDead = false;

		}
		for (int i = 0; i < friends.size(); i++) {
			friends.get(i).update();
			if (!friends.get(i).isDead())
				friendsAllDead = false;
		}

		if (friendsAllDead) { // GameOver
			Main.getStage().setScene(Main.getGameOverScreen());

			LogicLoop.getInstance().setShouldRun(false);
			System.out.println("Logic stop");

			AudioPlayer.getInstance().pauseBattleBGM();
			AudioPlayer.getInstance().playGameOverBGM();

		}
		if (enemiesAllDead) { // win map
			
			Main.getGameScreen().setSkillVisible(false);

			if (stageNumber < 6) {
				AudioPlayer.getInstance().pauseBattleBGM();
				AudioPlayer.getInstance().playVictoryBGM();
				Main.getStage().setScene(Main.getLvUpScreen());
				setStageNumber(getStageNumber() + 1);
				LogicLoop.getInstance().setShouldRun(false);
				System.out.println("Logic stop");

				this.turnQueue.clear();
				this.animList.clear();
				this.exitAnimList.clear();
				System.out.println("Queue Clear = " + turnQueue.size());

				// Update Stats
				warrior.updateStat(Constant.warriorStat[stageNumber]);
				wizard.updateStat(Constant.wizardStat[stageNumber]);
				archer.updateStat(Constant.archerStat[stageNumber]);

				warrior.setInQueue(false);
				wizard.setInQueue(false);
				archer.setInQueue(false);

				Main.getGameScreen().setSkillVisible(false);

				this.isGameScreen = false;
				this.isStageScreen = false;
			} else {
				AudioPlayer.getInstance().pauseBossBGM();
				AudioPlayer.getInstance().playVictoryBGM();
				
				Main.getStage().setScene(Main.getEndGameScreen());
				LogicLoop.getInstance().setShouldRun(false);
				System.out.println("Logic stop");
			}
		}
	}

	// Getters and Setters
	public static GameManager getInstance() {
		return instance;
	}

	public Warrior getWarrior() {
		return warrior;
	}

	public Wizard getWizard() {
		return wizard;
	}

	public Archer getArcher() {
		return archer;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public Map getMaps(int index) { // 1-6
		return maps[index - 1];
	}

	public int getStageNumber() {
		return stageNumber;
	}

	public void setStageNumber(int stageNumber) {
		this.stageNumber = stageNumber;
	}

	public boolean isMainScreen() {
		return isMainScreen;
	}

	public void setMainScreen(boolean isMainScreen) {
		this.isMainScreen = isMainScreen;
	}

	public boolean isStageScreen() {
		return isStageScreen;
	}

	public void setStageScreen(boolean isStageScreen) {
		this.isStageScreen = isStageScreen;
	}

	public boolean isGameScreen() {
		return isGameScreen;
	}

	public void setGameScreen(boolean isGameScreen) {
		this.isGameScreen = isGameScreen;
	}

	public ArrayList<HealthEntity> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<HealthEntity> enemies) {
		this.enemies = enemies;
	}

	public HealthEntity getEnemy(int targetNo) {
		return enemies.get(targetNo);
	}

	public ArrayList<HealthEntity> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<HealthEntity> friends) {
		this.friends = friends;
	}

	public HealthEntity getFriend(int targetNo) {
		return friends.get(targetNo);
	}
	
	
	

	public ArrayList<QueueExitAnimation> getExitAnimList() {
		return exitAnimList;
	}

	public void setExitAnimList(ArrayList<QueueExitAnimation> exitAnimList) {
		this.exitAnimList = exitAnimList;
	}

	public Queue<HealthEntity> getTurnQueue() {
		return turnQueue;
	}

	public ArrayList<Integer> getAnimList() {
		return animList;
	}

	public int getTargetNo() {
		return targetNo;
	}

	public void setTargetNo(int targetNo) {
		this.targetNo = targetNo;
	}

	public boolean isSelectTarget() {
		return isSelectTarget;
	}

	public void setSelectTarget(boolean isSelectTarget) {
		this.isSelectTarget = isSelectTarget;
	}

	public boolean isSelectSkill() {
		return isSelectSkill;
	}

	public void setSelectSkill(boolean isSelectSkill) {
		this.isSelectSkill = isSelectSkill;
	}
}
