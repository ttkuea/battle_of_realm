package sprite.player;

import java.util.ArrayList;
import java.util.Collections;

import constants.Images;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import skill.HealSkill;
import skill.NormalAttack;
import skill.Skill;
import skill.SplashSkill;
import sprite.HealthEntity;

public class Wizard extends HealthEntity {
	private ArrayList<Image> idleImagesList; // 0

	private ArrayList<Image> atkImagesList; // 1

	private ArrayList<Image> skillIconList;

	private ArrayList<Skill> skillList;

	private int state = 0;
	private int animationCounter = 1;
	private int renderTick = 0;

	public Wizard(int z, double x, double y, int maxHP, int atk, int def, int spd, double criRate, String name) {
		super(z, x, y, maxHP, atk, def, spd, criRate, name);
		idleImagesList = new ArrayList<Image>();
		atkImagesList = new ArrayList<Image>();

		skillList = new ArrayList<Skill>();
		skillIconList = new ArrayList<Image>();
		updateImageList();
		updateSkillList();
	}

	public void updateImageList() {
		Collections.addAll(idleImagesList, constants.Images.wizardIdle1, constants.Images.wizardIdle2,
				constants.Images.wizardIdle3);

		Collections.addAll(atkImagesList, Images.wizardIdle1, Images.wizardAtk1, Images.wizardAtk2, Images.wizardIdle1);
	}

	public void updateSkillList() {
		Collections.addAll(skillIconList, constants.Images.wizardSkill1Icon, constants.Images.wizardSkill2Icon,
				constants.Images.wizardHealIcon);
		Collections.addAll(skillIconList, Images.wizardSkill1CD, Images.wizardSkill2CD, Images.wizardHealCD);
		NormalAttack skill1 = new NormalAttack(0, this);
		SplashSkill skill2 = new SplashSkill(3, this);
		HealSkill skill3 = new HealSkill(4, this);
		Collections.addAll(skillList, skill1, skill2, skill3);
	}

	@Override
	public void draw(GraphicsContext gc) {
		renderTick++;
		if (!isDead()) {
			switch (state) {
			case 0:
				gc.drawImage(idleImagesList.get(renderTick % 60 * idleImagesList.size() / 60), this.x, this.y);
				break;
			case 1:
				if (animationCounter != 70) {
					gc.drawImage(atkImagesList.get(animationCounter % 60 * atkImagesList.size() / 60), this.x, this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			case 2:
				if (animationCounter != 70) {
					gc.drawImage(atkImagesList.get(animationCounter % 60 * atkImagesList.size() / 60), this.x, this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			case 3:
				if (animationCounter != 70) {
					gc.drawImage(atkImagesList.get(animationCounter % 60 * atkImagesList.size() / 60), this.x, this.y);
					animationCounter++;
				} else {
					this.state = 0;
					animationCounter = 1;
				}
				break;
			}
		}
	}

	@Override
	public ArrayList<Image> getSkillIcon() {
		return skillIconList;
	}

	@Override
	public ArrayList<Skill> getSkillList() {
		return skillList;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void updateStat(int[] stats) {
		this.setMAXHP(stats[0]);
		this.setCurrentHP(stats[0]);
		this.setAtk(stats[1]);
		this.setDefense(stats[2]);
		this.setSpeed(stats[3]);
		this.setCriticalRate(stats[4]);
		this.setCurrentATB(0);

		for (Skill s : skillList) {
			s.setCurrentCooldown(0);
		}
	}
}
