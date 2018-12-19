package logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;

import SharedObject.RenderableHolder;
import constants.Constant;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import main.Main;
import particle.CircleParticle;
import particle.NormalParticle;
import sprite.HealthEntity;
import sprite.enemy.Enemy;
import sprite.player.Archer;
import sprite.player.Warrior;
import sprite.player.Wizard;
import utilities.AudioPlayer;
import utilities.QueueExitAnimation;
import utilities.Random;
import utilities.cpp;
import utilities.cpp.Pair;

public class LogicLoop {
	private static LogicLoop instance = new LogicLoop();

	private Timeline logicLoop;
	
	private boolean shouldRun = false;
	
	private HealthEntity currentTurn;

	private Warrior warrior = GameManager.getInstance().getWarrior();
	private Wizard wizard = GameManager.getInstance().getWizard();
	private Archer archer = GameManager.getInstance().getArcher();
	private int queueCooldown = 0;
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
		updateQueue();
//		updateATB(); // delet this later
		updateQueueAnim();
		if (queueCooldown == 0) {
			callQueue();			
		}
		else {
			queueCooldown--;
		}
	}
	
	PriorityQueue<Pair<Double, HealthEntity>> temp_q = new PriorityQueue<>();; 
	public void updateQueue() {
		ArrayList<Integer> animList = GameManager.getInstance().getAnimList();
		ArrayList<QueueExitAnimation> exitAnim = GameManager.getInstance().getExitAnimList();
		Queue<HealthEntity> turnQueue = GameManager.getInstance().getTurnQueue();
		Iterator<HealthEntity> it = turnQueue.iterator();
		ArrayList<HealthEntity> deadList = new ArrayList<>(); // deferred removal
		double pos = 0;
		for (int i=0; i<animList.size(); ++i) {
			HealthEntity cur = it.next();
			if (cur.isDead()) {
				int last = animList.get(i);
				animList.remove(i); // remove from queue
				if (animList.size() > i) { // has index `i`
					animList.set(i, animList.get(i)+last+Constant.queueGridSize); // make space for next queue
				}
				--i;
				deadList.add(cur); // defer delete
				exitAnim.add(new QueueExitAnimation(cur, pos+last, 0)); // add remove anim
			}
			else {
				pos += animList.get(i)+Constant.queueGridSize;
			}
		}
		for (HealthEntity d: deadList)
			turnQueue.remove(d);
		
		
		temp_q.clear();
		ArrayList<HealthEntity> friends = GameManager.getInstance().getFriends();
		ArrayList<HealthEntity> enemies = GameManager.getInstance().getEnemies();
		for (HealthEntity f: friends) {
			if (f.isDead()) continue;
			for (int i=1; i<=10; i++) 
				temp_q.add(new Pair<Double, HealthEntity>(f.getMAXATB()*(f.getTurnCount()+i), f));				
		}
		for (HealthEntity e: enemies) {
			if (e.isDead()) continue; 
			for (int i=1; i<=10; i++) 
				temp_q.add(new Pair<Double, HealthEntity>(e.getMAXATB()*(e.getTurnCount()+i), e));
		}
		
		Queue<HealthEntity> q = GameManager.getInstance().getTurnQueue();
		while (q.size() < 10) { // desired length
			Pair<Double, HealthEntity> top = temp_q.poll();
			System.out.printf("top is %s = %.2f\n", top.second.getClass().getSimpleName(), top.first);
			GameManager.getInstance().addToQueue(top.second);
			top.second.increaseTurnCount();
		}
	}
	
	private void updateQueueAnim() {
		ArrayList<Integer> anim = GameManager.getInstance().getAnimList();
		for (int i=0; i<anim.size(); ++i) {
			if (anim.get(i) > 0)
				anim.set(i, anim.get(i) - Constant.queuePushDownSpeed);
		}
		// TODO: change num
		ArrayList<QueueExitAnimation> exitAnim = GameManager.getInstance().getExitAnimList();
		for (int i=0; i<exitAnim.size(); ++i) {
			QueueExitAnimation fp =  exitAnim.get(i);
			fp.yPos+=Constant.queuePushDownSpeed;
			if (fp.yPos > 128) {
				exitAnim.remove(i);
				--i;
			}
		}
	}
	/*
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
	*/
	
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
					RenderableHolder.getInstance().add(new CircleParticle((int)(currentTurn.getX()-30), (int)(currentTurn.getY()-30)));
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

	
	
	public int getQueueCooldown() {
		return queueCooldown;
	}

	public void setQueueCooldown(int queueCooldown) {
		this.queueCooldown = queueCooldown;
	}

	public void setShouldRun(boolean shouldRun) {
		this.shouldRun = shouldRun;
	}

}
