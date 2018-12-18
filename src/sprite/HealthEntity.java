package sprite;

import java.util.ArrayList;

import javafx.scene.image.Image;
import skill.Skill;

public abstract class HealthEntity extends Entity {
	private int MAXHP;
	private int currentHP;
	private int atk;
	private int defense;
	private int speed;
	private double criticalRate;

//  ATB; Active Time Battle -> for calculating turns
	private final double MAXATB = 100;
	private double currentATB = 0;
	private boolean inQueue = false;

	private String name;

	public HealthEntity(int z, double x, double y, int maxHP, int atk, int def, int spd, double criRate, String name) {
		super(z, x, y);
		this.MAXHP = maxHP;
		this.currentHP = maxHP;
		this.atk = atk;
		this.defense = def;
		this.speed = spd;
		this.criticalRate = criRate;
		this.name = name;
	}

	// Abstract
	public abstract ArrayList<Image> getSkillIcon();

	public abstract ArrayList<Skill> getSkillList();

	public abstract void setState(int state);

	public abstract ArrayList<Image> getIdleImagesList(); // every character should have idle image
	
	public void update() {
		if (this.isDead()) {
			this.visible = false;
		}
	}

	public boolean attack(HealthEntity e) {
		e.takeDamage(this.getAtk());
		return true;
	}

	public void takeDamage(int damage) {
		int trueDamage = damage - this.defense;
		if (trueDamage > 0) {
			if (this.currentHP - trueDamage <= 0)
				this.currentHP = 0;
			else
				this.currentHP -= trueDamage;
		}
	}

	public void heal(int hp) {
		this.currentHP += hp;
		if (this.currentHP > this.MAXHP)
			this.currentHP = this.MAXHP;
	}

	public boolean isDead() {
		return this.currentHP <= 0;
	}

	public boolean isATBFull() {
		return this.currentATB >= this.MAXATB;
	}

	// Getters and Setters
	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public double getCriticalRate() {
		return criticalRate;
	}

	public void setCriticalRate(double criticalRate) {
		this.criticalRate = criticalRate;
	}

	public double getCurrentATB() {
		return currentATB;
	}

	public void setCurrentATB(double currentATB) {
		this.currentATB = currentATB;
		if (currentATB > this.MAXATB)
			this.currentATB = this.MAXATB;
	}

	public int getMAXHP() {
		return MAXHP;
	}

	public void setMAXHP(int mAXHP) {
		MAXHP = mAXHP;
	}

	public double getMAXATB() {
		return MAXATB;
	}

	public String getName() {
		return name;
	}

	public boolean isInQueue() {
		return inQueue;
	}

	public void setInQueue(boolean inQueue) {
		this.inQueue = inQueue;
	}

}
