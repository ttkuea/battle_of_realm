package logic;

import SharedObject.RenderableHolder;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import main.Main;
import particle.NormalParticle;
import sprite.HealthEntity;
import sprite.enemy.Enemy;
import sprite.player.Archer;
import sprite.player.Warrior;
import sprite.player.Wizard;
import utilities.AudioPlayer;
import utilities.Random;

public class LogicLoop {
	private static LogicLoop instance = new LogicLoop();

	private Timeline logicLoop;
	
	private boolean shouldRun = false;
	
	private HealthEntity currentTurn;

	private Warrior warrior = GameManager.getInstance().getWarrior();
	private Wizard wizard = GameManager.getInstance().getWizard();
	private Archer archer = GameManager.getInstance().getArcher();

	public LogicLoop() {
		logicLoop = new Timeline(new KeyFrame(Duration.seconds(1. / 60), e -> {
			if (shouldRun) {	
				update();
				GameManager.getInstance().update();
			}
		}));
		logicLoop.setCycleCount(Timeline.INDEFINITE);
		logicLoop.play();
	}

	public void update() {
		RenderableHolder.getInstance().update();
		updateATB();
		callQueue();
	}
	
	public void updateATB() {
		if (!warrior.isATBFull())
			if (!warrior.isDead()) warrior.setCurrentATB(warrior.getCurrentATB() + (warrior.getSpeed()*.02));
			else warrior.setCurrentATB(0);
		else {
			if (!warrior.isInQueue() && !warrior.isDead()) {
				GameManager.getInstance().addToQueue(warrior);
				for (int i = 0; i < warrior.getSkillList().size(); i++) {
					warrior.getSkillList().get(i).reduceCooldown();
				}
			}
		}

		if (!wizard.isATBFull())
			if (!wizard.isDead())wizard.setCurrentATB(wizard.getCurrentATB() + (wizard.getSpeed()*.02));
			else wizard.setCurrentATB(0);
		else {
			if (!wizard.isInQueue() && !wizard.isDead()) {
				GameManager.getInstance().addToQueue(wizard);
				for (int i = 0; i < wizard.getSkillList().size(); i++) {
					wizard.getSkillList().get(i).reduceCooldown();
				}
			}
		}

		if (!archer.isATBFull())
			if (!archer.isDead())archer.setCurrentATB(archer.getCurrentATB() + (archer.getSpeed()*.02));
			else archer.setCurrentATB(0);
		else {
			if (!archer.isInQueue() && !archer.isDead()) {
				GameManager.getInstance().addToQueue(archer);
				for (int i = 0; i < archer.getSkillList().size(); i++) {
					archer.getSkillList().get(i).reduceCooldown();
				}
			}
		}
		
		for (HealthEntity e: GameManager.getInstance().getEnemies()) {
			if (!e.isATBFull())
				if (!e.isDead()) e.setCurrentATB(e.getCurrentATB()+(e.getSpeed()*.02));
				else e.setCurrentATB(0);
			else {
				if (!e.isInQueue() && !e.isDead()) {
					GameManager.getInstance().addToQueue(e);
				}
			}
		}
		
	}
	
	public void callQueue() {
		if (GameManager.getInstance().canCallQueue()) {
			
			currentTurn = GameManager.getInstance().getTopQueue();
			
			if (currentTurn instanceof Warrior || currentTurn instanceof Wizard || currentTurn instanceof Archer) {
				Main.getGameScreen().setSkillVisible(true);
				Main.getGameScreen().setSkills(currentTurn.getSkillIcon());
				Main.getGameScreen().setCurrentTurn(currentTurn);getClass();
				Main.getGameScreen().cooldownLabelHandler();
			}
			
			if (currentTurn instanceof Enemy) {
				//Do AI random hit
				Main.getGameScreen().setSkillVisible(false);
				if (!currentTurn.isDead()) {
					int pos = Random.randInt(0, 2);
					while(GameManager.getInstance().getFriend(pos).isDead()) {
						pos = Random.randInt(0, 2);
					}
					currentTurn.getSkillList().get(0).use(GameManager.getInstance().getFriend(pos));
					currentTurn.setState(1);
					RenderableHolder.getInstance().add(new NormalParticle((int) GameManager.getInstance().getFriend(pos).getX(), (int) GameManager.getInstance().getFriend(pos).getY()));
					AudioPlayer.getInstance().playHitSound();
					
					currentTurn.setCurrentATB(0);
					currentTurn.setInQueue(false);	
					System.out.println(currentTurn.getName() + " Attack->"+GameManager.getInstance().getFriend(pos));
				}
				
				GameManager.getInstance().nextQueue();
				
			}
		}else {
			Main.getGameScreen().setSkillVisible(false);
		}
	}
	
	public void call() {
		System.out.println("Logic Run");
		System.out.println("--------------------------");
	}

	public static LogicLoop getInstance() {
		return instance;
	}

	public boolean isShouldRun() {
		return shouldRun;
	}

	public void setShouldRun(boolean shouldRun) {
		this.shouldRun = shouldRun;
	}

}
